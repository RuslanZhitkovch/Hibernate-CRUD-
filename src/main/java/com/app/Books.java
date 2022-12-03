package com.app;

import javax.persistence.*;

@Entity       // указываем что будет создана сущность
@Table (name = "books")
public class Books {
    @Id
    @GeneratedValue()
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private int price;

    @Column
    private int amount;

    public Books(int id, String name, String author, int price, int amount) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.amount = amount;
    }

    public Books( String name, String author, int price, int amount) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.amount = amount;
    }
    public Books() {}

    @Id
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
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }


}