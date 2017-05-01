package com.si.mynews.widget;

import android.support.v7.util.DiffUtil;
import android.text.TextUtils;

import com.si.mynews.model.bean.NewsListBean;

import java.util.List;

/**
 * Created by si on 17/1/2.
 */

public class NewsDiffCallback extends DiffUtil.Callback {

    private List<NewsListBean.ListBean> mOldDatas, mNewDatas;

    public NewsDiffCallback(List<NewsListBean.ListBean> mOldDatas, List<NewsListBean.ListBean> mNewDatas) {
        this.mOldDatas = mOldDatas;
        this.mNewDatas = mNewDatas;
    }

    @Override
    public int getOldListSize() {
        return mOldDatas != null ? mOldDatas.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return mNewDatas != null ? mNewDatas.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return TextUtils.equals(mOldDatas.get(oldItemPosition).getUrl(), mNewDatas.get(newItemPosition).getUrl());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        NewsListBean.ListBean beanOld = mOldDatas.get(oldItemPosition);
        NewsListBean.ListBean beanNew = mNewDatas.get(newItemPosition);
        if (!beanOld.getTitle().equals(beanNew.getTitle())) {
            return false;
        }
        if (!beanOld.getPic().equals(beanNew.getPic())) {
            return false;
        }
        return true;
    }
}
