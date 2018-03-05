package com.example.marcondes.projtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        EditText emailText;
        EditText passwordText;
        Intent it = new Intent(LoginActivity.this, MainActivity.class);
        emailText = (EditText)findViewById(R.id.email);
        passwordText = (EditText) findViewById(R.id.password);
        if(users.contains(new User(emailText.getText().toString(), passwordText.getText().toString()))){
            startActivity(it);
        } else{
           Context context = getApplicationContext();
            CharSequence text = "Usuaário/email inválido !";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
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

