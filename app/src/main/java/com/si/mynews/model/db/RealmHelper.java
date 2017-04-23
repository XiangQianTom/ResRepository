package com.si.mynews.model.db;

import android.content.Context;

import com.si.mynews.model.bean.NewsManagerBean;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by si on 16/8/16.
 */

public class RealmHelper {

    private static final String DB_NAME = "myRealm.realm";

    private Realm mRealm;

    public RealmHelper(Context mContext) {
        mRealm = Realm.getInstance(new RealmConfiguration.Builder(mContext)
                .deleteRealmIfMigrationNeeded()
                .name(DB_NAME)
                .build());
    }
    /**
     * 更新 新闻首页管理列表
     * @param bean
     */
    public void updateNewsManagerList(NewsManagerBean bean) {
        NewsManagerBean data = mRealm.where(NewsManagerBean.class).findFirst();
        mRealm.beginTransaction();
        if (data != null) {
            data.deleteFromRealm();
        }
        mRealm.copyToRealm(bean);
        mRealm.commitTransaction();
    }
    /**
     * 获取 新闻首页管理列表
     * @return
     */
    public NewsManagerBean getNewsManagerList() {
        NewsManagerBean bean = mRealm.where(NewsManagerBean.class).findFirst();
        if (bean == null)
            return null;
        return mRealm.copyFromRealm(bean);
    }
}
