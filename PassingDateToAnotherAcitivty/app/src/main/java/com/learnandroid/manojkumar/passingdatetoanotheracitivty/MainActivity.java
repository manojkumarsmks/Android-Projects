package com.learnandroid.manojkumar.passingdatetoanotheracitivty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstScreenEdittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("First Screen");
        setContentView(R.layout.activity_main);
        firstScreenEdittext = (EditText)findViewById(R.id.input_edittext);
        int posititon = firstScreenEdittext.getText().toString().length();
        Editable editable = firstScreenEdittext.getText();
        Selection.setSelection(editable, posititon);
    }

    private void startActivity() {
        Toast.makeText(getApplicationContext(), "GOT "+firstScreenEdittext.getText().toString(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), secondActivity.class);
        intent.putExtra("Input_value", firstScreenEdittext.getText().toString());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_done:
                startActivity();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
