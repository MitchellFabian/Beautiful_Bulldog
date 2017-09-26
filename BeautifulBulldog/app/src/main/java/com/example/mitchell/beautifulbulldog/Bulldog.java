package com.example.mitchell.beautifulbulldog;

import java.io.Serializable;

/**
 * Created by Mitchell on 9/26/2017.
 */

public class Bulldog implements Serializable {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
