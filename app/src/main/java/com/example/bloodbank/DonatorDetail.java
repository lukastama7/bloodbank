package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DonatorDetail extends AppCompatActivity {


    TextView txtid, txtfullname, txtgender, txtbloodtype, txtemail, txtdatedonate, txtmobileno, txtaddress;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donator_detail);

        txtid= findViewById(R.id.txtid);
        txtfullname = findViewById(R.id.txtfullname);
        txtgender= findViewById(R.id.txtgender);
        txtbloodtype= findViewById(R.id.txtbloodtype);
        txtemail= findViewById(R.id.txtemail);
        txtdatedonate= findViewById(R.id.txtdatedonate);
        txtmobileno= findViewById(R.id.txtmobileno);
        txtaddress= findViewById(R.id.txtaddress);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");


        txtid.setText(List_Of_Donator.donatorsArrayList.get(position).getUSER_ID());
        txtfullname.setText(List_Of_Donator.donatorsArrayList.get(position).getFull_Name());
        txtgender.setText(List_Of_Donator.donatorsArrayList.get(position).getGender());
        txtbloodtype.setText(List_Of_Donator.donatorsArrayList.get(position).getBlood_Type());
        txtemail.setText(List_Of_Donator.donatorsArrayList.get(position).getEmail());
        txtdatedonate.setText(List_Of_Donator.donatorsArrayList.get(position).getDate_Donate());
        txtmobileno.setText(List_Of_Donator.donatorsArrayList.get(position).getMobileNo());
        txtaddress.setText(List_Of_Donator.donatorsArrayList.get(position).getAddress());
      ;



    }
}