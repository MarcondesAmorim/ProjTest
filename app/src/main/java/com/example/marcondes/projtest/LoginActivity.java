package com.example.marcondes.projtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

public class LoginActivity extends AppCompatActivity {

    public ListOfUser users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        users = new ListOfUser();
        users.items.add(new User("marcondesjra@gmail.com", "123456"));
        users.items.add(new User("marcondesamorim@gmail.com", "123456"));
        users.items.add(new User("marcondes@gmail.com", "123456"));
        users.items.add(new User("marcondesjorge@gmail.com", "123456"));
        users.items.add(new User("m", "1"));
    }

    public void loginActivity(View v) {
        EditText emailText;
        EditText passwordText;
        Intent it = new Intent(LoginActivity.this, MainActivity.class);
        emailText = (EditText)findViewById(R.id.email);
        passwordText = (EditText) findViewById(R.id.password);
        User user = new User(emailText.getText().toString(), passwordText.getText().toString());
        if(users.contains(user)){
            startActivity(it);
        } else{
            toastMessage("Email/Password invalid!");
        }
    }

    private void toastMessage(CharSequence message){
        Context context = getApplicationContext();
        int duration = message.length();
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();

    }
    public class User{

        String email;
        String password;

        User(String email, String password){
            this.email = email;
            this.password = password;
        }

        public boolean compareTO(User user){

            String thisUserEmail = this.email.toString();
            String thisUserPassword = this.password.toString();
            String thatUserEmail = user.email.toString();
            String thatUserPassword = user.password.toString();

            return  thisUserEmail.equals(thatUserEmail) && thisUserPassword.equals(thatUserPassword);


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

