package main;
import items.*;
import methods.Calculation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//		Ömer Duran - 45096997
//	I use JRE 17.0.11 
//
//
//

public class Main {

    public void run() {
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
    // Call the run method of the Main instance
    public static void main(String[] args) {
        Main mainInstance = new Main();
        mainInstance.run();
    }
}
