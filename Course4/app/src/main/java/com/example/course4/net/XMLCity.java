package com.example.course4.net;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "city", strict = false)
public class XMLCity {
    @Attribute(name = "quName")
    String provinceName;

    @Attribute(name = "pyName")
    String provincePYName;

    @Attribute(name = "cityname")
    String cityName;

    @Attribute(name = "state1")
    String state1;

    @Attribute(name = "state2")
    String state2;

    @Attribute(name = "stateDetailed")
    String state;

    @Attribute(name = "tem1")
    String maxTem;

    @Attribute(name = "tem2")
    String miniTem;

    @Attribute(name = "windState")
    String wind;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvincePYName() {
        return provincePYName;
    }

    public void setProvincePYName(String provincePYName) {
        this.provincePYName = provincePYName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getState1() {
        return state1;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

    public String getState2() {
        return state2;
    }

    public void setState2(String state2) {
        this.state2 = state2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMaxTem() {
        return maxTem;
    }

    public void setMaxTem(String maxTem) {
        this.maxTem = maxTem;
    }

    public String getMiniTem() {
        return miniTem;
    }

    public void setMiniTem(String miniTem) {
        this.miniTem = miniTem;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }
}
