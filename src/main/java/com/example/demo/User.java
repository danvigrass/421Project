package com.example.demo;

import java.util.ArrayList;

public class User {
    public String name;
    public int id;
    public String email;
    public String password;
    public ArrayList<Game> games = new ArrayList<Game>();
    public ArrayList<User> friends = new ArrayList();

    public User(String name, String email, String pw) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
