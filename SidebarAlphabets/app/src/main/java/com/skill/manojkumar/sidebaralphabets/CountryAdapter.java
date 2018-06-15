package com.skill.manojkumar.sidebaralphabets;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private ArrayList<String> countryList;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView country;

        public ViewHolder(View itemView) {
            super(itemView);
            country = (TextView)itemView.findViewById(R.id.country_name);
        }
    }


    public CountryAdapter(ArrayList countryList) {
        this.countryList = countryList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list_row, parent, false);
       ViewHolder viewHolder = new ViewHolder(view);
       return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.country.setText(countryList.get(position));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }
}
