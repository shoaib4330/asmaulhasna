package com.enigmaproapps.asmaulhusna.model;

import android.content.Context;

import java.util.List;

/**
 * Created by shoaibanwar on 3/12/17.
 */

public final class Repository_AllahNameData implements I_Repo_AllahNameDataRetreiver {

    private I_AllahNameDataRetreiver_DataStore mDataStore;

    public Repository_AllahNameData(){
        mDataStore = Factoy_AllahName_DataStore.getDataStoreInstance();
    }

    @Override
    public List<AllahName> retrieveAllahNameList(String in_langOf_NameTranslation, Context context) {
        return mDataStore.retrieveAllahNameDataList(in_langOf_NameTranslation,context);
    }
}
