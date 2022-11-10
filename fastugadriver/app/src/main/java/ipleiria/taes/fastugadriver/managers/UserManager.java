package ipleiria.taes.fastugadriver.managers;

import android.provider.ContactsContract;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ipleiria.taes.fastugadriver.entities.User;


public class UserManager {
    private static final UserManager instance = new UserManager();
    private LinkedList<User> users;

    public UserManager() {
        users = new LinkedList<>();
        users.add(new User("PrimeiroNome", "Apelido", "contacto@email.pt", "password", "912345678"));
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

    public boolean logInUser(String email, String password){
        User user = getUser(email);
        if(user == null){
            return false;
        }
        return user.getPassword().equals(password);
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    public void setUsers(LinkedList<User> users) {
        this.users = users;
    }
}
