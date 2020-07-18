package ru.job4j.poly;

public class Bus implements Transport {
    private int fuelPrice = 4;
    private int passengers = 0;
    private boolean isMoving = false;

    @Override
    public void move() {
        isMoving = true;
    }

    @Override
    public void collectPass(int passQty) {
        passengers += passQty;
    }

    @Override
    public int fillTank(int fuelLitres) {
        return fuelLitres * fuelPrice;
    }

    public static void main(String[] args) {
    }
}
