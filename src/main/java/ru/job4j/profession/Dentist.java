package ru.job4j.profession;

public class Dentist extends Doctor {
    private boolean hasOwnCabinet;
    private String chairModel;

    public boolean isHasOwnCabinet() {
        return hasOwnCabinet;
    }

    public String getChairModel() {
        return chairModel;
    }
}
