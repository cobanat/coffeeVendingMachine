package com.coffeeMachine;

import java.util.Scanner;
/**
 * Ввод с клавиатуры пользователем
 *
 * @author Nail Zinnurov
 * @version 2.0
 * */
public class UserInput {
    Scanner scan = new Scanner(System.in);
    String choice;

    public String choice() {
        choice = scan.next();
        return choice;
    }
}
