package com.enigmaproapps.asmaulhusna.presenter;

import java.util.List;

import com.enigmaproapps.asmaulhusna.view.iMainView;
import com.enigmaproapps.asmaulhusna.model.AllahName;

/**
 * Created by shoaibanwar on 3/10/17.
 */

public interface iMainPresenter {
    void onTakeView(iMainView asView);
    List<AllahName> retrieveAllahNameList();
    void playName (AllahName name);
}
