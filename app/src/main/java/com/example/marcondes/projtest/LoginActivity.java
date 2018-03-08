package com.example.marcondes.projtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marcondes.projtest.models.Logger;
import com.example.marcondes.projtest.models.User;

public class LoginActivity extends AppCompatActivity {

    Logger logger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logger = new Logger();
    }

    public void loginActivity(View v) {
        EditText emailText;
        EditText passwordText;
        emailText = (EditText)findViewById(R.id.email);
        passwordText = (EditText) findViewById(R.id.password);
        User user = new User(emailText.getText().toString(), passwordText.getText().toString());

        Intent it = new Intent(LoginActivity.this, MainActivity.class);
        if(logger.login(user)){
            startActivity(it);
        }else {
            toastMessage("Email/Password invalid!");
        }
    }

    private void toastMessage(CharSequence message){
        Context context = getApplicationContext();
        int duration = message.length();
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

}

