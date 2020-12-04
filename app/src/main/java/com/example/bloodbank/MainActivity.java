package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CheckBox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button button, btnlogin;
    TextView signup;
    EditText editusername, editpassword;
    CheckBox showpassword;
    private static String URL_LOGIN = "https://sipunculid-float.000webhostapp.com/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup=findViewById(R.id.signup);
        btnlogin=findViewById(R.id.btnlogin);
        showpassword=findViewById(R.id.showpassword);

        editusername=findViewById(R.id.username);
        editpassword=findViewById(R.id.password);

        showpassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    editpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    editpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });




        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),registration.class));

            }
        });


    }

    public void btnlogin(View view) {

        if(editusername.getText().toString().equals("")){
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
        }else if(editpassword.getText().toString().equals("")){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        }else {

            String username = editusername.getText().toString().trim();
            String password = editpassword.getText().toString().trim();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if (response.equalsIgnoreCase("login success!!!!!!")) {
                                editusername.setText("");
                                editpassword.setText("");

                                startActivity(new Intent(getApplicationContext(), Menu.class));
                                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();

                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("UserName",username);
                    params.put("Password",password);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
















        }
    }
}