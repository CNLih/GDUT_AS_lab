package com.example.course4.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.course4.R;
import com.example.course4.base.BaseInitActivity;
import com.example.course4.databinding.ActivityVedioBinding;

public class VedioActivity extends BaseInitActivity<ActivityVedioBinding> {
    private final String URL = "https://poss-videocloud.cns.com.cn/oss/2021/05/08/chinanews/MEIZI_YUNSHI/onair/25AFA3CA2F394DB38420CC0A44483E82.mp4";

    @Override
    protected ActivityVedioBinding getViewBinding() {
        return DataBindingUtil.setContentView(this, R.layout.activity_vedio);
    }

    @Override
    protected void initViewsAndEvents() {
        binding.videoView.setVideoPath(URL);
        binding.btnStart.setOnClickListener(view -> {
            if(binding.videoView.isPlaying()){
                binding.videoView.resume();
            }else {
                binding.videoView.start();
            }
        });
        binding.btnStop.setOnClickListener(view -> {
            binding.videoView.pause();
        });
    }
}