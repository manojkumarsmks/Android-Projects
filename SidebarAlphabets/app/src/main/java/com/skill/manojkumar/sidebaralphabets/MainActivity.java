package com.skill.manojkumar.sidebaralphabets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    public static final String TAG= "Log_Statement";
    RecyclerView recyclerView;
    CountryAdapter countryAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    ArrayList<String> countryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        char[] alphabet = "ABCEDFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

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
        countryList.add("Madagascar");
        countryList.add("Malawi");
        countryList.add("Malaysia");
        countryList.add("Mali");
        countryList.add("Malt");
        countryList.add("Mexico");
        countryList.add("Namibia");
        countryList.add("Nepal");
        countryList.add("New Zealand");
        countryList.add("Nigeria");
        countryList.add("Pakistan");
        countryList.add("Panama");
        countryList.add("Paraguay");
        countryList.add("Peru");
        countryList.add("Serbia");
        countryList.add("South America");
        countryList.add("Srilanka");

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
        TypedValue outValue = new TypedValue();
        getApplication().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);

        for (int i=0; i<array.length; i++ ) {
            final TextView textView = new TextView(this);
            textView.setText(String.valueOf(array[i]));
            textView.setBackgroundResource(outValue.resourceId);
            textView.setTextColor(getResources().getColor(R.color.sideBarColor));

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    scrollToThePoint(textView.getText().toString());
                }
            });
            linearLayout.addView(textView);
        }
    }

    private void scrollToThePoint(String s) {

        Log.d(TAG, "Selected String is "+s);
        String currentTopElement = countryList.get(((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition());
        int position = 0;
        if(s.charAt(0) < currentTopElement.charAt(0)) {
            for(int i=0; i < countryList.indexOf(currentTopElement); i++) {
                if(countryList.get(i).charAt(0) == s.charAt(0)) {
                    position = i;
                    break;
                }
            }
        }
        else {
            for(int i=countryList.indexOf(currentTopElement); i < countryList.size()-1; i++) {
                if(countryList.get(i).charAt(0) == s.charAt(0)) {
                    position = i;
                    break;
                }
            }
        }

        RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(this) {
            @Override
            protected int getVerticalSnapPreference() {
                return LinearSmoothScroller.SNAP_TO_START;
            }
        };

        smoothScroller.setTargetPosition(position);

        mLayoutManager.startSmoothScroll(smoothScroller);
    }

}
