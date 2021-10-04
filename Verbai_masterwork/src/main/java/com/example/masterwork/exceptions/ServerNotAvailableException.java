package com.example.masterwork.exceptions;

public class ServerNotAvailableException extends RuntimeException {
    public ServerNotAvailableException(String message) {
        super(message);
    }
}
