package com.si.mynews.iflytek;


import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.util.ResourceUtil;
import com.si.mynews.app.App;


/**
 * 语音合成
 */
public class MySpeechSynthesizer {

    private static SpeechSynthesizer sSynthesizer;

    public static SpeechSynthesizer getInstance() {
        if (sSynthesizer == null) {
            // 初始化合成对象
            sSynthesizer = SpeechSynthesizer.createSynthesizer(App.mContext, null);
            //设置使用本地引擎
            sSynthesizer.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_LOCAL);
            //设置发音人资源路径
            sSynthesizer.setParameter(ResourceUtil.TTS_RES_PATH, getResourcePath());
            //设置发音人
            sSynthesizer.setParameter(SpeechConstant.VOICE_NAME, "nannan");
            //设置语速
            sSynthesizer.setParameter(SpeechConstant.SPEED, "60");
            //设置音量，范围0~100
//            sSynthesizer.setParameter(SpeechConstant.VOLUME, "80");
            // 设置播放合成音频打断音乐播放，默认为true
            sSynthesizer.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "false");
        }
        //设置文件保存路径，仅支持pcm,wav格式
//        sSynthesizer.setParameter(SpeechConstant.TTS_AUDIO_PATH, Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + System.currentTimeMillis() + ".wav");
        return sSynthesizer;
    }

    //获取发音人资源路径
    private static String getResourcePath() {
        //合成通用资源 //发音人资源
        String tempBuffer = ResourceUtil.generateResourcePath(App.mContext, ResourceUtil.RESOURCE_TYPE.assets,
                "tts/common.jet") + ";" +
                ResourceUtil.generateResourcePath(App.mContext, ResourceUtil.RESOURCE_TYPE.assets,
                        "tts/nannan.jet");
        return tempBuffer;
    }

}
