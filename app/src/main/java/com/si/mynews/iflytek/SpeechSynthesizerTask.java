package com.si.mynews.iflytek;


import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;
import com.si.mynews.SpeakTaskCallback;

/**
 * 语音合成任务
 * Created by liuhao on 2016/9/24.
 */
public class SpeechSynthesizerTask implements SynthesizerListener {
    private static SpeechSynthesizer mSynthesizer;
    private static SpeechSynthesizerTask task;
    private SpeakTaskCallback callback;

    private SpeechSynthesizerTask() {
        mSynthesizer = MySpeechSynthesizer.getInstance();
        mSynthesizer.setParameter(SpeechConstant.NET_TIMEOUT, "4000");
    }

    public synchronized static SpeechSynthesizerTask getInstance() {
        if (task == null) {
            task = new SpeechSynthesizerTask();
        }
        return task;
    }

    public void startSynthesizer(String word) {
        mSynthesizer.startSpeaking(word, this);
    }

    public void stopSynthesizer() {
        mSynthesizer.stopSpeaking();
    }

    @Override
    public void onSpeakBegin() {

    }

    @Override
    public void onBufferProgress(int i, int i1, int i2, String s) {

    }

    @Override
    public void onSpeakPaused() {

    }

    @Override
    public void onSpeakResumed() {

    }

    @Override
    public void onSpeakProgress(int i, int i1, int i2) {

    }

    @Override
    public void onCompleted(SpeechError speechError) {
        Log.e("complete", "结束结束");
        if (null != callback) {
            try {
                callback.speakTaskOver();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onEvent(int i, int i1, int i2, Bundle bundle) {

    }

    public void setSpeakEndListener(SpeakTaskCallback callback) {
        this.callback = callback;
    }
}
