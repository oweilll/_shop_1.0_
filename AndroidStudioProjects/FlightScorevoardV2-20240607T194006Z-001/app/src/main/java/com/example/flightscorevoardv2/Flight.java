package com.example.flightscorevoardv2;
public class Flight {
    private String city;
    private String number;
    private String time;

    public Flight() {
        // пустой конструктор нужен для Firebase
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
