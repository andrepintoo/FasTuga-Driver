package ipleiria.taes.fastugadriver.managers;

import android.provider.ContactsContract;

import java.util.LinkedList;

import ipleiria.taes.fastugadriver.entities.User;


public class UserManager {
    private static final UserManager instance = new UserManager();
    private LinkedList<User> users;

    public UserManager() {
        users = new LinkedList<>();
        User user = new User("PrimeiroNome", "Apelido", "contacto@email.pt", "password", "912345678");
    }

    public static UserManager getManager() {
        return instance;
    }

    public User getUser(String email) {
        // TODO: Get User by Email
        return users.get(0);
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    public void setUsers(LinkedList<User> users) {
        this.users = users;
    }
}
