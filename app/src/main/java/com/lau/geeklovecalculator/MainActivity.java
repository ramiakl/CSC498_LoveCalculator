package com.lau.geeklovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private EditText text;
    private String language, name;
    private Random rand = new Random();
    private int percentage_love;
    private TextView result;
    ImageView img1;
    ImageView logo;

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

        img1 = (ImageView) findViewById(R.id.img1);

        logo = (ImageView) findViewById(R.id.img2);

        logo.setTranslationY(-1500);
    }

    public void calculate(View v){

        language = spinner.getSelectedItem().toString();
        name = text.getText().toString();

        percentage_love = (int) (rand.nextFloat()*100);

        result.setText(""+percentage_love+" %");

        text.setVisibility(View.GONE);
        spinner.setVisibility(View.GONE);

        Log.i("Logo:", language);

        switch(language.toLowerCase(Locale.ROOT)){

            case "java":
                logo.setImageResource(R.drawable.java);
                break;
            case "python":
                logo.setImageResource(R.drawable.python);
                break;
            case "c":
                logo.setImageResource(R.drawable.c);
                break;
            case "r":
                logo.setImageResource(R.drawable.r);
                break;
            case "sql":
                logo.setImageResource(R.drawable.sql);
                break;
            case "php":
                logo.setImageResource(R.drawable.php);
                break;
        }
        logo.animate().translationYBy(1500).rotation(3600).setDuration(600);


    }
}