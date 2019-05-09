package com.lambdaschool.unittestlogin;

import java.io.Serializable;

public class User implements Serializable {
    static final String TAG = "User";

    String favoriteAnimal, username, email, firstName, LastName;

    public User(String favoriteAnimal, String username, String email, String firstName, String lastName) {
        this.favoriteAnimal = favoriteAnimal;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        LastName = lastName;
    }

    public String getFavoriteAnimal() {
        return favoriteAnimal;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getDisplayName() {
        return LastName + ", " + firstName;
    }
}
