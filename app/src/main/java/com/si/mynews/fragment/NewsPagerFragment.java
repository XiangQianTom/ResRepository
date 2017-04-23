package com.si.mynews.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.si.mynews.adapter.NewsListAdapter;
import com.si.mynews.app.Constants;
import com.si.mynews.base.BaseFragment;
import com.si.mynews.model.bean.NewsListBean;
import com.si.mynews.presenter.NewsPresenter;
import com.si.mynews.presenter.contract.NewsContract;
import com.si.mynews.util.SnackbarUtil;
import com.si.mynews.widget.NewsItemDecoration;
import com.si.mynews.widget.ProgressImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import si.mynews.R;

/**
 * Created by si on 16/11/27.
 */

public class NewsPagerFragment extends BaseFragment<NewsPresenter> implements NewsContract.View {

    @BindView(R.id.rv_content)
    RecyclerView rvNewsList;
    @BindView(R.id.iv_progress)
    ProgressImageView ivProgress;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    private NewsListAdapter mAdapter;
    private NewsItemDecoration mDecoration;

    private boolean isLoadingMore = false;
    private String mType;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.view_common_list;
    }

    @Override
    protected void initEventAndData() {
        mType = getArguments().getString(Constants.IT_NEWS_TYPE);
        mDecoration = new NewsItemDecoration();
        mAdapter = new NewsListAdapter(mContext, new ArrayList<>(), getArguments().getString(Constants.IT_NEWS_TYPE_STR));
        rvNewsList.setLayoutManager(new LinearLayoutManager(mContext));
        rvNewsList.setAdapter(mAdapter);
        rvNewsList.addItemDecoration(mDecoration);
        rvNewsList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItem = ((LinearLayoutManager) rvNewsList.getLayoutManager()).findLastVisibleItemPosition();
                int totalItemCount = rvNewsList.getLayoutManager().getItemCount();
                if (lastVisibleItem >= totalItemCount - 2 && dy > 0) {
                    if(!isLoadingMore){
                        isLoadingMore = true;
                        mPresenter.getMoreNewsData();
                    }
                }
            }
        });
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (!mAdapter.getHotFlag()) {
                    rvNewsList.addItemDecoration(mDecoration);
                }
                mAdapter.setHotFlag(true);
                mPresenter.getNewsData(mType);
            }
        });
        mAdapter.setOnHotCloseListener(new NewsListAdapter.OnHotCloseListener() {
            @Override
            public void onClose() {
                rvNewsList.removeItemDecoration(mDecoration);
            }
        });
        ivProgress.start();
        mPresenter.getNewsData(mType);
    }

    @Override
    public void showContent(List<NewsListBean> newsListBean) {
        if(swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        } else {
            ivProgress.stop();
        }
        mAdapter.updateData(newsListBean);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMoreContent(List<NewsListBean> newsMoreListBean, int start, int end) {
        mAdapter.updateData(newsMoreListBean);
        mAdapter.notifyItemRangeInserted(start, end);
        isLoadingMore = false;
    }

    @Override
    public void showError(String msg) {
        if(swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        } else {
            ivProgress.stop();
        }
        SnackbarUtil.showShort(rvNewsList, msg);
    }
}
