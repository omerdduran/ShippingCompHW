package main;
import items.*;
import methods.Calculation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner;

	public static void main(String[] args) {
        scanner = new Scanner(System.in);
        List<Item> items = new ArrayList<>();

        Calculation calculation = new Calculation();

        // Product input
        System.out.println("Enter number of Laptops: ");
        int numLaptops = scanner.nextInt();
        for (int i = 0; i < numLaptops; i++) {
            items.add(new Laptop());
        }

        System.out.println("Enter number of Mouses: ");
        int numMouses = scanner.nextInt();
        for (int i = 0; i < numMouses; i++) {
            items.add(new Mouse());
        }

        System.out.println("Enter number of Desktops: ");
        int numDesktops = scanner.nextInt();
        for (int i = 0; i < numDesktops; i++) {
            items.add(new Desktop());
        }

        System.out.println("Enter number of LCD Screens: ");
        int numLcdScreens = scanner.nextInt();
        for (int i = 0; i < numLcdScreens; i++) {
            items.add(new LcdScreen());
        }

        calculation.bestShipping(items);
    }
}
