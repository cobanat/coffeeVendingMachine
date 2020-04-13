package com.coffeeMachine;

public class Menu {
    Storage storage = new Storage(0 ,0 ,0, 0, 0);
    CoffeeMachineEngine machine = new CoffeeMachineEngine(storage);
    UserInput input = new UserInput();

    public void chooseAction() {
        String choice;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            choice = input.choice();
            switch (choice) {
                case "buy":
                    chooseCoffee();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    machine.takeMoney();
                    break;
                case "remaining":
                    showStorage();
                    break;
                default:
                    break;
            }
        } while (!"exit".equalsIgnoreCase(choice));
    }

    private void fill() throws NumberFormatException{
        try {
            System.out.println("Write how many ml of water do you want to add:");
            int water = Integer.parseInt(input.choice());

            System.out.println("Write how many ml of milk do you want to add:");
            int milk = Integer.parseInt(input.choice());

            System.out.println("Write how many grams of coffee beans do you want to add:");
            int coffeeBean = Integer.parseInt(input.choice());

            System.out.println("Write how many disposable cups of coffee do you want to add:");
            int disCups = Integer.parseInt(input.choice());

            storage.fillStorage(water, milk, coffeeBean, disCups);
        }
        catch (NumberFormatException e) {
            System.out.println("Write only numbers!");
        }
    }

    private void chooseCoffee() throws NumberFormatException {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        boolean canMakeCoffeeOrNot = false;
        try {
            String choice = input.choice();

            if (choice.equalsIgnoreCase(String.valueOf(CoffeeType.ESPRESSO))) {
                canMakeCoffeeOrNot = machine.checkStorageForMakeCoffee(CoffeeType.ESPRESSO);
            }
            else if (choice.equalsIgnoreCase(String.valueOf(CoffeeType.LATTE))) {
                canMakeCoffeeOrNot = machine.checkStorageForMakeCoffee(CoffeeType.LATTE);
            }
            else if (choice.equalsIgnoreCase(String.valueOf(CoffeeType.CAPPUCCINO))) {
                canMakeCoffeeOrNot = machine.checkStorageForMakeCoffee(CoffeeType.CAPPUCCINO);
            }
            else System.out.println("No such drink");
        }
        catch (NumberFormatException e) {
            System.out.println("Choose from 1 to 31");
        }

        if(canMakeCoffeeOrNot) System.out.println("I have enough resources, making you a coffee!");
        else System.out.println("Sorry, not enough resources!");

    }

    public void showStorage() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(storage.getWater() + " of water");
        System.out.println(storage.getMilk() + " of milk");
        System.out.println(storage.getCoffeeBean() + " of coffee beans");
        System.out.println(storage.getDisposableCups() + " of disposable cups");
        System.out.println(storage.getCash() + " of money");
    }
}
