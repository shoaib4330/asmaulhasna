package com.enigmaproapps.asmaulhusna.model;

/**
 * Created by shoaibanwar on 3/12/17.
 */

public final class Factoy_AllahName_DataStore {

    public static I_AllahNameDataRetreiver_DataStore getDataStoreInstance(){
        return new DataStore_AllahNameData_LocalAssets();
    }
}
