package com.example.course4.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import com.example.course4.R;
import com.example.course4.base.BaseInitActivity;
import com.example.course4.databinding.ActivityAnimator2Binding;

public class Animator2Activity extends BaseInitActivity<ActivityAnimator2Binding> {

    @Override
    protected ActivityAnimator2Binding getViewBinding() {
        return DataBindingUtil.setContentView(this, R.layout.activity_animator2);
    }

    @Override
    protected void initViewsAndEvents() {
        binding.imgPuppet.setOnClickListener(view -> {
            ((AnimationDrawable) binding.imgPuppet.getDrawable()).start();
        });
    }
}