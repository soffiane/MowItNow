package fr.publicissapient.exception;

public class EmptyFileException extends RuntimeException{
    public EmptyFileException() {
    }

    public EmptyFileException(String message) {
        super(message);
    }
}
