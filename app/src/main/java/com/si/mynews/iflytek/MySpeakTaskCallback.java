package com.si.mynews.iflytek;

import android.os.IBinder;
import android.os.RemoteException;

import com.si.mynews.SpeakTaskCallback;

/*
 * ==============================================================================
 *
 * 版 权 : ****
 *
 * 作 者 : 司 向 前
 *
 * 版 本 : 1.0
 *
 * 创建日期 : 2017/5/7 16:49
 *
 * 描 述 :
 *
 *
 *
 * 修订历史 :
 *
 * ==============================================================================
 */
public class MySpeakTaskCallback implements SpeakTaskCallback{

    @Override
    public void speakTaskOver() throws RemoteException {

    }

    @Override
    public IBinder asBinder() {
        return null;
    }
}
