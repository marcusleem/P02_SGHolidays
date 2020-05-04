package com.marcus.p02_sgholidays;

public class HolidayName {

    private String holiType;
    private String name;
    private String date;

    public HolidayName(String name, String date, String holiType) {
        this.name = name;
        this.date = date;
        this.holiType = holiType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHoliType() {
        return holiType;
    }

    public void setHoliType(String holiType) {
        this.holiType = holiType;
    }
}