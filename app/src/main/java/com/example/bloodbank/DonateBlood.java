package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

public class DonateBlood extends AppCompatActivity {


    Button btndonate;

    private EditText et_fullname, et_gender, et_bloodtype, et_email, et_mobileno, et_address, et_userid, ET_MOBILENO;
    private static String URL_DONATE = "https://sipunculid-float.000webhostapp.com/blooddonator.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_blood);

        btndonate=findViewById(R.id.btndonate);

        et_fullname = findViewById(R.id.et_fullname);
        et_gender = findViewById(R.id.et_gender);
        et_bloodtype = findViewById(R.id.et_bloodtype);
        et_email = findViewById(R.id.et_email);
        et_mobileno = findViewById(R.id.et_mobileno);
        et_address = findViewById(R.id.et_address);
        et_userid = findViewById(R.id.et_userid);

        btndonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                donate();

            }
        });

    }

    private void donate() {

        final String user_id = this.et_userid.getText().toString().trim();
        final String user_fullname = this.et_fullname.getText().toString().trim();
        final String user_gender = this.et_gender.getText().toString().trim();
        final String user_bloodtype =this.et_bloodtype.getText().toString().trim();
        final String user_email = this.et_email.getText().toString().trim();
        final String user_mobileno = this.et_mobileno.getText().toString().trim();
        final String user_address = this.et_address.getText().toString().trim();


            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_DONATE,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equalsIgnoreCase("DONATOR INSERTED")){
                                Toast.makeText(DonateBlood.this, "donator Inserted", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(DonateBlood.this, response, Toast.LENGTH_SHORT).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(DonateBlood.this, "Register ERROR!!!! " + error.toString(), Toast.LENGTH_SHORT).show();

                        }
                    })
            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("USER_ID", user_id);
                    params.put("Full_Name", user_fullname);
                    params.put("Gender", user_gender);
                    params.put("Blood_Type", user_bloodtype);
                    params.put("Email", user_email);
                    params.put("MobileNo", user_mobileno);
                    params.put("Address", user_address);

                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        }

}
