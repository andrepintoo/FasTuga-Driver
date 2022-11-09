package ipleiria.taes.fastugadriver.entities;

import android.provider.ContactsContract;

public class Client extends User {
    private String address;

    public Client(String firstName, String lastName, ContactsContract.CommonDataKinds.Email email, String password, ContactsContract.CommonDataKinds.Phone phoneNumber) {
        super(firstName, lastName, email, password, phoneNumber);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
