package com.example.horo.model.service.pojo.daily;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Максим on 19.10.2017.
 */


@Root(name = "taurus")
public class Taurus {


    private String yesterday;
    private String today;
    private String tomorrow;
    private String tomorrow02;

    @Element(name = "yesterday")
    public String getYesterday() {
        return yesterday;
    }
    @Element(name = "today")
    public String getToday() {
        return today;
    }
    @Element(name = "tomorrow")
    public String getTomorrow() {
        return tomorrow;
    }
    @Element(name = "tomorrow02")
    public String getTomorrow02() {
        return tomorrow02;
    }

    @Element(name = "yesterday")
    public void setYesterday(String yesterday) {
        this.yesterday = yesterday;
    }
    @Element(name = "today")
    public void setToday(String today) {
        this.today = today;
    }
    @Element(name = "tomorrow")
    public void setTomorrow(String tomorrow) {
        this.tomorrow = tomorrow;
    }
    @Element(name = "tomorrow02")
    public void setTomorrow02(String tomorrow02) {
        this.tomorrow02 = tomorrow02;
    }


}
