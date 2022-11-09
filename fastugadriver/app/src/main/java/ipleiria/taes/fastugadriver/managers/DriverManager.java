package ipleiria.taes.fastugadriver.managers;

import java.util.LinkedList;

import ipleiria.taes.fastugadriver.entities.Driver;
import ipleiria.taes.fastugadriver.entities.Order;

public class DriverManager {
    private Driver driver;
    private LinkedList<Order> orders;

    private static final DriverManager instance = new DriverManager();

    public static DriverManager getDriver() {
        return instance;
    }

    public DriverManager() {
        driver = new Driver();
        orders = new LinkedList<>();
    }
}
