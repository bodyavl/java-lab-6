package org.lab;

import org.lab.exceptions.PlaceTakenException;
import org.lab.Cinema;

import java.util.Scanner;

import static org.apache.commons.lang3.StringUtils.center;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static int getNumberInputInRange(Scanner in, int range) {
        String message = String.format("The value was not valid, please, enter number in range (0-%s): ", range);
        while (in.hasNext()) {
            if (in.hasNextInt()) {
                int val = Integer.parseInt(in.nextLine());
                if (val >= 1 && val <= range) {
                    return val;
                } else {
                    System.out.println(message);
                }
            } else {
                System.out.println(message);
                in.nextLine();
            }
        }
        return -1;
    }

    public static void main(String[] args) throws PlaceTakenException {
        Cinema cinema = new Cinema();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (true) {
            System.out.print("Enter a number of action:\n1 - Book Seats\n2 - Cancel Booking\n3 - Check Availability\n4 - See all seats\n5 - Exit\n");
            int action = getNumberInputInRange(scanner, 5);
            switch (action) {
                case 1 -> {
                    
                    try {
                        System.out.println("Enter a number of hall:");
                        int hallNumber = getNumberInputInRange(scanner, 5);
                        System.out.println("Enter a number of row:");
                        int row = getNumberInputInRange(scanner, 10);
                        System.out.println("Enter a number of seats:");
                        int numSeats = getNumberInputInRange(scanner, 20);
                        int[] seats = new int[numSeats];
                        for (int i = 0; i < numSeats; i++) {
                            System.out.println("Enter a number of seat:");
                            seats[i] = getNumberInputInRange(scanner, 20);
                        }
                        cinema.bookSeats(hallNumber, row, seats);
                    } catch (PlaceTakenException e) {
                        System.out.println(e.getMessage());
                    }

                }
                case 2 -> {
                    System.out.println("Enter a number of hall:");
                    int hallNumber = getNumberInputInRange(scanner, 5);
                    System.out.println("Enter a number of row:");
                    int row = getNumberInputInRange(scanner, 10);
                    System.out.println("Enter a number of seats:");
                    int numSeats = getNumberInputInRange(scanner, 20);
                    int[] seats = new int[numSeats];
                    for (int i = 0; i < numSeats; i++) {
                        System.out.println("Enter a number of seat:");
                        seats[i] = getNumberInputInRange(scanner, 20);
                    }
                    cinema.cancelBooking(hallNumber, row, seats);
                }
                case 3 -> {
                    System.out.println("Enter a number of hall:");
                    int hallNumber = getNumberInputInRange(scanner, 5);
                    System.out.println("Enter a number of seats:");
                    int numSeats = getNumberInputInRange(scanner, 20);
                    cinema.checkAvailability(hallNumber, numSeats);
                }
                case 4 -> {
                    System.out.println("Enter a number of hall:");
                    int hallNumber = getNumberInputInRange(scanner, 5);
                    cinema.printSeatingArrangement(hallNumber);
                }
                case 5 -> {
                    isRunning = false;
                }
            }
            if (!isRunning) break;
            System.out.println("Continue? yes/no");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("no")) break;

        }
    }


}