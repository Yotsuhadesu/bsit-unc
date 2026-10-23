package com.entryapp;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String gender;
    private final LocalDate birthday;
    private final String address;
    private final String contactNumber;

    public Person(String lastName, String firstName, String middleName, String gender, LocalDate birthday, String address, String contactNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public String getLastName() {
        return this.lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getMiddleName() {
        return this.middleName;
    }
    public int getAge() {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }
    public String getGender() {
        return this.gender;
    }
    public LocalDate getBirthday() {
        return this.birthday;
    }
    public String getAddress() {
        return this.address;
    }
    public String getContactNumber() {
        return this.contactNumber;
    }
}
