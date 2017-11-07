package com.example.horo.model.service.pojo.weekly;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Максим on 16.10.2017.
 */

@Root (name = "capricorn")
public class Capricorn {

    private String business;

    private String common;

    private String love;

    private String health;

    private String car;

    private String beauty;

    private String erotic;

    private String gold;

    @Element(name = "business")
    public String getBusiness() {
        return business;
    }
    @Element(name = "common")
    public String getCommon() {
        return common;
    }
    @Element(name = "love")
    public String getLove() {
        return love;
    }
    @Element(name = "health")
    public String getHealth() {
        return health;
    }
    @Element(name = "car")
    public String getCar() {
        return car;
    }
    @Element(name = "beauty")
    public String getBeauty() {
        return beauty;
    }
    @Element(name = "erotic")
    public String getErotic() {
        return erotic;
    }
    @Element(name = "gold")
    public String getGold() {
        return gold;
    }
    @Element(name = "business")
    public void setBusiness(String business) {
        this.business = business;
    }
    @Element(name = "common")
    public void setCommon(String common) {
        this.common = common;
    }
    @Element(name = "love")
    public void setLove(String love) {
        this.love = love;
    }
    @Element(name = "health")
    public void setHealth(String health) {
        this.health = health;
    }
    @Element(name = "car")
    public void setCar(String car) {
        this.car = car;
    }
    @Element(name = "beauty")
    public void setBeauty(String beauty) {
        this.beauty = beauty;
    }
    @Element(name = "erotic")
    public void setErotic(String erotic) {
        this.erotic = erotic;
    }
    @Element(name = "gold")
    public void setGold(String gold) {
        this.gold = gold;
    }
}
