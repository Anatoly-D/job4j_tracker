package ru.job4j.poly;

public interface Transport {
    void move();
    void collectPass(int passQty);
    int fillTank(int fuelLitres);
}
