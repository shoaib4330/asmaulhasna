package com.enigmaproapps.asmaulhusna.presenter;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;

import java.util.List;

import com.enigmaproapps.asmaulhusna.interactor_or_service.iMediaService;
import com.enigmaproapps.asmaulhusna.view.iMainView;
import com.enigmaproapps.asmaulhusna.model.AllahName;
import com.enigmaproapps.asmaulhusna.interactor_or_service.MainService;

/**
 * Created by shoaibanwar on 3/10/17.
 */

public final class MainPresenter implements iMainPresenter, iMediaService.onAudioEvent {

    private iMainView mView;
    private MainService mainInteractor; //An interactor handling business logic and who knows how to do things.
    private Context context;

    private View btn_Play_Pause;
    private int currentNamePlayedIndex=-1;

    public MainPresenter(Context gContext){
        this.context = gContext.getApplicationContext();
        this.mainInteractor = new MainService(context,this);
    }

    @Override
    public void onTakeView(iMainView activityAsView) {
        this.mView = activityAsView;
        mView.setPresenterForRecycler(this);
        publishNamesToView();
    }

    @Override
    public void onStopInvocation() {
        mainInteractor.stop();
    }

    private void publishNamesToView(){
        List<AllahName> nameList = this.retrieveAllahNameList();
        if (mView!=null)
            mView.populateReceivedNames(nameList);
    }

    @Override
    public List<AllahName> retrieveAllahNameList() {
        List<AllahName> nameList = mainInteractor.getListOf_Names_Of_Allah();
        return nameList;
    }

    @Override
    public void playName(int name, View buttonPressed) {
        if (this.currentNamePlayedIndex==name && isAudioPlaying())
        {
            mainInteractor.stop();
            return;
        }
        else if (isAudioPlaying()){
            mainInteractor.stop();
        }
        this.currentNamePlayedIndex = name;
        this.btn_Play_Pause = buttonPressed;
        mainInteractor.play(name);
    }

    @Override
    public int getCurrentNamePlayedIndex() {
        return currentNamePlayedIndex;
    }


    @Override
    public boolean isAudioPlaying() {
        return mainInteractor.isPlaying();
    }

    @Override
    public void updateNameRecyclerList() {
        publishNamesToView();
    }

    @Override
    public void onPlaySuccess() {
        mView.setAudioButtonState(true,(ImageButton) btn_Play_Pause);
        //this.btn_Play_Pause=null;
    }

    @Override
    public void onPlayError() {
        mView.setAudioButtonState(false,(ImageButton) btn_Play_Pause);
        this.btn_Play_Pause=null;
        //this.currentNamePlayedIndex=-1;
    }

    @Override
    public void onNameAudioCompletion() {
        mView.setAudioButtonState(false,(ImageButton) btn_Play_Pause);
        this.btn_Play_Pause=null;
        //this.currentNamePlayedIndex=-1;
    }

    @Override
    public void onNameAudioStopped() {
        mView.setAudioButtonState(false,(ImageButton) btn_Play_Pause);
    }

}
