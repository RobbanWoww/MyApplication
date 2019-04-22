package com.example.ps.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

/**
 * Created by LWQ on 2019-04-22.
 */
public abstract  class BaseActivity extends AppCompatActivity implements IView{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getLayoutId() > 0){
            setContentView(getLayoutId());

            bindUI(null);
        }
        initData(savedInstanceState);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(getOptionsMenuId() > 0){
            getMenuInflater().inflate(getOptionsMenuId(),menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void bindUI(View rootView) {

    }

}
