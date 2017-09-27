package com.example.mitchell.beautifulbulldog;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Mitchell on 9/26/2017.
 */

public class BulldogApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();

        Realm.init(this);
    }


}
