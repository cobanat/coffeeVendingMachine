package com.coffeeMachine;

import java.util.Scanner;

public class UserInput {
    Scanner scan = new Scanner(System.in);
    String choice;

    public String choice() {
        choice = scan.next();
        return choice;
    }
}
