package com.educate.countryretrofit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.educate.countryretrofit.R;
import com.educate.countryretrofit.model.CountryModel;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<CountryModel> countries;

    public RecyclerAdapter(ArrayList<CountryModel> countries) {
        this.countries = countries;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

    TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {


        holder.textView.setText(countries.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
}
