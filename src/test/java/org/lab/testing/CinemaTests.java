package org.lab.testing;

import org.junit.jupiter.api.*;
import org.lab.Cinema;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CinemaTests {
    @Test
    // test bookSeats method
    public void testBookSeats() {
        Cinema cinema = new Cinema();
        int[][][] halls = cinema.getHalls();
        int[] seats = {1, 2, 3};
        try {
            cinema.bookSeats(1, 1, seats);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(1, halls[0][0][0]);
        assertEquals(1, halls[0][0][1]);
        assertEquals(1, halls[0][0][2]);
    }

    @Test
    public void testCancelBooking() {
        Cinema cinema = new Cinema();
        int[][][] halls = cinema.getHalls();
        int[] seats = {1, 2, 3};
        try {
            cinema.bookSeats(1, 1, seats);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(1, halls[0][0][0]);
        assertEquals(1, halls[0][0][1]);
        assertEquals(1, halls[0][0][2]);
        cinema.cancelBooking(1, 1, seats);
        assertEquals(0, halls[0][0][0]);
        assertEquals(0, halls[0][0][1]);
        assertEquals(0, halls[0][0][2]);
    }

    @Test
    public void testCheckAvailability() {
        Cinema cinema = new Cinema();
        int[][][] halls = cinema.getHalls();

        int[] seats = {1, 2, 3};
        try {
            cinema.bookSeats(1, 1, seats);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(1, halls[0][0][0]);
        assertEquals(1, halls[0][0][1]);
        assertEquals(1, halls[0][0][2]);
        cinema.checkAvailability(1, 3);
    }
}
