package main;
import items.*;
import methods.Calculation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Ömer Duran - 45096997

//I use JRE 17.0.11 
//Git repo: https://codeberg.org/omerdduran/ShippingCompHW
//Here, you can see all the commits I made over time
//
//Description: This Java program finds the best way and cost of shipping for a
//			given list of products. It retrieves the products to be shipped with the "Scanner"
//			from the user. Then it adds the products to the list. Calculates the volume and
//			weight of all products. Accordingly, it calculates the possibilities of how we can send them.
//			It tells us the cheapest of these possibilities.
//
//Date: June 11, 2024

public class Main {

    public static void main(String[] args) {
        // try and catch to avoid incorrect input
        try (Scanner scanner = new Scanner(System.in)) {
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
            scanner.close();
        } catch (Exception e) {
            System.out.println("Please enter valid numbers.");
        }
    }
}