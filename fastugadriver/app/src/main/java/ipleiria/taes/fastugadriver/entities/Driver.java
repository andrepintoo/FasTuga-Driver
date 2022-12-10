package ipleiria.taes.fastugadriver.entities;

import android.provider.ContactsContract;

public class Driver extends User {
    private String licensePlate;

    public Driver(String firstName, String lastName, String email, String password, String phoneNumber, String licensePlate) {
        super(firstName, lastName, email, password, phoneNumber, 0,0, 0, 0.0);
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
