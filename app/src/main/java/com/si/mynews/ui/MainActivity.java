package com.si.mynews.ui;

import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.si.mynews.app.App;
import com.si.mynews.app.Constants;
import com.si.mynews.base.BaseActivity;
import com.si.mynews.fragment.news.NewsMainFragment;
import com.si.mynews.presenter.MainPresenter;
import com.si.mynews.presenter.contract.MainContract;
import com.si.mynews.util.SharedPreferenceUtil;
import com.si.mynews.util.SnackbarUtil;
import com.si.mynews.util.SystemUtil;
import com.tbruyelle.rxpermissions.RxPermissions;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;
import si.mynews.R;


/**
 * Created by si on 16/8/9.
 */

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View{

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.drawer)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.navigation)
    NavigationView mNavigationView;

    ActionBarDrawerToggle mDrawerToggle;
    NewsMainFragment mNewsFragment;
    MenuItem mLastMenuItem;

    private int hideFragment = Constants.TYPE_NEWS;
    private int showFragment = Constants.TYPE_NEWS;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    /**
     * 由于recreate 需要特殊处理夜间模式
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int b=1/0;
        if (savedInstanceState == null) {
            SharedPreferenceUtil.setNightModeState(false);
        } else {
            showFragment = SharedPreferenceUtil.getCurrentItem();
            hideFragment = Constants.TYPE_NEWS;
            showHideFragment(getTargetFragment(showFragment), getTargetFragment(hideFragment));
            mNavigationView.getMenu().findItem(R.id.drawer_news).setChecked(false);
            mToolbar.setTitle(mNavigationView.getMenu().findItem(getCurrentItem(showFragment)).getTitle().toString());
            hideFragment = showFragment;
        }
    }

    @Override
    protected void initEventAndData() {
        setToolBar(mToolbar,"新闻专栏");
        mNewsFragment = new NewsMainFragment();
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mLastMenuItem = mNavigationView.getMenu().findItem(R.id.drawer_news);
        loadMultipleRootFragment(R.id.fl_main_content,0, mNewsFragment);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.drawer_news:
                        showFragment = Constants.TYPE_NEWS;
                        break;
                    case R.id.drawer_setting:
                        showFragment = Constants.TYPE_SETTING;
                        break;
                    case R.id.drawer_like:
                        showFragment = Constants.TYPE_LIKE;
                        break;
                    case R.id.drawer_about:
                        showFragment = Constants.TYPE_ABOUT;
                        break;
                }
                if(mLastMenuItem != null) {
                    mLastMenuItem.setChecked(false);
                }
                mLastMenuItem = menuItem;
                SharedPreferenceUtil.setCurrentItem(showFragment);
                menuItem.setChecked(true);
                mToolbar.setTitle(menuItem.getTitle());
                mDrawerLayout.closeDrawers();
                showHideFragment(getTargetFragment(showFragment), getTargetFragment(hideFragment));
                hideFragment = showFragment;
                return true;
            }
        });
        if (!SharedPreferenceUtil.getVersionPoint() && SystemUtil.isWifiConnected()) {
            SharedPreferenceUtil.setVersionPoint(true);
            try {
                PackageManager pm = getPackageManager();
                PackageInfo pi = pm.getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES);
                String versionName = pi.versionName;
                mPresenter.checkVersion(versionName);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void showError(String msg) {
        SnackbarUtil.showShort(mToolbar,msg);
    }

    @Override
    public void onBackPressedSupport() {
        showExitDialog();
    }

    private void showExitDialog() {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("确定退出吗");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                App.getInstance().exitApp();
            }
        });
        builder.show();
    }

    private SupportFragment getTargetFragment(int item) {
        switch (item) {
            case Constants.TYPE_NEWS:
                return mNewsFragment;
        }
        return mNewsFragment;
    }

    private int getCurrentItem(int item) {
        switch (item) {
            case Constants.TYPE_NEWS:
                return R.id.drawer_news;
        }
        return R.id.drawer_news;
    }

    @Override
    public void showUpdateDialog(String versionContent) {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setTitle("检测到新版本!");
        builder.setMessage(versionContent);
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("马上更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                checkPermissions();
            }
        });
        builder.show();
    }

    @Override
    public void startDownloadService() {
        //startService(new Intent(mContext, UpdateService.class));
    }

    public void checkPermissions() {
        mPresenter.checkPermissions(new RxPermissions(this));
    }
}
