package com.enigmaproapps.asmaulhusna.presenter;

import android.content.Context;
import android.widget.Toast;

import com.enigmaproapps.asmaulhusna.model.PrefsDao;
import com.enigmaproapps.asmaulhusna.view.iSettingsView;

/**
 * Created by shoaibanwar on 6/6/17.
 */

public final class SettingsPresenter implements iSettingsPresenter {

    private iSettingsView settingsView;
    private Context context;

    public SettingsPresenter(iSettingsView settingsView){
        this.settingsView = settingsView;
        this.context = ((Context) settingsView).getApplicationContext();
    }

    @Override
    public void updateTranslationLangPref(String langName) {
        Toast.makeText(context,"Translation language set to "+langName,Toast.LENGTH_SHORT).show();
        PrefsDao prefsDao = new PrefsDao(context);
        prefsDao.setTransLangSelected(langName.toLowerCase());
    }
}
