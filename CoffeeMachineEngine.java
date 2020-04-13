package com.coffeeMachine;

public class CoffeeMachineEngine {
    Storage firstStorage;
    public CoffeeMachineEngine(Storage storage) {
        firstStorage = storage;
    }

    public boolean checkStorageForMakeCoffee(CoffeeType drinkType) {
        if(drinkType == CoffeeType.ESPRESSO && firstStorage.getWater() >= 250 && firstStorage.getCoffeeBean() >= 16 &&  firstStorage.getDisposableCups() > 0) {
            makeCoffee(250, 0, 16, 1, 4);
            return true;
        }
        if(drinkType == CoffeeType.LATTE && firstStorage.getWater() >= 250 && firstStorage.getCoffeeBean() >= 16 &&  firstStorage.getDisposableCups() > 0) {
            makeCoffee(350, 75, 20, 1, 7);
            return true;
        }
        if(drinkType == CoffeeType.CAPPUCCINO && firstStorage.getWater() >= 250 && firstStorage.getCoffeeBean() >= 16 &&  firstStorage.getDisposableCups() > 0) {
            makeCoffee(200, 100, 12, 1, 6);
            return true;
        }
        return false;
    }

    private void makeCoffee(int water, int milk, int coffeeBean, int disposableCups, int price) {
        firstStorage.setWater(firstStorage.getWater() - water);
        firstStorage.setMilk(firstStorage.getMilk() - milk);
        firstStorage.setCoffeeBean(firstStorage.getCoffeeBean() - coffeeBean);
        firstStorage.setDisposableCups(firstStorage.getDisposableCups() - disposableCups);
        firstStorage.setCash(firstStorage.getCash() + price);

    }

    public void takeMoney() {
        System.out.println("I gave you $" + firstStorage.takeCash());
    }

}