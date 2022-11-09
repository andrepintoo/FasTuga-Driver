package ipleiria.taes.fastugadriver.entities;

import android.provider.ContactsContract;

public class Client extends User {
    private String address;

    public Client(String firstName, String lastName, String email, String password, String phoneNumber) {
        super(firstName, lastName, email, password, phoneNumber);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
