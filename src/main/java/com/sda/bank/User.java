package com.sda.bank;

public class User {

    private String firstName;
    private String lastName;
    private int id;

    public User(){
    }

    public User(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }
}
