package ipleiria.taes.fastugadriver.managers;

import java.util.LinkedList;

import ipleiria.taes.fastugadriver.entities.User;


public class UserManager {
    private LinkedList<User> users;

    private static final UserManager instance = new UserManager();

    public static UserManager getUser() {
        return instance;
    }

    public UserManager() {
        users = new LinkedList<>();
    }
}
