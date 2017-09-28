package com.example.mitchell.beautifulbulldog;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.Realm;

public class BulldogActivity extends AppCompatActivity {

    private TextView name;
    private Realm realm;
    private Spinner voter;
    private Button voteButton;
    private ImageView picture;
    private User owner;
    private Bulldog bulldog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulldog);

        name = (TextView) findViewById(R.id.dog_name);
        voter = (Spinner) findViewById(R.id.voter);
        voteButton = (Button) findViewById(R.id.vote_button);
        realm = Realm.getDefaultInstance();
        picture = (ImageView) findViewById(R.id.dog_image);

        String username = (String) getIntent().getStringExtra("username");
        owner = realm.where(User.class).equalTo("username", username).findFirst();

        String id = (String) getIntent().getStringExtra("bulldog");
        bulldog = realm.where(Bulldog.class).equalTo("id",id).findFirst();
        name.setText(bulldog.getName());

        if(bulldog.getImage() != null) {
            Bitmap bmp = BitmapFactory.decodeByteArray(bulldog.getImage(), 0, bulldog.getImage().length);
            picture.setImageBitmap(bmp);
        }
        name.setText(bulldog.getName());

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("0");
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        voter.setAdapter(adapter);

        voter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){

            }
        });
        voteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                realm.executeTransaction(new Realm.Transaction(){
                    @Override
                    public void execute(Realm realm){
                        Vote vote = new Vote();
                        vote.setOwner(owner);
                        vote.setRating(Integer.valueOf(voter.getSelectedItem().toString()));
                        bulldog.appendVote(vote);

                        finish();
                    }
                });
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the Realm instance.
        realm.close();
    }

}
