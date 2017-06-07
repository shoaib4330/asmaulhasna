package com.enigmaproapps.asmaulhusna.interactor_or_service;

import com.enigmaproapps.asmaulhusna.view.iMainView;

/**
 * Created by shoaibanwar on 6/5/17.
 */

public interface iMediaService {
    void play(int audioIndex);
    void stop();
    void release();
    boolean isPlaying();

    interface onAudioEvent{
        void onPlaySuccess();
        void onPlayError();
        void onNameAudioCompletion();
        void onNameAudioStopped();
    }
}
