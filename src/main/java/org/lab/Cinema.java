package org.lab;

import org.lab.exceptions.PlaceTakenException;

import static org.apache.commons.lang3.StringUtils.center;

public class Cinema {

    private final int[][][] halls = new int[5][10][20];

    public int[][][] getHalls() {
        return halls;
    }

    public void bookSeats(int hallNumber, int row, int[] seats) throws PlaceTakenException {
        for (var seat : seats) {
            if (halls[hallNumber - 1][row - 1][seat - 1] == 1) throw new PlaceTakenException();
            halls[hallNumber - 1][row - 1][seat - 1] = 1;
        }
    }

    public void cancelBooking(int hallNumber, int row, int[] seats) {
        for (var seat : seats) {
            halls[hallNumber - 1][row - 1][seat - 1] = 0;
        }
    }


    public void checkAvailability(int screen, int numSeats) {
        int[][] screenSeats = halls[screen - 1];
        int seatsInRow = 0;
        for (int row = 0; row < screenSeats.length; row++) {
            for (int seat = 0; seat < screenSeats[row].length; seat++) {
                if (screenSeats[row][seat] == 0) {
                    seatsInRow++;
                    if (seatsInRow == numSeats) {
                        System.out.println("There are " + numSeats + " seats available in row " + (row + 1));
                        return;
                    }
                } else {
                    seatsInRow = 0;
                }
            }
        }
        System.out.println("There are no " + numSeats + " seats available");
    }

    public void printSeatingArrangement(int hallNumber) {
        int[][] screenSeats = halls[hallNumber - 1];
        printSeatNumbers(hallNumber);
        System.out.print("\u001B[32;40m");
        for (int i = 0; i < screenSeats.length; i++) {
            int[] screenSeat = screenSeats[i];
            for (int seat = 0; seat < screenSeat.length; seat++) {
                if (seat == 0) {
                    System.out.print("\u001B[0m");
                    printWithFixedWidth((i + 1) + " |");
                    System.out.print("\u001B[32;40m");
                }
                if (screenSeat[seat] == 1) {
                    System.out.print("\u001B[31;43m");
                    printWithFixedWidth(String.valueOf(screenSeat[seat]));
                    System.out.print("\u001B[32;40m");

                } else {
                    printWithFixedWidth(String.valueOf(screenSeat[seat]));
                }

            }
            System.out.print("\u001B[0m\n\u001B[32;40m");
        }
        System.out.print("\u001B[0m");
        printSeatNumbers(hallNumber);
    }

    public void printSeatNumbers(int hallNumber) {
        int[][] screenSeats = halls[hallNumber - 1];
        printWithFixedWidth(" ");
        for (int i = 1; i <= screenSeats[0].length; i++) {
            printWithFixedWidth(String.valueOf(i));
        }
        System.out.println();
    }

    public void printWithFixedWidth(String string) {
        System.out.print(center(string, 5));

    }
}
