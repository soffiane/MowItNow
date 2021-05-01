package fr.publicissapient.exception;

public class InvalidPlacementException extends RuntimeException {
    public InvalidPlacementException() {
    }

    public InvalidPlacementException(String message) {
        super(message);
    }
}
