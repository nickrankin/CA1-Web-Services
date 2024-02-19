package com.nickrankin.ca1.CA1.Web.Services.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User not found, id " + id);
    }
}
