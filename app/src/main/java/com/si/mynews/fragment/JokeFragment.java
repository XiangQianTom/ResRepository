package com.si.mynews.fragment;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.si.mynews.IMySpeakInterface;
import com.si.mynews.adapter.JokePagerAdapter;
import com.si.mynews.app.App;
import com.si.mynews.base.BaseFragment;
import com.si.mynews.iflytek.MySpeakTaskCallback;
import com.si.mynews.model.bean.JokeListBean;
import com.si.mynews.presenter.JokePresenter;
import com.si.mynews.presenter.contract.JokeContract;
import com.si.mynews.service.JokeSpeakService;
import com.si.mynews.widget.RotateDownPageTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import si.mynews.R;

public class JokeFragment extends BaseFragment<JokePresenter> implements JokeContract.View {

    @BindView(R.id.vp_joke)
    ViewPager mViewPager;
    Unbinder unbinder;
    private List<JokeListBean.ListBean> mList = new ArrayList<>();
    private JokePagerAdapter mAdapter;
    private IMySpeakInterface mSpeakInterface;
    private boolean isStopSpeak = true;
    private int mPagePosition;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_joke;
    }

    @Override
    protected void initEventAndData() {
        Intent intent = new Intent(mContext, JokeSpeakService.class);
        if (!App.isAlive(JokeSpeakService.class)) {
            mContext.startService(intent);
        }
        mContext.bindService(intent, serviceConnection, 0);

        mViewPager.setPageTransformer(true, new RotateDownPageTransformer());
        mAdapter = new JokePagerAdapter(mContext, mList);

        mAdapter.setLastJokeListener(new JokePagerAdapter.LastJokeListener() {
            @Override
            public void isLastIng() {
                mPresenter.getJokeData();
            }
        });

        mViewPager.addOnPageChangeListener(pageChangeListener);
        mViewPager.setAdapter(mAdapter);
        mPresenter.getJokeData();
    }

    @Override
    public void showContent(List<JokeListBean.ListBean> listBean) {
        mAdapter.updateData(listBean);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void doAutoSpeak() {
        if (!isStopSpeak) {
            String content = mAdapter.getCurrentContent(mPagePosition);
            try {
                mSpeakInterface.speakWords(content, new MySpeakTaskCallback() {
                    @Override
                    public void speakTaskOver() throws RemoteException {
                        int position = JokeFragment.this.mPagePosition + 1;
                        mViewPager.setCurrentItem(position, true);
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void showError(String msg) {

    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mSpeakInterface = IMySpeakInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mSpeakInterface = null;
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if (null != serviceConnection) {
            try {
                mContext.unbindService(serviceConnection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            mPagePosition = position;
            try {
                mSpeakInterface.stopWords();
                doAutoSpeak();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    @OnClick(R.id.fab_joke)
    public void startSpeak() {
        isStopSpeak = !isStopSpeak;
        if (!isStopSpeak) {
            doAutoSpeak();
        } else {
            try {
                mSpeakInterface.stopWords();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
