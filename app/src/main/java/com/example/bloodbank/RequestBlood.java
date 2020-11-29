package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RequestBlood extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button BTNSUBMIT;
    RadioGroup radioGroup;
    RadioButton radioButton;

    private EditText ET_FIRSTNAME, ET_LASTNAME, ET_BIRTHDATE, ET_ADDRESS, ET_MOBILENO, ET_LOCATIONWHERETODONATE, ET_MESSAGE;
    private static String URL_REQUESTBLOOD = "https://sipunculid-float.000webhostapp.com/requestblood.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_blood);

        BTNSUBMIT = findViewById(R.id.BTNREQUEST);
        radioGroup = findViewById(R.id.radio);

        ET_FIRSTNAME = findViewById(R.id.ET_FIRSTNAME);
        ET_LASTNAME = findViewById(R.id.ET_LASTNAME);
        ET_BIRTHDATE = findViewById(R.id.ET_BIRTHDATE);
        ET_ADDRESS = findViewById(R.id.ET_ADDRESS);
        ET_MOBILENO = findViewById(R.id.ET_MOBILENO);
        ET_LOCATIONWHERETODONATE = findViewById(R.id.ET_LOCATIONWHERETODONATE);
        ET_MESSAGE = findViewById(R.id.ET_MESSAGE);


        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> Adapter = ArrayAdapter.createFromResource(this, R.array.bloodtype, android.R.layout.simple_spinner_item);
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(Adapter);
        spinner.setOnItemSelectedListener(this);

        BTNSUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                requestblood();

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private void requestblood(){

        int selectedID = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(selectedID);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> Adapter = ArrayAdapter.createFromResource(this, R.array.bloodtype, android.R.layout.simple_spinner_item);
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(Adapter);
        spinner.setOnItemSelectedListener(this);


        final String user_firstname = this.ET_FIRSTNAME.getText().toString().trim();
        final String user_lastname = this.ET_LASTNAME.getText().toString().trim();
        final String user_birthdate = this.ET_BIRTHDATE.getText().toString().trim();
        final String bloodtype  = spinner.getSelectedItem().toString();
        final String user_gender = this.radioButton.getText().toString().trim();
        final String user_address = this.ET_ADDRESS.getText().toString().trim();
        final String user_mobileno = this.ET_MOBILENO.getText().toString().trim();
        final String user_location = this.ET_LOCATIONWHERETODONATE.getText().toString().trim();
        final String user_message = this.ET_MESSAGE.getText().toString().trim();




        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REQUESTBLOOD,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.equalsIgnoreCase("DATA INSERTED")){
                            Toast.makeText(RequestBlood.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(RequestBlood.this, response, Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RequestBlood.this, "Register ERROR!!!! " + error.toString(), Toast.LENGTH_SHORT).show();

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("FirstName", user_firstname);
                params.put("LastName", user_lastname);
                params.put("Date_Of_Birth", user_birthdate);
                params.put("Blood_Type", bloodtype);
                params.put("Gender", user_gender);
                params.put("Address", user_address);
                params.put("MobileNo", user_mobileno);
                params.put("LocationToDonate", user_location);
                params.put("MessageRequest", user_message);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}