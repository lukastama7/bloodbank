package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class List_Of_Request extends AppCompatActivity {

    ListView listView;
    MyAdapter1 adapter1;
    public static ArrayList<Requests> requestsArrayList = new ArrayList<>();

    String URL_REQUEST = "https://sipunculid-float.000webhostapp.com/retrieverequest.php";

    Requests requests;

    Button btnrequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__of__request);

        btnrequest = findViewById(R.id.btnrequest);

        listView=findViewById(R.id.mylistvieww);
        adapter1 = new MyAdapter1(this,requestsArrayList);

        listView.setAdapter(adapter1);

        retrieveData();

     btnrequest.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(getApplicationContext(),RequestBlood.class));
         }
     });

    }

    private void retrieveData() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REQUEST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        requestsArrayList.clear();
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            if(success.equals("1")){

                                for(int i=0; i<jsonArray.length(); i++){

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String id= object.getString("ID");
                                    String firstname= object.getString("FirstName");
                                    String lastname= object.getString("LastName");
                                    String birthdate= object.getString("Date_Of_Birth");
                                    String bloodtype= object.getString("Blood_Type");
                                    String gender= object.getString("Gender");
                                    String address = object.getString("Address");
                                    String mobileno= object.getString("MobileNo");
                                    String locationtodonate= object.getString("LocationToDonate");
                                    String messagerequest= object.getString("MessageRequest");

                                    requests = new Requests(id,firstname,lastname, birthdate,bloodtype,gender,address,mobileno,locationtodonate,messagerequest);
                                    requestsArrayList.add(requests);
                                    adapter1.notifyDataSetChanged();
                                }

                            }
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(List_Of_Request.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}