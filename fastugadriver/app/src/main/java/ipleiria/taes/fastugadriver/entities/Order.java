package ipleiria.taes.fastugadriver.entities;

import java.util.Date;

public class Order {
    private Restaurant restaurant;
    private Client client;
    private Driver driver;
    private Long id;
    private Status status;
    private Double price;
    private Date date;
    private String notes;

    public Order(Restaurant restaurant, Client client, Long id, Status status, Double price, Date date, String notes) {
        this.restaurant = restaurant;
        this.client = client;
        this.driver = null;
        this.id = id;
        this.status = status;
        this.price = price;
        this.date = date;
        this.notes = notes;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Client getClient() {
        return client;
    }

    public Driver getDriver() {
        return driver;
    }

    public Long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public Double getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    public String getNotes() {
        return notes;
    }
}
