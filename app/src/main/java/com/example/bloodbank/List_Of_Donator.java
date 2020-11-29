package com.example.bloodbank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
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
import java.util.List;

public class List_Of_Donator extends AppCompatActivity {


    ListView listView;
     MyAdapter adapter;
    public static ArrayList<Donators> donatorsArrayList = new ArrayList<>();

     String URL_DONATE = "https://sipunculid-float.000webhostapp.com/retrieve.php";

     Donators donators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__of__donator);

        listView=findViewById(R.id.mylistview);
        adapter = new MyAdapter(this,donatorsArrayList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                CharSequence[] dialogItem = {"View Details"};
                builder.setTitle(donatorsArrayList.get(position).getFull_Name());

                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        switch (i){
                            case 0:

                                startActivity(new Intent(getApplicationContext(), DonatorDetail.class)
                                .putExtra("position", position));
                                break;
                        }


                    }
                });
                  builder.create().show();
            }
        });

        retrieveData();
    }

    public void retrieveData(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_DONATE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        donatorsArrayList.clear();
                        try {
                              JSONObject jsonObject = new JSONObject(response);

                              String success = jsonObject.getString("success");
                              JSONArray jsonArray = jsonObject.getJSONArray("data");

                            if(success.equals("1")){

                                for(int i=0; i<jsonArray.length(); i++){

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String id= object.getString("ID");
                                    String uid= object.getString("USER_ID");
                                    String Fullname= object.getString("Full_Name");
                                    String gender= object.getString("Gender");
                                    String bloodtype= object.getString("Blood_Type");
                                    String email= object.getString("Email");
                                    String dateDonate = object.getString("Date_Donate");
                                    String mobileno= object.getString("MobileNo");
                                    String address= object.getString("Address");

                                   donators = new Donators(id,uid,Fullname,gender,bloodtype,email,dateDonate,mobileno,address);
                                   donatorsArrayList.add(donators);
                                   adapter.notifyDataSetChanged();
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

                Toast.makeText(List_Of_Donator.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}