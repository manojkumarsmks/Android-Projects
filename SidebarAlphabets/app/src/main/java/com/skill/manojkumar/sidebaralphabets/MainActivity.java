package com.skill.manojkumar.sidebaralphabets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_STATEMENT = "Lod_Debug";
    RecyclerView recyclerView;
    CountryAdapter countryAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        char[] alphabet = "ABCEDFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        ArrayList<String> countryList = new ArrayList<>();

        recyclerView = (RecyclerView)findViewById(R.id.country_id);
        addSideBar(alphabet);
        //Preparing the data
        countryList.add("Afghanistan");
        countryList.add("Albania");
        countryList.add("Angola");
        countryList.add("Argentina");
        countryList.add("Armenia");
        countryList.add("Australia");
        countryList.add("Bahamas");
        countryList.add("Bangladesh");
        countryList.add("Belgium");
        countryList.add("Combodia");
        countryList.add("Cameroon");
        countryList.add("Canada");
        countryList.add("Cape Verde");
        countryList.add("Denmark");
        countryList.add("Dominica");
        countryList.add("Egypt");
        countryList.add("Eritrea");
        countryList.add("Ethiopia");
        countryList.add("Fiji");
        countryList.add("France");
        countryList.add("Finland");
        countryList.add("Gambia");
        countryList.add("Georgia");
        countryList.add("Great Britain");
        countryList.add("Greece");
        countryList.add("Haiti");
        countryList.add("Hungary");
        countryList.add("Iceland");
        countryList.add("Iran");
        countryList.add("Iraq");
        countryList.add("Italy");
        countryList.add("Jamaica");
        countryList.add("Japan");
        countryList.add("Jordan");
        countryList.add("Kazakhstan");
        countryList.add("Kenya");
        countryList.add("Kosovo");
        countryList.add("Kuwait");
        countryList.add("Latvia");
        countryList.add("Lebanon");
        countryList.add("Liberia");
        countryList.add("Libya");

        Collections.sort(countryList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });


        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        countryAdapter = new CountryAdapter(countryList);
        recyclerView.setAdapter(countryAdapter);


    }

    public void addSideBar(char[] array) {
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.alphabets);

        for (int i=0; i<array.length; i++ ) {
            TextView textView = new TextView(this);
            textView.setText(String.valueOf(array[i]));
            linearLayout.addView(textView);
        }
    }
}
