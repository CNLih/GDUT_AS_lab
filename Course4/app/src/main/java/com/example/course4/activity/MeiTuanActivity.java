package com.example.course4.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.course4.R;
import com.example.course4.base.BaseInitActivity;
import com.example.course4.databinding.ActivityMeiTuanBinding;

public class MeiTuanActivity extends BaseInitActivity<ActivityMeiTuanBinding> {

    @Override
    protected ActivityMeiTuanBinding getViewBinding() {
        return DataBindingUtil.setContentView(this, R.layout.activity_mei_tuan);
    }

    @Override
    protected void initViewsAndEvents() {

    }
}