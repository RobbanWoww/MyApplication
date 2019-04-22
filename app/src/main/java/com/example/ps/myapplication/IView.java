package com.example.ps.myapplication;

import android.os.Bundle;
import android.view.View;

/**
 * Created by LWQ on 2019-04-22.
 */
public interface IView {
    int getLayoutId();
    int getOptionsMenuId();
    void initData(Bundle savedInstanceState);
    void bindUI(View rootView);
}
