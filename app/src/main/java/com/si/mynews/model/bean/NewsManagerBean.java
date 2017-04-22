package com.si.mynews.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by si on 16/11/27.
 */

public class NewsManagerBean extends RealmObject implements Parcelable {

    public NewsManagerBean() {

    }

    private RealmList<NewsManagerItemBean> managerList;

    public RealmList<NewsManagerItemBean> getManagerList() {
        return managerList;
    }

    public void setManagerList(RealmList<NewsManagerItemBean> managerList) {
        this.managerList = managerList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.managerList);
    }

    protected NewsManagerBean(Parcel in) {
        this.managerList = new RealmList<>();
        in.readList(this.managerList, NewsManagerItemBean.class.getClassLoader());
    }

    public NewsManagerBean(RealmList<NewsManagerItemBean> mList) {
        this.managerList = mList;
    }

    public static final Parcelable.Creator<NewsManagerBean> CREATOR = new Parcelable.Creator<NewsManagerBean>() {
        @Override
        public NewsManagerBean createFromParcel(Parcel source) {
            return new NewsManagerBean(source);
        }

        @Override
        public NewsManagerBean[] newArray(int size) {
            return new NewsManagerBean[size];
        }
    };
}
