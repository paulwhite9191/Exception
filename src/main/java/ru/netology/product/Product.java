package ru.netology.product;


public class Product {

    protected int id;
    protected int price;

    protected String name;


    public Product(int id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

}