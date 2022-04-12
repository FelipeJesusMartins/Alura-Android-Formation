package com.jesus.agenda.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Student implements Serializable {

    private int id = 0;
    private String name;
    private String number;
    private String email;

    public Student() {

    }

    public Student(String name, String number, String email) {

        this.name = name;
        this.number = number;
        this.email = email;
    }

    public void setName(String name) {this.name = name;}

    public void setNumber(String number) {this.number = number;}

    public void setEmail(String email) {this.email = email;}

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    @NonNull
    @Override
    public String toString() {
        return name + '\n' + number + '\n' + email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean idIsValid() {
        return id > 0;
    }
}
