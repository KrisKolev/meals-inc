package com.example.restaurantapplication;

public enum Info
{
    SUCCESS(200, "Request was successful."),
    UNAUTHORIZED(400, "Request is unauthorized."),
    FAILURE(500, "Request failed.");

    public final int code;
    public final String defaultMessage;

    Info(int code, String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
    }
}
