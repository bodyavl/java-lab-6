package org.lab.exceptions;

public class PlaceTakenException extends Exception {
    public PlaceTakenException(String message) {
        super(message);
    }

    public PlaceTakenException() {
        super("This place(s) is already taken!");
    }
}
