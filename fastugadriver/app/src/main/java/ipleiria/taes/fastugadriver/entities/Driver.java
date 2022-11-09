package ipleiria.taes.fastugadriver.entities;

import android.provider.ContactsContract;

public class Driver extends User {
    private String licensePlate;

    public Driver(String firstName, String lastName, ContactsContract.CommonDataKinds.Email email, String password, ContactsContract.CommonDataKinds.Phone phoneNumber, String licensePlate) {
        super(firstName, lastName, email, password, phoneNumber);
        this.licensePlate = licensePlate;
    }

    public Driver() {
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
