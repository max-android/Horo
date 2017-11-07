package com.example.horo.model.service.pojo.daily;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Максим on 19.10.2017.
 */

@Root(name="date")
public class Date {

    private String yesterday;
    private String today;
    private String tomorrow;
    private String tomorrow02;

    @Attribute(name = "yesterday")
    public String getYesterday() {
        return yesterday;
    }
    @Attribute(name = "today")
    public String getToday() {
        return today;
    }
    @Attribute(name = "tomorrow")
    public String getTomorrow() {
        return tomorrow;
    }
    @Attribute(name = "tomorrow02")
    public String getTomorrow02() {
        return tomorrow02;
    }
    @Attribute(name = "yesterday")
    public void setYesterday(String yesterday) {
        this.yesterday = yesterday;
    }

    @Attribute(name = "today")
    public void setToday(String today) {
        this.today = today;
    }
    @Attribute(name = "tomorrow")
    public void setTomorrow(String tomorrow) {
        this.tomorrow = tomorrow;
    }

    @Attribute(name = "tomorrow02")
    public void setTomorrow02(String tomorrow02) {
        this.tomorrow02 = tomorrow02;
    }

}
