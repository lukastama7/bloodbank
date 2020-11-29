package com.example.bloodbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class MyAdapter1 extends ArrayAdapter<Requests> {

    Context context;

    List<Requests> arrayListRequests;


    public MyAdapter1(@NonNull Context context,List<Requests> arrayListRequests) {
        super(context, R.layout.cumtom_list_requests, arrayListRequests);

        this.context = context;
        this.arrayListRequests = arrayListRequests;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cumtom_list_requests, null,true);

        TextView tvID1 = view.findViewById(R.id.txt_name);
        TextView tvLocation1 = view.findViewById(R.id.txt_location);
        TextView tvmessage1 = view.findViewById(R.id.txt_message);


        tvID1.setText(arrayListRequests.get(position).getMessageRequest());
        tvLocation1.setText(arrayListRequests.get(position).getMessageRequest());
        tvmessage1.setText(arrayListRequests.get(position).getMessageRequest());




        return view;
    }
}
