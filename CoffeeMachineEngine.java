package com.coffeeMachine;
/**
 * Класс реализующий "внутреннее устройство" кофемашины".
 * Реализация проверки хранилища на остатки сырья, для приготовления напитка
 * и приготовление напитка.
 *
 * @author Nail Zinnurov
 * @version 2.0
 *
 * */
public class CoffeeMachineEngine {
    private final Storage firstStorage;
    public CoffeeMachineEngine(Storage storage) {
        firstStorage = storage;
    }

    public boolean drinkTypeSelection(CoffeeType drinkType) {
        if(!checkStorage(drinkType)) return false;
        makeCoffee(drinkType);
        return true;

    } // Проверка возможности приготовления напитка

    private boolean checkStorage(CoffeeType drinkType) {
        return (firstStorage.getWater() >= drinkType.getWaterVolume() && firstStorage.getMilk() >= drinkType.getMilkVolume()
                && firstStorage.getCoffeeBean() >= drinkType.getCoffeeBeanWeight()
                &&  firstStorage.getDisposableCups() >= drinkType.getDisposableCupsPiece());
    } // Проверка остатков в хранилище для приготовления напитка

    private void makeCoffee(CoffeeType drinkType) {
        firstStorage.setWater(firstStorage.getWater() - drinkType.getWaterVolume());
        firstStorage.setMilk(firstStorage.getMilk() - drinkType.getMilkVolume());
        firstStorage.setCoffeeBean(firstStorage.getCoffeeBean() - drinkType.getCoffeeBeanWeight());
        firstStorage.setDisposableCups(firstStorage.getDisposableCups() - drinkType.getDisposableCupsPiece());
        firstStorage.setCash(firstStorage.getCash() + drinkType.getCoffeePrice());
    } // Приготовление напитка

    public void takeMoney() {
        System.out.println("I gave you $" + firstStorage.takeCash());
    } // Выдача денег и вывод суммы

}