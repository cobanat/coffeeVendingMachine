package com.coffeeMachine;

public class CoffeeMachineEngine {
    int[] storage = new int[5];

    public CoffeeMachineEngine(int water, int milk, int coffeeBean, int disCups, int cash) {
        storage[0] = water;
        storage[1] = milk;
        storage[2] = coffeeBean;
        storage[3] = disCups;
        storage[4] = cash;
    }

    public void fillStorage(int water, int milk, int coffeeBean, int disCups) {
        storage[0] += water;
        storage[1] += milk;
        storage[2] += coffeeBean;
        storage[3] += disCups;
    }

    public boolean makeCappuccino() {
        if(storage[0] >= 200 &&  storage[1] >= 100 && storage[2] >= 12 &&  storage[3] > 0) {
            storage[0] -= 200;
            storage[1] -= 100;
            storage[2] -= 12;
            storage[3]--;
            storage[4] += 6;
            return true;
        }
        else return false;
    }

    public boolean makeLatte() {
        if(storage[0] >= 350 &&  storage[1] >= 75 && storage[2] >= 20 &&  storage[3] > 0) {
            storage[0] -= 350;
            storage[1] -= 75;
            storage[2] -= 20;
            storage[3]--;
            storage[4] += 7;
            return true;
        }
        else return false;
    }

    public boolean makeEspresso() {
        if(storage[0] >= 250 && storage[2] >= 16 &&  storage[3] > 0) {
            storage[0] -= 250;
            storage[2] -= 16;
            storage[3]--;
            storage[4] += 4;
            return true;
        }
        else return false;
    }

    public int takeCash() {
        int cash = storage[4];
        storage[4] = 0;
        return cash;
    }

    public int[] getStorage() {
        return storage;
    }
}
