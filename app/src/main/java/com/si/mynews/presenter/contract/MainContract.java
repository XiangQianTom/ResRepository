package com.si.mynews.presenter.contract;

import com.si.mynews.base.BasePresenter;
import com.tbruyelle.rxpermissions.RxPermissions;

/**
 * Created by si on 16/8/9.
 */

public interface MainContract {

    interface View extends BaseView{

        void showUpdateDialog(String versionContent);

        void startDownloadService();
    }

    interface  Presenter extends BasePresenter<View> {

        void checkVersion(String currentVersion);

        void checkPermissions(RxPermissions rxPermissions);
    }
}
