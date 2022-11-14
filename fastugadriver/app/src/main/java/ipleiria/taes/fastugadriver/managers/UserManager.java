package ipleiria.taes.fastugadriver.managers;

import android.provider.ContactsContract;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ipleiria.taes.fastugadriver.entities.Driver;
import ipleiria.taes.fastugadriver.entities.User;


public class UserManager {
    private static final UserManager instance = new UserManager();
    private LinkedList<User> users;
    private LinkedList<Driver> drivers;
    private User userLogged;

    public UserManager() {
        users = new LinkedList<>();
        drivers = new LinkedList<>();
        users.add(new User("PrimeiroNome", "Apelido", "contacto@email.pt", "password", "912345678"));
        userLogged = null;
    }

    public static UserManager getManager() {
        return instance;
    }

    public User getUser(String email) {
        for(User user : users){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public Driver getDriver(String email) {
        for(Driver driver : drivers){
            if(driver.getEmail().equals(email)){
                return driver;
            }
        }
        return null;
    }

    public boolean logInUser(String email, String password){
        User user = getUser(email);
        if(user == null){
            return false;
        }
        return user.getPassword().equals(password);
    }

    public boolean registerUser(String firstName, String lastName, String email, String password, String phoneNumber, String licensePlate){
        Driver driver = getDriver(email);
        if(driver != null){
            return false;
        }
        driver = new Driver(firstName, lastName, email, password, phoneNumber, licensePlate);
        return users.add(driver);
    }

    public void setUserLogged(String email){
        if(email.trim().isEmpty()){
            return;
        }
        userLogged = getUser(email);
    }

    public User getUserLogged() {
        return userLogged;
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    public void setUsers(LinkedList<User> users) {
        this.users = users;
    }
}
