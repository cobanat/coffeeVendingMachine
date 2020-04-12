package com.coffeeMachine;

import java.util.Scanner;

public class Menu {
    CoffeeMachineEngine machine;
    public Menu(CoffeeMachineEngine firstMachine) {
        machine = firstMachine;
    }

    public void chooseAction() {
        String choice;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            choice = choice();
            switch (choice) {
                case "buy":
                    chooseCoffee();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    showStorage(machine.getStorage());
                    break;
                default:
                    break;
            }
        } while (!choice.equalsIgnoreCase("exit"));
    }

    private void takeMoney() {
        System.out.println("I gave you $" + machine.takeCash());
    }

    private void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        int water = Integer.parseInt(choice());

        System.out.println("Write how many ml of milk do you want to add:");
        int milk = Integer.parseInt(choice());

        System.out.println("Write how many grams of coffee beans do you want to add:");
        int coffeeBean = Integer.parseInt(choice());

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int disCups = Integer.parseInt(choice());

        machine.fillStorage(water, milk, coffeeBean, disCups);
    }

    private void chooseCoffee() throws NumberFormatException {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        boolean canOrNot = false;
        try {
            switch (Integer.parseInt(choice())) {
                case 1:
                    canOrNot = machine.makeEspresso();
                    break;
                case 2:
                    canOrNot = machine.makeLatte();
                    break;
                case 3:
                    canOrNot = machine.makeCappuccino();
                    break;
                default:
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Choose from 1 to 31");
        }

        if(canOrNot) System.out.println("I have enough resources, making you a coffee!");
        else System.out.println("Sorry, not enough water!");

    }

    public void showStorage(int[] storage) {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(storage[0] + " of water");
        System.out.println(storage[1] + " of milk");
        System.out.println(storage[2] + " of coffee beans");
        System.out.println(storage[3] + " of disposable cups");
        System.out.println(storage[4] + " of money");


    }

    private static String choice() {
        Scanner scan = new Scanner(System.in);
        String choice = scan.next();
        return choice;
    }
}
