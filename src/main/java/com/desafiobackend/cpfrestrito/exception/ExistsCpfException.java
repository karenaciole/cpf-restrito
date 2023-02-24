package com.desafiobackend.cpfrestrito.exception;

public class ExistsCpfException extends Exception {
    private static final Long serialVersionUID = 1L;

    public ExistsCpfException(String errorMessage) {
        super(errorMessage);
    }
}
