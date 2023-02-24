package com.desafiobackend.cpfrestrito.utils.errors;

public class CustomTypeError {
    private String type;
    private String message;

    public CustomTypeError(String type, String message) {
        this.type = type;
        this.message = message;

    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
