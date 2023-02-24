package com.desafiobackend.cpfrestrito.exception;

public class InvalidCpfException extends Exception {
    private static final Long serialVersionUID = 1L;

    public InvalidCpfException(String errorMessage) {
        super(errorMessage);
    }
}
