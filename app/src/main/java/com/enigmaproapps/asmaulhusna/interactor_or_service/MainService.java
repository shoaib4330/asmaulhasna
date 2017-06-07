package com.enigmaproapps.asmaulhusna.interactor_or_service;

import android.content.Context;

import com.enigmaproapps.asmaulhusna.model.AllahName;
import com.enigmaproapps.asmaulhusna.model.AllahName_Dao;
import com.enigmaproapps.asmaulhusna.model.IAllahNameDao;
import com.enigmaproapps.asmaulhusna.model.PrefsDao;
import com.enigmaproapps.asmaulhusna.view.iMainView;

import java.util.List;

/**
 * Created by shoaibanwar on 3/12/17.
 */

//This will contain the business logic and will use Dao to send+receive things from client+dao
// This will be used by presenter, logically this should implement an interface by which presenter should
    // use it but for sake of less effort, i have not created any interface here.
public final class MainService implements iMainService{

    private IAllahNameDao nameDao;
    private iMediaService mediaService;
    private iMediaService.onAudioEvent onAudioEventUtilizer;

    private Context context;

    //if used dependency injection, this service class will be receiving IAllahNameDao in
    //constructor and hence not creating+initing it here.
    public MainService(Context context,iMediaService.onAudioEvent onAudioEvent) {
        this.context = context.getApplicationContext();
        this.onAudioEventUtilizer = onAudioEvent;
        mediaService = new MediaService(context,onAudioEventUtilizer);
        nameDao = new AllahName_Dao(); // A factory class can be used to init dao object if there are
                                    //more than one implementations of IAllahNameDao.
    }

    public List<AllahName> getListOf_Names_Of_Allah (){

        //Check which language do we need translation in of Allah's Names.
        // String transLangName = GlobalPrefs.getTransLang();
        String transLangName = new PrefsDao(context).getTransLangSelected();
        List<AllahName> retrievedList = nameDao.getList(transLangName,context);
        return retrievedList;
    }


    @Override
    public void play(int audioIndex) {
        mediaService.play(audioIndex);
    }

    @Override
    public void stop() {
        mediaService.stop();
    }

    @Override
    public boolean isPlaying() {
        return mediaService.isPlaying();
    }

    @Override
    public void releaseMediaResources() {
        mediaService.release();
    }

}
