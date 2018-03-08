package com.example.marcondes.projtest.models;

import android.content.Context;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * Created by Marcondes on 08/03/2018.
 */

public class Logger {

    public ArrayList<User> users;

    public Logger (){
        users = new ArrayList<User>();
        users.add(new User("marcondesjra@gmail.com", "123456"));
        users.add(new User("marcondesamorim@gmail.com", "123456"));
        users.add(new User("marcondes@gmail.com", "123456"));
        users.add(new User("marcondesjorge@gmail.com", "123456"));
        users.add(new User("m", "1"));
    }

    public boolean login(User user) {
        if (contains(user)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(User user){
        for(User item : users){
            if (item.compareTo(user))
                return true;

        }
        return false;
    }
    public void closeConnection(){};


}

