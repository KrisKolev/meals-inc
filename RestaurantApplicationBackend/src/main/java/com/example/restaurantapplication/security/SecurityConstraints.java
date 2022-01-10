package com.example.restaurantapplication.security;

public class SecurityConstraints
{

    public static final String SECRET = "meals_secret";
    public static final long EXPIRATION_TIME = 864000000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/employees";
}
