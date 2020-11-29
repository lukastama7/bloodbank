package com.example.bloodbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter<Donators> {

    Context context;

    List<Donators> arrayListDonators;


    public MyAdapter(@NonNull Context context, List<Donators> arrayListDonators) {
        super(context, R.layout.cumtom_list_item,arrayListDonators);

        this.context = context;
        this.arrayListDonators = arrayListDonators;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cumtom_list_item, null, true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvName = view.findViewById(R.id.txt_name);
        TextView tvAddress = view.findViewById(R.id.txt_address);
        TextView tvDate = view.findViewById(R.id.txt_date);

        tvID.setText(arrayListDonators.get(position).getBlood_Type());
        tvName.setText(arrayListDonators.get(position).getFull_Name());
        tvAddress.setText(arrayListDonators.get(position).getAddress());
        tvDate.setText(arrayListDonators.get(position).getDate_Donate());

        return view;
    }
}
