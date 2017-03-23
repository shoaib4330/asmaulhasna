package com.enigmaproapps.asmaulhusna.model;

import android.content.Context;

import java.util.List;

/**
 * Created by shoaibanwar on 3/12/17.
 */

public interface I_AllahNameDataRetreiver_DataStore {

    public List<AllahName> retrieveAllahNameDataList(String input_trans_lang, Context context);
}
