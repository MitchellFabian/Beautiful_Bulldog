package com.example.mitchell.beautifulbulldog;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Mitchell on 9/26/2017.
 */

public class User extends RealmObject {
    @PrimaryKey
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
