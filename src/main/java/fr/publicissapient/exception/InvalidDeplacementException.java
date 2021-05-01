package fr.publicissapient.exception;

public class InvalidDeplacementException extends RuntimeException {

    public InvalidDeplacementException() {
    }

    public InvalidDeplacementException(String message) {
        super(message);
    }
}
