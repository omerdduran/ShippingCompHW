package main;

import items.*;
import methods.Calculation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    private static void runTest(int testNumber, Calculation calculation) {
        List<Item> items = new ArrayList<>();
        switch (testNumber) {
            case 1:
                // Test 1: Fill a large container completely
            	for (int i = 0; i < 503; i++) {
                    items.add(new Laptop());
                }
                break;
            case 2:
                // Test 2: Fill a small container with a volume limit and weight <= 500 kg
            	for (int i = 0; i < 50; i++) {
                    items.add(new Laptop());
                }
            	for (int i = 0; i < 500; i++) {
                    items.add(new Mouse());
                }
            	for (int i = 0; i < 15; i++) {
                    items.add(new LcdScreen());
                }
                break;
            case 3:
                // Test 3: Fill a small container with a volume limit and weight > 500 kg
            	for (int i = 0; i < 50 ; i++) {
                    items.add(new Desktop());
                }
                break;
            case 4:
                // Test 4: Fill a large container completely and add one more Lcd
            	for (int i = 0; i < 503; i++) {
                    items.add(new Laptop());
                }
            	items.add(new LcdScreen());
                break;
            case 5:
                // Test 5: Mix of different items (example scenario)
            	for (int i = 0; i < 100; i++) {
                    items.add(new Laptop());
                    items.add(new LcdScreen());
                    items.add(new Mouse());
                    items.add(new Desktop());
                }
                break;
            default:
                System.out.println("Invalid test number.");
                return;
        }
        calculation.bestShipping(items);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculation calculation = new Calculation();

        while (true) {
            System.out.println("Hello, I have created a test file for you to test this project.");
            System.out.println("");
            System.out.println("Please select the test number you want to run:");
            System.out.println("");
            System.out.println("1: Fill a large container completely");
            System.out.println("2: Fill a small container with a volume limit and weight <= 500 kg");
            System.out.println("3: Fill a small container with a volume limit and weight > 500 kg");
            System.out.println("4: Fill a large container completely and add one more Lcd");
            System.out.println("5: Mix of different items (example scenario)");
            System.out.println("Press 0 to exit.");

            int testNumber = scanner.nextInt();
            if (testNumber == 0) {
                break;
            }

            runTest(testNumber, calculation);

            System.out.println("Would you like to run another test? (Press 1 for Yes, 0 for No)");
            int continueTesting = scanner.nextInt();
            if (continueTesting == 0) {
                break;
            }
        }
        scanner.close();
    }
}
