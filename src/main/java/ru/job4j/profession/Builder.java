package ru.job4j.profession;

public class Builder extends Engineer {
    private boolean isBodyBuilder;
    private int maxFloorsBuilt;

    public boolean isBodyBuilder() {
        return isBodyBuilder;
    }

    public int getMaxFloorsBuilt() {
        return maxFloorsBuilt;
    }
}
