package com.coffeeMachine;

public class Menu {
    Storage storage = new Storage(5000 ,5000 ,1000, 100, 0);
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
            int  waterVolumeML = Integer.parseInt(input.choice());

            System.out.println("Write how many ml of milk do you want to add:");
            int  MilkVolumeML = Integer.parseInt(input.choice());

            System.out.println("Write how many grams of coffee beans do you want to add:");
            int coffeeBeanWeigh = Integer.parseInt(input.choice());

            System.out.println("Write how many disposable cups of coffee do you want to add:");
            int disposableCupsPiece = Integer.parseInt(input.choice());

            storage.fillStorage(waterVolumeML, MilkVolumeML, coffeeBeanWeigh, disposableCupsPiece);
        }
        catch (NumberFormatException e) {
            System.out.println("Write only numbers!");
        }
    }

    private void chooseCoffee() throws NumberFormatException {
        System.out.println("What do you want to buy? Espresso, Latte or Cappuccino:");
        boolean canMakeCoffeeOrNot = false;
        try {
            String choice = input.choice();

            if (choice.equalsIgnoreCase(String.valueOf(CoffeeType.ESPRESSO))) {
                canMakeCoffeeOrNot = machine.drinkTypeSelection(CoffeeType.ESPRESSO);
            }
            else if (choice.equalsIgnoreCase(String.valueOf(CoffeeType.LATTE))) {
                canMakeCoffeeOrNot = machine.drinkTypeSelection(CoffeeType.LATTE);
            }
            else if (choice.equalsIgnoreCase(String.valueOf(CoffeeType.CAPPUCCINO))) {
                canMakeCoffeeOrNot = machine.drinkTypeSelection(CoffeeType.CAPPUCCINO);
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
