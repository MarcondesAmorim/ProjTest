package com.example.marcondes.projtest.models;

import com.example.marcondes.projtest.LoginActivity;

/**
 * Created by Marcondes on 08/03/2018.
 */

public class User {

    public String email;
    public String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean compareTo(User user) {
        return this.email.equals(user.email) && this.password.equals(user.password);
    }
}

