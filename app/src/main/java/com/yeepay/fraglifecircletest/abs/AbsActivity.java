package com.yeepay.fraglifecircletest.abs;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by SilentKnight on 2015/1/13.
 */
public abstract class AbsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView();
        findViewsById();
        initWidgets();
        loadData();
    }

    public abstract void initContentView();

    public abstract void findViewsById();

    public abstract void initWidgets();

    public abstract void loadData();
}
