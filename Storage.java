package com.coffeeMachine;

public class Storage {
    private int water;
    private int milk;
    private int coffeeBean;
    private int disposableCups;
    private int cash;

    public Storage(int water, int milk, int coffeeBean, int disposableCups, int cash) {
        this.water = water;
        this.milk = milk;
        this.coffeeBean = coffeeBean;
        this.disposableCups = disposableCups;
        this.cash = cash;
    }

    public void fillStorage(int fillWater, int fillMilk, int fillCoffeeBean, int fillDisposableCups) {
        water = water + fillWater;
        milk = milk + fillMilk;
        coffeeBean = coffeeBean + fillCoffeeBean;
        disposableCups = disposableCups + fillDisposableCups;
    }

    public int takeCash() {
        int money = cash;
        cash = 0;
        return money;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBean() {
        return coffeeBean;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public int getCash() {
        return cash;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setCoffeeBean(int coffeeBean) {
        this.coffeeBean = coffeeBean;
    }

    public void setDisposableCups(int disposableCups) {
        this.disposableCups = disposableCups;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
