package com.desafiobackend.cpfrestrito.utils.errors;

import com.desafiobackend.cpfrestrito.exception.ExistsCpfException;
import com.desafiobackend.cpfrestrito.exception.InvalidCpfException;
import com.desafiobackend.cpfrestrito.exception.NotFoundCpfException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CpfError {

    static final String INVALID_CPF = "CPF is not valid";
    static final String CPF_ALREADY_EXISTS = "CPF already exists";
    static final String CPF_NOT_FOUND = "CPF not found";

    public static ResponseEntity<CustomTypeError> errorCpfAlreadyExists(ExistsCpfException e) {
        return new ResponseEntity<>(new CustomTypeError(e.getClass().getSimpleName(), CPF_ALREADY_EXISTS), HttpStatus.CONFLICT);
    }

    public static ResponseEntity<CustomTypeError> errorCpfNotFound(NotFoundCpfException e) {
        return new ResponseEntity<>(new CustomTypeError(e.getClass().getSimpleName(), CPF_NOT_FOUND), HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<CustomTypeError> errorInvalidCpf(InvalidCpfException e) {
        return new ResponseEntity<>(new CustomTypeError(e.getClass().getSimpleName(), INVALID_CPF), HttpStatus.BAD_REQUEST);
    }

}
