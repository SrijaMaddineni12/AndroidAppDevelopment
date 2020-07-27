package com.example.task10;

public class CovidModel {
    String date;
    String active;
    String confirm;
    String deaths;
    String recover;

    public CovidModel(String date, String active, String confirm, String deaths, String recover) {
        this.date = date;
        this.active = active;
        this.confirm = confirm;
        this.deaths = deaths;
        this.recover = recover;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getRecover() {
        return recover;
    }

    public void setRecover(String recover) {
        this.recover = recover;
    }
}
