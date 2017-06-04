package com.enigmaproapps.asmaulhusna.model;

import android.content.Context;

import java.util.List;

/**
 * Created by shoaibanwar on 3/12/17.
 */

//This will contain the business logic and will use Dao to send+receive things from client+dao
public final class Service_AllahNameData {

    private IAllahNameDao nameDao;

    //if used dependency injection, this service class will be receiving IAllahNameDao in
    //constructor and hence not creating+initing it here.
    public Service_AllahNameData() {
        nameDao = new AllahName_Dao(); // A factory class can be used to init dao object if there are
                                    //more than one implementations of IAllahNameDao.
    }

    public List<AllahName> getListOf_Names_Of_Allah (Context context){

        //Check which language do we need translation in of Allah's Names.
        // String transLangName = GlobalPrefs.getTransLang();
        String transLangName = "";
        List<AllahName> retrievedList = nameDao.getList(transLangName,context);
        return retrievedList;
    }
}
