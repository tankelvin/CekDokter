package com.mad.cekdokter.table;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {

    public String username;
    public String email;
    public String password;
    public String nohp;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User(String username, String email, String password, String nohp) {
        this.username = username;
        this.email = email;
        this.nohp = nohp;
        this.password = password;
    }

}