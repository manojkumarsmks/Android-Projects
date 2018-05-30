package com.learnandroid.manojkumar.pulltorefresh;

import android.graphics.Movie;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Movies> moviesList = new ArrayList<Movies>();
    private SwipeRefreshLayout swipeRefreshLayout;
    Movies movies = new Movies("Avengers: Infinity War");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Pull to refresh");
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_layout);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateMovies();

                swipeRefreshLayout.setRefreshing(false);
            }
        });

        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent,
                R.color.colorPrimary, R.color.colorPrimaryDark);


        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new RecyclerViewAdapter(getApplicationContext(),moviesList);
        mRecyclerView.setAdapter(mAdapter);

        prepareMovies();
    }

    private void prepareMovies() {

        moviesList.add(movies);

        movies = new Movies("Deadpool 2");
        moviesList.add(movies);

        movies = new Movies("Solo: A Star Wars Story");
        moviesList.add(movies);

        movies = new Movies("Ant-Man and the Wasp");
        moviesList.add(movies);

        movies = new Movies("Black Panther");
        moviesList.add(movies);

        movies = new Movies("Annihilation");
        moviesList.add(movies);

        mAdapter.notifyDataSetChanged();
    }

    private void updateMovies(){

        movies = new Movies("Venom");
        moviesList.add(0, movies);

        movies = new Movies("Ready player one");
        moviesList.add(0, movies);

        movies = new Movies("Tomb Raider");
        moviesList.add(0, movies);

        mAdapter.notifyDataSetChanged();
    }
}
