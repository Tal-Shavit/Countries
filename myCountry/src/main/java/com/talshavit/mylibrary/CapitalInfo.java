package com.talshavit.mylibrary;

public class CapitalInfo {
    private String country;
    private String capital;

    public CapitalInfo() {}

    public CapitalInfo(String country, String capital) {
        this.country = country;
        this.capital = capital;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
