package com.ayaz.handler;

public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -3042686055658047285L;

    public UserNotFoundException() {
        super("User not found.");
    }

    public UserNotFoundException(String id) {
        super(String.format("User with id %d not found.", id));
    }

}
