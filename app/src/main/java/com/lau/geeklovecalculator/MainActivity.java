package com.lau.geeklovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private EditText text;
    private String language, name;
    private Random rand = new Random();
    private int percentage_love;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner1);

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.languages));

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner.setAdapter(adapter);

        text = (EditText) findViewById(R.id.person_name);

        result = (TextView) findViewById(R.id.result);
        result.setText("");
    }

    public void calculate(View v){

        language = spinner.getSelectedItem().toString();
        name = text.getText().toString();

        percentage_love = (int) (rand.nextFloat()*100);

        result.setText(""+percentage_love+" %");

        text.setVisibility(View.GONE);
        spinner.setVisibility(View.GONE);


    }
}