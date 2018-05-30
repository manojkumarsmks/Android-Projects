package com.learnandroid.manojkumar.pulltorefresh;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    List<Movies> movieList;

    public RecyclerViewAdapter(Context context, List<Movies> movieList) {
        this.context = context;
        this.movieList = movieList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.simple_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.movie_title.setText(movieList.get(position).getName());
        // holder.movie_tumbnail.setImageResource(movieList.get(position).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView movie_title;

        public MyViewHolder(View itemView) {
            super(itemView);

            movie_title = (TextView)itemView.findViewById(R.id.movie_names);
        }
    }
}
