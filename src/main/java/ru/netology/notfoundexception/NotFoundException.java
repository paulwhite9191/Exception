package ru.netology.notfoundexception;


public class NotFoundException extends RuntimeException {

    public NotFoundException(String msg) {
        super(msg);
    }
}