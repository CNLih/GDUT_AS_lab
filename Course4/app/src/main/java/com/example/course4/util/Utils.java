package com.example.course4.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {
    public static String getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss", Locale.CHINA);
        return formatter.format(new Date(System.currentTimeMillis()));
    }
}
