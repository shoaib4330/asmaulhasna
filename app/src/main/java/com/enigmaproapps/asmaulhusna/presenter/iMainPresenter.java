package com.enigmaproapps.asmaulhusna.presenter;

import android.view.View;

import java.util.List;

import com.enigmaproapps.asmaulhusna.view.iMainView;
import com.enigmaproapps.asmaulhusna.model.AllahName;

/**
 * Created by shoaibanwar on 3/10/17.
 */

public interface iMainPresenter {
    void onTakeView(iMainView asView);
    void onStopInvocation();
    List<AllahName> retrieveAllahNameList();
    void playName (int name,View btn_Play_Pause);
    int getCurrentNamePlayedIndex();
    boolean isAudioPlaying();
    void updateNameRecyclerList();
}
