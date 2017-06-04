package com.enigmaproapps.asmaulhusna.presenter;

import android.content.Context;

import java.util.List;

import com.enigmaproapps.asmaulhusna.IMainActivity_to_Presenter;
import com.enigmaproapps.asmaulhusna.model.AllahName;
import com.enigmaproapps.asmaulhusna.model.Service_AllahNameData;

/**
 * Created by shoaibanwar on 3/10/17.
 */

public final class Presenter_MainActivity implements com.enigmaproapps.asmaulhusna.presenter.IPresenter_MainActivity {

    private IMainActivity_to_Presenter mView;
    private Context context;

    public Presenter_MainActivity(Context gContext){
        this.context = gContext.getApplicationContext();
    }

    @Override
    public void onTakeView(IMainActivity_to_Presenter activityAsView) {
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
        Service_AllahNameData service = new Service_AllahNameData();
        List<AllahName> nameList = service.getListOf_Names_Of_Allah(context);
        return nameList;
    }

}
