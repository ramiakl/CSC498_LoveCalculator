package com.lau.geeklovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<String> adapter;
    String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner1);

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.languages));

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner.setAdapter(adapter);
    }

    public void calculate(View v){

        language = spinner.getSelectedItem().toString();
        Toast.makeText(this, language, Toast.LENGTH_SHORT).show();
    }
}