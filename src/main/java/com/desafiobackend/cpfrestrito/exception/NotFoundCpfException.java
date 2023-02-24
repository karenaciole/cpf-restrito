package com.desafiobackend.cpfrestrito.exception;

public class NotFoundCpfException extends Exception{
    private static final Long serialVersionUID = 1L;

    public NotFoundCpfException(String errorMessage) {
        super(errorMessage);
    }
}
