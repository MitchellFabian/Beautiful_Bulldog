package com.example.mitchell.beautifulbulldog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class BulldogListActivity extends AppCompatActivity {

    private ListView bulldogList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulldog_list);

        ArrayList<Bulldog> bulldogs = new ArrayList<Bulldog>();
        bulldogList = (ListView) findViewById(R.id.bulldog_list);

        Bulldog bulldog1 = new Bulldog();
        bulldog1.setAge("9");
        bulldog1.setName("Porterhouse");

        Bulldog bulldog2 = new Bulldog();
        bulldog2.setAge("2");
        bulldog2.setName("Drake");

        bulldogs.add(bulldog1);
        bulldogs.add(bulldog2);

        final BulldogArrayAdapter adapter = new BulldogArrayAdapter(this, bulldogs);
        bulldogList.setAdapter(adapter);
    }
}
