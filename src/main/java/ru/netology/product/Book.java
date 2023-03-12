package ru.netology.product;


public class Book extends Product {

    private String author;


    public Book(int id, int price, String author, String name) {
        super(id, price, name);
        this.author = author;
    }

}

