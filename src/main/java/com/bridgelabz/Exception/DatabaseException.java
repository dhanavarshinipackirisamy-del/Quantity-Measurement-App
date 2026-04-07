package com.bridgelabz.Exception;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String msg, Throwable cause) {
        super(msg, cause);
    }
}