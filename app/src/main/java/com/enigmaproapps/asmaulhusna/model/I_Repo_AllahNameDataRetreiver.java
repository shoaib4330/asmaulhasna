package com.enigmaproapps.asmaulhusna.model;

import android.content.Context;

import java.util.List;

/**
 * Created by shoaibanwar on 3/12/17.
 */

public interface I_Repo_AllahNameDataRetreiver {
    List<AllahName> retrieveAllahNameList(String in_langOf_NameTranslation, Context context);
}
