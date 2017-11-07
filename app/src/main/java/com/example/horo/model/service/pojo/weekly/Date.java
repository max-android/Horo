package com.example.horo.model.service.pojo.weekly;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Максим on 16.10.2017.
 */


@Root(name="date")
public class Date {

     private String weekly;

    @Attribute(name = "weekly")
    public String getWeekly() {
        return weekly;
    }

    @Attribute(name = "weekly")
    public void setWeekly(String weekly) {
        this.weekly = weekly;
    }

}
