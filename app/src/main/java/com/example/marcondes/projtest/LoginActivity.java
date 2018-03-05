package com.example.marcondes.projtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;

public class LoginActivity extends AppCompatActivity {

    private ListOfUser users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        users.items.add(new User("marcondesjra@gmail.com", "123456"));
        users.items.add(new User("marcondesamorim@gmail.com", "123456"));
        users.items.add(new User("marcondes@gmail.com", "123456"));
        users.items.add(new User("marcondesjorge@gmail.com", "123456"));
    }

    public void loginActivity(View v) {
        Intent it = new Intent(LoginActivity.this, MainActivity.class);


        startActivity(it);
    }

    public class User{

        String email;
        String password;

        User(String email, String password){
            this.email = email;
            this.password = password;
        }

        public boolean compareTO(User user){
            return this.email.equals(user.email) && this.email.equals(user.password);
        }
    }

    protected class ListOfUser{
        ArrayList<User> items;

        ListOfUser(){
            this.items = new ArrayList<User>();
        }

        public boolean contains(User user){
            for(User item : this.items){
                if (item.compareTO(user))
                    return true;

            }
            return false;
        }

    }
}

