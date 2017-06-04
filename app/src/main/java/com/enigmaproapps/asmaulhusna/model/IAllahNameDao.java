package com.enigmaproapps.asmaulhusna.model;

import android.content.Context;

import java.util.List;

/**
 * Created by shoaibanwar on 3/12/17.
 */

public interface IAllahNameDao {

    public List<AllahName> getList(String input_trans_lang, Context context);
}
