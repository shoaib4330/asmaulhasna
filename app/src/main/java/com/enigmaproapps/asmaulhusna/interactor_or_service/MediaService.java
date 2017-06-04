package com.enigmaproapps.asmaulhusna.interactor_or_service;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.net.ConnectException;

/**
 * Created by shoaibanwar on 6/5/17.
 */

public final class MediaService implements iMediaService {

    private final static String RES_CONSTANT = "android.resource://com.enigmaproapps.asmaulhusna/raw/audio";
    private final static String TAG = "Media Service:";
    private MediaPlayer mediaPlayer=null;
    private Context context;


    public MediaService(Context context){
        this.context = context.getApplicationContext();
    }

    @Override
    public void play(int resName) {
        String audioPath = RES_CONSTANT.concat(String.valueOf(resName));
        if (mediaPlayer!=null){
            if (mediaPlayer.isPlaying())
                mediaPlayer.stop();
            mediaPlayer.reset();

            try {
                mediaPlayer.setDataSource(context,Uri.parse(audioPath));
                mediaPlayer.prepare();
            } catch (IOException e) {
                Log.d(TAG,"create, setDataSource failed");
                e.printStackTrace();
            }
        }
        else{
            mediaPlayer = MediaPlayer.create(context, Uri.parse(audioPath));
        }
        mediaPlayer.start();
    }

    @Override
    public void stop() {
        mediaPlayer.stop();
    }

    @Override
    public void release() {
        if (mediaPlayer!=null)
            mediaPlayer.release();
    }
}
