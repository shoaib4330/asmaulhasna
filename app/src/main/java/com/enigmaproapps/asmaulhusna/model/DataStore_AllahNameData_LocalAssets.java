package com.enigmaproapps.asmaulhusna.model;

import android.content.Context;

import com.enigmaproapps.asmaulhusna.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shoaibanwar on 3/12/17.
 */

public final class DataStore_AllahNameData_LocalAssets implements I_AllahNameDataRetreiver_DataStore {

    @Override
    public List<AllahName> retrieveAllahNameDataList(String input_trans_lang, Context context) {
        List<String> listOfNames_Arabic = Arrays.asList(context.getResources().getStringArray(R.array.Allah_Name_RecordList));
        List<String> listOfNames_English = Arrays.asList(context.getResources().getStringArray(R.array.Allah_Name_TransLation_English));
        List<AllahName> nameListToReturn = new ArrayList<>();
        for (int index=0; index < listOfNames_Arabic.size(); index++)
        {
            AllahName currentName = new AllahName();
            currentName.setNameOfAllah(listOfNames_Arabic.get(index));
            currentName.setTranslation(listOfNames_English.get(index));
            nameListToReturn.add(currentName);
        }
        return nameListToReturn;
    }
}
