package com.enigmaproapps.asmaulhusna.view;

import android.view.View;
import android.widget.ImageButton;

import java.util.List;

import com.enigmaproapps.asmaulhusna.model.AllahName;
import com.enigmaproapps.asmaulhusna.presenter.iMainPresenter;

/**
 * Created by shoaibanwar on 3/12/17.
 */

public interface iMainView {
    void setPresenterForRecycler(iMainPresenter presenter);
    void populateReceivedNames(List<AllahName> inList);
    void setAudioButtonState(boolean ifPlayOrPause, ImageButton btn_Play_Pause);

}
