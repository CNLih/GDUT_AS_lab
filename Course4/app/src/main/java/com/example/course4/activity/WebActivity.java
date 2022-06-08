package com.example.course4.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.course4.R;
import com.example.course4.base.BaseInitActivity;
import com.example.course4.databinding.ActivityWeatherBinding;
import com.example.course4.databinding.ActivityWebBinding;

public class WebActivity extends BaseInitActivity<ActivityWebBinding> {

    @Override
    protected ActivityWebBinding getViewBinding() {
        return DataBindingUtil.setContentView(this, R.layout.activity_web);
    }

    @Override
    protected void initViewsAndEvents() {
        binding.wvWeb.getSettings().setJavaScriptEnabled(true);
        binding.wvWeb.loadUrl("file:///android_asset/index.html");
    }
}