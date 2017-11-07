package com.example.horo.model.service.pojo.weekly;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Максим on 16.10.2017.
 */

@Root(name="horo")
public class HoroWeekly {

    private Date date;

    @Element(name="date")
    public Date getDate() {
        return date;
    }

    @Element(name="date")
    public void setDate(Date date) {
        this.date = date;
    }

private Aries aries;

private Taurus taurus;

private Gemini gemini;

private Cancer cancer;

private Leo leo;

private Virgo virgo;

private Libra libra;

private Scorpio scorpio;

private Sagittarius sagittarius;

private Capricorn capricorn;

private Aquarius aquarius;

private Pisces pisces;


    @Element(name="aries")
    public Aries getAries() {
        return aries;
    }


    @Element(name="taurus")
    public Taurus getTaurus() {
        return taurus;
    }


    @Element(name="gemini")
    public Gemini getGemini() {
        return gemini;
    }

    @Element(name="cancer")
    public Cancer getCancer() {
        return cancer;
    }

    @Element(name="leo")
    public Leo getLeo() {
        return leo;
    }

    @Element(name="virgo")
    public Virgo getVirgo() {
        return virgo;
    }

    @Element(name="libra")
    public Libra getLibra() {
        return libra;
    }

    @Element(name="scorpio")
    public Scorpio getScorpio() {
        return scorpio;
    }

    @Element(name="sagittarius")
    public Sagittarius getSagittarius() {
        return sagittarius;
    }

    @Element(name="capricorn")
    public Capricorn getCapricorn() {
        return capricorn;
    }

    @Element(name="aquarius")
    public Aquarius getAquarius() {
        return aquarius;
    }

    @Element(name="pisces")
    public Pisces getPisces() {
        return pisces;
    }



    @Element(name="aries")
    public void setAries(Aries aries) {
        this.aries = aries;
    }

    @Element(name="taurus")
    public void setTaurus(Taurus taurus) {
        this.taurus = taurus;
    }

    @Element(name="gemini")
    public void setGemini(Gemini gemini) {
        this.gemini = gemini;
    }
    @Element(name="cancer")
    public void setCancer(Cancer cancer) {
        this.cancer = cancer;
    }
    @Element(name="leo")
    public void setLeo(Leo leo) {
        this.leo = leo;
    }
    @Element(name="virgo")
    public void setVirgo(Virgo virgo) {
        this.virgo = virgo;
    }
    @Element(name="libra")
    public void setLibra(Libra libra) {
        this.libra = libra;
    }
    @Element(name="scorpio")
    public void setScorpio(Scorpio scorpio) {
        this.scorpio = scorpio;
    }
    @Element(name="sagittarius")
    public void setSagittarius(Sagittarius sagittarius) {
        this.sagittarius = sagittarius;
    }
    @Element(name="capricorn")
    public void setCapricorn(Capricorn capricorn) {
        this.capricorn = capricorn;
    }
    @Element(name="aquarius")
    public void setAquarius(Aquarius aquarius) {
        this.aquarius = aquarius;
    }
    @Element(name="pisces")
    public void setPisces(Pisces pisces) {
        this.pisces = pisces;
    }
}
