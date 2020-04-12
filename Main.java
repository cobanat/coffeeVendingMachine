package com.coffeeMachine;

public class Main {

    public static void main(String[] args) {
        CoffeeMachineEngine firstMachine = new CoffeeMachineEngine(0, 0 , 0, 0, 0);
        Menu coffeeMAchineMenu = new Menu(firstMachine);

        coffeeMAchineMenu.chooseAction();
    }
}
