package com.enigmaproapps.asmaulhusna.utilities;

import android.view.View;

/**
 * Created by shoaibanwar on 6/4/17.
 */

public final class Utility {

    public View getParent(View view, int targetId) {
        System.out.println(view.getId() +" == "+ targetId);
        if (view.getId() == targetId) {
            return view;
        }
        View parentView = (View) view.getParent();
        if (parentView == null) {
            return null;
        }
        return getParent(parentView, targetId);
    }
}
