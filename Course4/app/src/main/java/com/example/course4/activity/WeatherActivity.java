package com.example.course4.activity;

import android.util.Log;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.course4.ActionCallback;
import com.example.course4.R;
import com.example.course4.base.BaseInitActivity;
import com.example.course4.bean.Weather;
import com.example.course4.databinding.ActivityWeatherBinding;
import com.example.course4.databinding.DataBoundAdapter;
import com.example.course4.databinding.DataBoundViewHolder;
import com.example.course4.databinding.WeatherItemBinding;
import com.example.course4.net.WeatherApi;
import com.example.course4.net.XMLCity;
import com.example.course4.net.XMLWeather;
import com.example.course4.util.Utils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class WeatherActivity extends BaseInitActivity<ActivityWeatherBinding> {
    public static final String WIFI = "Wi-Fi";
    public static final String ANY = "Any";
    private static final String URL = "https://flash.weather.com.cn/";

    private WeatherApi newsApi;

    // Whether there is a Wi-Fi connection.
    private static boolean wifiConnected = false;
    // Whether there is a mobile connection.
    private static boolean mobileConnected = false;
    // Whether the display should be refreshed.
    public static boolean refreshDisplay = true;

    @Override
    protected ActivityWeatherBinding getViewBinding() {
        return DataBindingUtil.setContentView(this, R.layout.activity_weather);
    }

    @Override
    protected void initViewsAndEvents() {
        newsApi = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(WeatherApi.class);

        loadPage(new Observer<XMLWeather>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(XMLWeather weather) {
                List<Weather> weathers = new ArrayList<>();
                for(XMLCity xmlCity : weather.getCity()){
                    weathers.add(new Weather(xmlCity, Utils.getTime()));
                }
                binding.rvWeather.setAdapter(new WeatherAdapter(null, weathers));
            }

            @Override
            public void onError(Throwable e) {
                Log.d("Error Retrofit", "onError: " + e.getMessage());
                Toast.makeText(WeatherActivity.this, "无网络连接", Toast.LENGTH_LONG).show();
                binding.rvWeather.setAdapter(new WeatherAdapter(null,
                        new Weather("广东", "广州", "30", "20", "大雨", "大风", "2022-06-30"),
                        new Weather("广东", "广州", "30", "20", "大雨", "大风", "2001-30-30"),
                        new Weather("广东", "广州", "30", "20", "大雨", "大风", "2001-30-30"),
                        new Weather("广东", "广州", "30", "20", "大雨", "大风", "2001-30-30"),
                        new Weather("广东", "广州", "30", "20", "大雨", "大风", "2001-30-30"),
                        new Weather("广东", "广州", "30", "20", "大雨", "大风", "2001-30-30"),
                        new Weather("广东", "广州", "30", "20", "大雨", "大风", "2001-30-30"),
                        new Weather("广东", "广州", "30", "20", "大雨", "大风", "2001-30-30"),
                        new Weather("广东", "广州", "30", "20", "大雨", "大风", "2001-30-30"),
                        new Weather("广东", "广州", "30", "20", "大雨", "大风", "2001-30-30")));
            }

            @Override
            public void onComplete() {

            }
        });

        binding.rvWeather.setLayoutManager(new LinearLayoutManager(this));

    }

    public void loadPage(Observer<XMLWeather> observer){
        newsApi.getWeather()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }

    private static class WeatherAdapter extends DataBoundAdapter<WeatherItemBinding> {
        List<Weather> mWeatherList = new ArrayList<>();
        private ActionCallback mActionCallback;
        /**
         * Creates a DataBoundAdapter with the given item layout
         */
        public WeatherAdapter(ActionCallback actionCallback, Weather ... news) {
            super(R.layout.weather_item);
            mActionCallback = actionCallback;
            Collections.addAll(mWeatherList, news);
        }

        public WeatherAdapter(ActionCallback actionCallback, List<Weather> weathers) {
            super(R.layout.weather_item);
            mActionCallback = actionCallback;
            mWeatherList = weathers;
        }

        @Override
        public int getItemCount() {
            return mWeatherList.size();
        }

        @Override
        protected void bindItem(DataBoundViewHolder<WeatherItemBinding> holder, int position, List<Object> payloads) {
            holder.binding.setWeather(mWeatherList.get(position));
        }
    }
}