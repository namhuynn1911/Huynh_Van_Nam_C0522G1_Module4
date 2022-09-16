package com.example.product.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int price;
    private String newDescribe;
    private String producer;

    public Product() {
    }

    public Product(int id, String name, int price, String newDescribe, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.newDescribe = newDescribe;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNewDescribe() {
        return newDescribe;
    }

    public void setNewDescribe(String newDescribe) {
        this.newDescribe = newDescribe;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
