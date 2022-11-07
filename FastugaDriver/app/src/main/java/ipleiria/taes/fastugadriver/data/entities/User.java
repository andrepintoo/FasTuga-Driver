package ipleiria.taes.fastugadriver.data.entities;

import android.provider.ContactsContract;

public class User {
    private String firstName, lastName;
    private ContactsContract.CommonDataKinds.Email email;
    private String password;
    private ContactsContract.CommonDataKinds.Phone phoneNumber;
    private String licensePlate;

    public User(String firstName, String lastName, ContactsContract.CommonDataKinds.Email email,
                String password, ContactsContract.CommonDataKinds.Phone phoneNumber, String licensePlate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.licensePlate = licensePlate;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ContactsContract.CommonDataKinds.Email getEmail() {
        return email;
    }

    public void setEmail(ContactsContract.CommonDataKinds.Email email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ContactsContract.CommonDataKinds.Phone getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(ContactsContract.CommonDataKinds.Phone phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
