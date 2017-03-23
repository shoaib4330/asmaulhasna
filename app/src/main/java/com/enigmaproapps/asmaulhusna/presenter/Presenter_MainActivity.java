package com.enigmaproapps.asmaulhusna.presenter;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import com.enigmaproapps.asmaulhusna.IMainActivity_to_Presenter;
import com.enigmaproapps.asmaulhusna.model.AllahName;
import com.enigmaproapps.asmaulhusna.model.I_Repo_AllahNameDataRetreiver;
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
        List<AllahName> nameList = this.retrieveAllahNameList("");
        if (mView!=null)
            mView.populateReceivedNames(nameList);
    }

    @Override
    public List<AllahName> retrieveAllahNameList(String in_langOf_NameTranslation) {
        Service_AllahNameData serviceAllahNameData = new Service_AllahNameData();
        I_Repo_AllahNameDataRetreiver dataRetreiver = serviceAllahNameData.getRepository();
        List<AllahName> nameList = dataRetreiver.retrieveAllahNameList(in_langOf_NameTranslation,context);
        return nameList;
    }

}
