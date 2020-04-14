package com.coffeeMachine;

public class CoffeeMachineEngine {
    Storage firstStorage;
    public CoffeeMachineEngine(Storage storage) {
        firstStorage = storage;
    }

    public boolean drinkTypeSelection(CoffeeType drinkType) {
        if(!checkStorage(drinkType)) return false;
        makeCoffee(drinkType);
        return true;

    }

    private boolean checkStorage(CoffeeType drinkType) {
        return (firstStorage.getWater() >= drinkType.getWaterVolume() && firstStorage.getMilk() >= drinkType.getMilkVolume()
                && firstStorage.getCoffeeBean() >= drinkType.getCoffeeBeanWeight()
                &&  firstStorage.getDisposableCups() >= drinkType.getDisposableCupsPiece());
    }

    private void makeCoffee(CoffeeType drinkType) {
        firstStorage.setWater(firstStorage.getWater() - drinkType.getWaterVolume());
        firstStorage.setMilk(firstStorage.getMilk() - drinkType.getMilkVolume());
        firstStorage.setCoffeeBean(firstStorage.getCoffeeBean() - drinkType.getCoffeeBeanWeight());
        firstStorage.setDisposableCups(firstStorage.getDisposableCups() - drinkType.getDisposableCupsPiece());
        firstStorage.setCash(firstStorage.getCash() + drinkType.getCoffeePrice());
    }

    public void takeMoney() {
        System.out.println("I gave you $" + firstStorage.takeCash());
    }

}