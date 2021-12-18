package com.example.restaurantapplication;

public abstract class Response implements AutoCloseable
{
    public abstract int getStatus();
}
