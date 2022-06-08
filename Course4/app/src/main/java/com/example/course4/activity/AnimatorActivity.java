package com.example.course4.activity;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;

import androidx.databinding.DataBindingUtil;

import com.example.course4.R;
import com.example.course4.base.BaseInitActivity;
import com.example.course4.databinding.ActivityAnimatorBinding;

public class AnimatorActivity extends BaseInitActivity<ActivityAnimatorBinding> {

    @Override
    protected ActivityAnimatorBinding getViewBinding() {
        return DataBindingUtil.setContentView(this, R.layout.activity_animator);
    }

    @Override
    protected void initViewsAndEvents() {
        binding.btnDoit.setOnClickListener(view -> {
            binding.viewPuppet.startAnimation(getAnimationSet());
        });
    }

    private Animation getAnimationSet() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.view_animation);
        return animation;
    }
}