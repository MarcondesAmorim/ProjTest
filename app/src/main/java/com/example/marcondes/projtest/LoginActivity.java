package com.example.marcondes.projtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marcondes.projtest.models.Logger;
import com.example.marcondes.projtest.models.User;

public class LoginActivity extends AppCompatActivity {

    Logger logger;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logger = new Logger();
        editTextEmail = (EditText) findViewById(R.id.editEmail);
        editTextPassword = (EditText) findViewById(R.id.editPassword);
        buttonLogin = (Button) findViewById(R.id.buttomLogin);
        createListeners();


    }

/*    public void loginActivity(View v) {
        EditText emailText;
        EditText passwordText;
        emailText = (EditText)findViewById(R.id.editEmail);
        passwordText = (EditText) findViewById(R.id.editPassword);
        User user = new User(emailText.getText().toString(), passwordText.getText().toString());

        Intent it = new Intent(LoginActivity.this, MainActivity.class);
        if(logger.login(user)){
            startActivity(it);
        }else {
            toastMessage("Email/Password invalid!");
        }
    }*/

    private void createListeners() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                if (email.isEmpty() || password.isEmpty())
                    Toast.makeText(getApplicationContext(), "Blank field", Toast.LENGTH_LONG).show();
                else{
                    boolean isValid = logger.login(new User(email, password));
                    if (isValid) {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Email/Password invalid!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

}

