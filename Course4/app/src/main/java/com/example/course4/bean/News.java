package com.example.course4.bean;

import androidx.annotation.DrawableRes;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.course4.BR;

public class News extends BaseObservable{

    @DrawableRes
    @Bindable
    private int icon;        //图片路径
    @Bindable
    private String title;       //新闻标题
    @Bindable
    private String content;     //新闻描述
    @Bindable
    private int type;           //新闻类型
    @Bindable
    private String comment;       //新闻评论数

    public News(int icon, String title, String content, int type, String comment) {
        this.icon = icon;
        this.title = title;
        this.content = content;
        this.type = type;
        this.comment = comment;
    }

    @Bindable
    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
        notifyPropertyChanged(BR.icon);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }

    @Bindable
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        notifyPropertyChanged(BR.type);
    }

    @Bindable
    public String getComment() {
        return String.valueOf(comment);
    }

    public void setComment(String comment) {
        this.comment = comment;
        notifyPropertyChanged(BR.comment);
    }
}
