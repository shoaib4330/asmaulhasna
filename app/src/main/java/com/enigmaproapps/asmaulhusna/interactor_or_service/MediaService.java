package com.enigmaproapps.asmaulhusna.interactor_or_service;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;

import com.enigmaproapps.asmaulhusna.view.iMainView;

import java.io.IOException;
import java.net.ConnectException;

/**
 * Created by shoaibanwar on 6/5/17.
 */

public final class MediaService implements iMediaService, MediaPlayer.OnCompletionListener {

    private final static String RES_CONSTANT = "android.resource://com.enigmaproapps.asmaulhusna/raw/audio";
    private final static String TAG = "Media Service:";

    private MediaPlayer mediaPlayer = null;
    private Context context;

    private iMediaService.onAudioEvent mediaServiceUtilizer;


    public MediaService(Context context, iMediaService.onAudioEvent onAudioEvent) {
        this.context = context.getApplicationContext();
        this.mediaServiceUtilizer = onAudioEvent;
    }

    @Override
    public void play(int resName) {
        String audioPath = RES_CONSTANT.concat(String.valueOf(resName));
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying())
                mediaPlayer.stop();
            mediaPlayer.reset();

            try {
                mediaPlayer.setDataSource(context, Uri.parse(audioPath));
                mediaPlayer.prepare();
            } catch (IOException e) {
                Log.d(TAG, "create, setDataSource failed");
                e.printStackTrace();

                mediaServiceUtilizer.onPlayError();
                return;
            }
        } else {
            mediaPlayer = MediaPlayer.create(context, Uri.parse(audioPath));
            mediaPlayer.setOnCompletionListener(this);
        }
        mediaServiceUtilizer.onPlaySuccess();
        mediaPlayer.start();
    }

    @Override
    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaServiceUtilizer.onNameAudioStopped();
        }
    }

    @Override
    public void release() {
        if (mediaPlayer != null)
            mediaPlayer.release();
    }

    @Override
    public boolean isPlaying() {
        if (mediaPlayer==null)
        {
            return false;
        }
        return mediaPlayer.isPlaying();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        this.mediaServiceUtilizer.onNameAudioCompletion();
    }
}
