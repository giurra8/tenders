package com.olmero.tenders.error;

import org.springframework.http.HttpStatus;

public class ApiError extends Exception {

    private HttpStatus status;
    private String message;

    public ApiError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

}
