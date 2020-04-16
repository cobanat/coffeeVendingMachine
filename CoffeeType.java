package com.coffeeMachine;
/**
 * База данных кофемашины и поиском выбранного кофе.
 *
 * @author Nail Zinnurov
 * @version 2.0
 * */
public enum CoffeeType {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6),
    UNKNOWN(0, 0, 0, 0, 0);

    private final int waterVolume;
    private final int milkVolume;
    private final int coffeeBeanWeight;
    private final int disposableCupsPiece;
    private final int coffeePrice;

    CoffeeType(int water, int milk, int coffeeBean, int disposableCups, int price) {
        waterVolume = water;
        milkVolume = milk;
        coffeeBeanWeight = coffeeBean;
        disposableCupsPiece = disposableCups;
        coffeePrice = price;
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
        return coffeePrice;
    }

    static CoffeeType findByName(String coffeeTypeName) {
        for (CoffeeType coffeeType : CoffeeType.values()) {
            if (coffeeType.name().equalsIgnoreCase(coffeeTypeName)) {
                return coffeeType;
            }
        }
        return UNKNOWN;
    } // Поиск выбранного кофе
}
