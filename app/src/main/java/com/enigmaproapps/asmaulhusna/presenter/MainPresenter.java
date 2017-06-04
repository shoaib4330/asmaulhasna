package com.enigmaproapps.asmaulhusna.presenter;

import android.content.Context;

import java.util.List;

import com.enigmaproapps.asmaulhusna.view.iMainView;
import com.enigmaproapps.asmaulhusna.model.AllahName;
import com.enigmaproapps.asmaulhusna.interactor_or_service.MainService;

/**
 * Created by shoaibanwar on 3/10/17.
 */

public final class MainPresenter implements iMainPresenter {

    private iMainView mView;
    private MainService interactor; //An interactor handling business logic and who knows how to do things.
    private Context context;

    public MainPresenter(Context gContext){
        this.context = gContext.getApplicationContext();
        this.interactor = new MainService(context);
    }

    @Override
    public void onTakeView(iMainView activityAsView) {
        this.mView = activityAsView;
        publishNamesToView();
    }

    private void publishNamesToView(){
        List<AllahName> nameList = this.retrieveAllahNameList();
        if (mView!=null)
            mView.populateReceivedNames(nameList);
    }

    @Override
    public List<AllahName> retrieveAllahNameList() {
        List<AllahName> nameList = interactor.getListOf_Names_Of_Allah(context);
        return nameList;
    }

    @Override
    public void playName(AllahName name) {
        interactor.play(name.getNameIndex());
    }

}
