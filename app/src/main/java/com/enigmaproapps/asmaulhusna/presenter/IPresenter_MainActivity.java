package com.enigmaproapps.asmaulhusna.presenter;

import java.util.List;

import com.enigmaproapps.asmaulhusna.IMainActivity_to_Presenter;
import com.enigmaproapps.asmaulhusna.model.AllahName;

/**
 * Created by shoaibanwar on 3/10/17.
 */

public interface IPresenter_MainActivity {
    void onTakeView(IMainActivity_to_Presenter asView);
    List<AllahName> retrieveAllahNameList(String in_langOf_NameTranslation);
}
