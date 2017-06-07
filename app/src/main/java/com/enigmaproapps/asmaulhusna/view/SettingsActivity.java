package com.enigmaproapps.asmaulhusna.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.enigmaproapps.asmaulhusna.R;
import com.enigmaproapps.asmaulhusna.presenter.SettingsPresenter;
import com.enigmaproapps.asmaulhusna.presenter.iSettingsPresenter;

public class SettingsActivity extends AppCompatActivity implements iSettingsView,View.OnClickListener {

    private iSettingsPresenter mPresenter;
    private View englishLang;
    private View urduLang;
    private Button btn_Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        englishLang = findViewById(R.id.pref_TransLang_English);
        urduLang = findViewById(R.id.pref_TransLang_Urdu);
        btn_Back = (Button) findViewById(R.id.btn_Back);

        englishLang.setOnClickListener(this);
        urduLang.setOnClickListener(this);
        btn_Back.setOnClickListener(this);

        if (mPresenter==null)
            mPresenter = new SettingsPresenter(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.pref_TransLang_English){
            mPresenter.updateTranslationLangPref("english");
        }
        else if (v.getId()==R.id.pref_TransLang_Urdu){
            mPresenter.updateTranslationLangPref("urdu");
        }
        else if (v.getId()==R.id.btn_Back){
            this.finish();
        }
    }
}
