package com.coffeeMachine;

public enum CoffeeType {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6);

    private final int waterVolume;
    private final int milkVolume;
    private final int coffeeBeanWeight;
    private final int disposableCupsPiece;
    private final int CoffeePrice;

    CoffeeType(int water, int milk, int coffeeBean, int disposableCups, int price) {
        waterVolume = water;
        milkVolume = milk;
        coffeeBeanWeight = coffeeBean;
        disposableCupsPiece = disposableCups;
        CoffeePrice = price;
    }

    public int getWaterVolume() {
        return waterVolume;
    }

    public int getMilkVolume() {
        return milkVolume;
    }

    public int getCoffeeBeanWeight() {
        return coffeeBeanWeight;
    }

    public int getDisposableCupsPiece() {
        return disposableCupsPiece;
    }

    public int getCoffeePrice() {
        return CoffeePrice;
    }
}
