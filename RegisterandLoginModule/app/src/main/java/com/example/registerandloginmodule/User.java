package com.example.registerandloginmodule;

public class User {
    private final String name;
    private final String email;
    private final String username;
    private final String pass;

    public User(String name, String email, String username, String pass) {
     this.name = name;
     this.email = email;
     this.username = username;
     this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }
}
