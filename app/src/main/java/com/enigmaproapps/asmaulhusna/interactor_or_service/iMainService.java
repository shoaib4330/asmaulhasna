package com.enigmaproapps.asmaulhusna.interactor_or_service;

import android.content.Context;

import com.enigmaproapps.asmaulhusna.model.AllahName;

import java.util.List;

/**
 * Created by shoaibanwar on 6/5/17.
 */

public interface iMainService {
    void play(int audioIndex);
    List<AllahName> getListOf_Names_Of_Allah ();
    void stop();
    boolean isPlaying();
    void releaseMediaResources();
}
