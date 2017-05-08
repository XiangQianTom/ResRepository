package com.si.mynews;

import com.si.mynews.SpeakTaskCallback;

interface IMySpeakInterface {
    void speakWords(String words,SpeakTaskCallback callback);

    void stopWords();
}
