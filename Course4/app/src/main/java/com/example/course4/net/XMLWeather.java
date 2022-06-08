package com.example.course4.net;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "china", strict = false)
public class XMLWeather {
    @ElementList(entry = "city", inline = true, required = false)
    private List<XMLCity> city;

    public List<XMLCity> getCity() {
        return city;
    }

    public void setCity(List<XMLCity> city) {
        this.city = city;
    }
}
