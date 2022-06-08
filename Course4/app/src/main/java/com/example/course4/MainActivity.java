package com.example.course4;

import android.content.Intent;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.course4.activity.Animator2Activity;
import com.example.course4.activity.AnimatorActivity;
import com.example.course4.activity.MeiTuanActivity;
import com.example.course4.activity.VedioActivity;
import com.example.course4.activity.WeatherActivity;
import com.example.course4.activity.WebActivity;
import com.example.course4.base.BaseInitActivity;
import com.example.course4.bean.News;
import com.example.course4.databinding.ActivityMainBinding;
import com.example.course4.databinding.DataBoundAdapter;
import com.example.course4.databinding.DataBoundViewHolder;
import com.example.course4.databinding.RecyclerviewItemBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends BaseInitActivity<ActivityMainBinding> {

    private final News[] myNews = {
            new News(R.drawable.a, "天气预报", "这是天气预报", 0, "10"),
            new News(R.drawable.b, "视频播放", "这是视频播放", 0, "20"),
            new News(R.drawable.c, "时钟显示", "这是时钟显示", 0, "30"),
            new News(R.drawable.d, "美团外卖", "这是美团外卖", 0, "40"),
            new News(R.drawable.e, "补间动画", "这是补间动画", 0, "50"),
            new News(R.drawable.f, "逐帧动画", "这是逐帧动画", 0, "60"),
            new News(R.drawable.g, "这是空的", " ", 0, "70"),
    };

    private final Class[] cls = {
            WeatherActivity.class,
            VedioActivity.class,
            WebActivity.class,
            MeiTuanActivity.class,
            AnimatorActivity.class,
            Animator2Activity.class
    };

    @Override
    protected ActivityMainBinding getViewBinding() {
        return DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void initViewsAndEvents() {

        ActionCallback actionCallback = news -> {
            for(int i = 0; i < myNews.length; i ++){
                if(news.equals(myNews[i]) && i < cls.length){
                    Intent activity = new Intent(MainActivity.this, cls[i]);
                    startActivity(activity);
                }
            }
        };
        //TODO 在xml中指定
        binding.rvNews.setAdapter(new NewsAdapter(actionCallback, myNews));
        binding.rvNews.setLayoutManager(new LinearLayoutManager(this));
    }

    private static class NewsAdapter extends DataBoundAdapter<RecyclerviewItemBinding> {
        List<News> mNewsList = new ArrayList<>();
        private ActionCallback mActionCallback;
        /**
         * Creates a DataBoundAdapter with the given item layout
         */
        public NewsAdapter(ActionCallback actionCallback, News ... news) {
            super(R.layout.recyclerview_item);
            mActionCallback = actionCallback;
            Collections.addAll(mNewsList, news);
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }

        @Override
        protected void bindItem(DataBoundViewHolder<RecyclerviewItemBinding> holder, int position, List<Object> payloads) {
            holder.binding.setNews(mNewsList.get(position));
            holder.binding.setCallback(mActionCallback);
        }
    }
}