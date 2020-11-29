package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button btndonateblood;
    Button btnbloodgroup;
    Button btnrequestblood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btndonateblood = findViewById(R.id.btndonateblood);
        btnbloodgroup = findViewById(R.id.btnbloodgroup);
        btnrequestblood = findViewById(R.id.btnrequestblood);


        btndonateblood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),DonateBlood.class));

            }
        });

        btnbloodgroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),List_Of_Donator.class));

            }
        });

        btnrequestblood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),List_Of_Request.class));

            }
        });
    }
}