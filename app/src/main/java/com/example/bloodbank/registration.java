package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class registration extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button btnsubmit;
    RadioGroup radioGroup;
    RadioButton radioButton;

    private EditText ET_FIRSTNAME, ET_LASTNAME, ET_USERNAME, ET_EMAIL, ET_PASSWORD, ET_CONFIRMPASSWORD, ET_ADDRESS, ET_MOBILENO;
    private static String URL_REGIST = "https://sipunculid-float.000webhostapp.com/register.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btnsubmit = findViewById(R.id.btnsubmit1);
        radioGroup = findViewById(R.id.radio);

        ET_FIRSTNAME = findViewById(R.id.ET_FIRSTNAME);
        ET_LASTNAME = findViewById(R.id.ET_LASTNAME);
        ET_USERNAME = findViewById(R.id.ET_USERNAME);
        ET_EMAIL = findViewById(R.id.ET_EMAIL);
        ET_PASSWORD = findViewById(R.id.ET_PASSWORD);
        ET_ADDRESS = findViewById(R.id.ET_ADDRESS);
        ET_MOBILENO = findViewById(R.id.ET_MOBILENO);
        ET_CONFIRMPASSWORD = findViewById(R.id.ET_CONFIRMPASSWORD);


        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> Adapter = ArrayAdapter.createFromResource(this, R.array.bloodtype, android.R.layout.simple_spinner_item);
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(Adapter);
        spinner.setOnItemSelectedListener(this);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedID = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(selectedID);

                  Regist();

            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void Regist() {

        int selectedID = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(selectedID);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> Adapter = ArrayAdapter.createFromResource(this, R.array.bloodtype, android.R.layout.simple_spinner_item);
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(Adapter);
        spinner.setOnItemSelectedListener(this);

        final String user_firstname = this.ET_FIRSTNAME.getText().toString().trim();
        final String user_lastname = this.ET_LASTNAME.getText().toString().trim();
        final String user_username =this.ET_USERNAME.getText().toString().trim();
        final String user_email = this.ET_EMAIL.getText().toString().trim();
        final String user_password = this.ET_PASSWORD.getText().toString().trim();
        final String user_cpassword = this.ET_CONFIRMPASSWORD.getText().toString().trim();
        final String bloodtype  = spinner.getSelectedItem().toString();
        final String user_gender = this.radioButton.getText().toString().trim();
        final String user_Address = this.ET_ADDRESS.getText().toString().trim();
        final String user_mobileno = this.ET_MOBILENO.getText().toString().trim();





        if(user_firstname.isEmpty()){
            Toast.makeText(this, "Enter First Name", Toast.LENGTH_SHORT).show();
            return;
        }else if(user_lastname.isEmpty()){
            Toast.makeText(this, "Enter Last Name", Toast.LENGTH_SHORT).show();
            return;
        }else if(user_username.isEmpty()){
            Toast.makeText(this, "Enter User Name", Toast.LENGTH_SHORT).show();
            return;
        }else if(user_email.isEmpty()){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }else if(user_password.isEmpty()){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }else if(user_Address.isEmpty()){
            Toast.makeText(this, "Enter Address", Toast.LENGTH_SHORT).show();
            return;
        }else if(user_mobileno.isEmpty()){
            Toast.makeText(this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
            return;
        }else if(user_password.equals(user_cpassword)){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equalsIgnoreCase("DATA INSERTED")){
                                Toast.makeText(registration.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(registration.this, response, Toast.LENGTH_SHORT).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(registration.this, "Register ERROR!!!! " + error.toString(), Toast.LENGTH_SHORT).show();

                        }
                    })
            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("FirstName", user_firstname);
                    params.put("LastName", user_lastname);
                    params.put("UserName", user_username);
                    params.put("Email", user_email);
                    params.put("Password", user_password);
                    params.put("Blood_Type", bloodtype);
                    params.put("Gender", user_gender);
                    params.put("Address", user_Address);
                    params.put("Mobile_Number", user_mobileno);

                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        }

        else{
            Toast.makeText(this, "Password did not match !!!", Toast.LENGTH_SHORT).show();
        }

    }


}


