package com.enigmaproapps.asmaulhusna.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.enigmaproapps.asmaulhusna.R;

/**
 * Created by shoaibanwar on 6/6/17.
 */

public final class PrefsDao {

    private static final String KEY_TRANSLATION_LANG="selected_trans_lang";
    private Context context;
    private SharedPreferences prefs;

    public PrefsDao (Context context){
        this.context = context;
        prefs = context.getSharedPreferences(context.getString(R.string.preference_file_key),Context.MODE_PRIVATE);
    }

    public String getTransLangSelected(){
        return prefs.getString(KEY_TRANSLATION_LANG,"urdu");
    }

    public void setTransLangSelected(String langSelected){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_TRANSLATION_LANG, langSelected);
        editor.commit();
    }
}
