package com.lau.geeklovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Creating the variables
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private EditText text;
    private String language, name;
    private Random rand = new Random();
    private int percentage_love, i = 1, j=1;
    private TextView result;
    private ImageView img1;
    private ImageView logo;
    private Button calculate, results;
    private TableLayout table;
    private TableRow row;
    private TextView col1,col2, col3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Initializing the variables

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

        logo = (ImageView) findViewById(R.id.logo);

        logo.setTranslationY(-3000);

        calculate = (Button) findViewById(R.id.submit);
        results = (Button) findViewById(R.id.results);

        table = (TableLayout) findViewById(R.id.results_table);

        table.setVisibility(View.GONE);

    }

    public void submit(View v){
        // Calculate button

        if(i%2 != 0) {// If it is in home page we show the name and the language
            language = spinner.getSelectedItem().toString();
            name = text.getText().toString();

            if (name.equalsIgnoreCase("")) {// if the name box is empty
                Toast toast = Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_LONG);
                toast.show();
            } else {
                percentage_love = (int) (rand.nextFloat() * 100);

                result.setText("" + percentage_love + " %");

                text.setVisibility(View.GONE);
                spinner.setVisibility(View.GONE);

                Log.i("Lang", language);


                row = new TableRow(this);
                col1 = new TextView(this);
                col2 = new TextView(this);
                col3 = new TextView(this);

                col1.setText(name);
                col2.setText(language);
                col3.setText("" + percentage_love + " %");

                col1.setGravity(Gravity.CENTER);
                col2.setGravity(Gravity.CENTER);
                col3.setGravity(Gravity.CENTER);

                row.addView(col1);
                row.addView(col2);
                row.addView(col3);

                table.addView(row);

                switch (language.toLowerCase(Locale.ROOT)) {// checks the language to show the correct logo

                    case "java":
                        logo.setImageResource(R.drawable.java);
                        break;
                    case "python":
                        logo.setImageResource(R.drawable.python);
                        break;
                    case "c":
                        logo.setImageResource(R.drawable.c);
                        break;
                    case "sql":
                        logo.setImageResource(R.drawable.sql);
                        break;
                    case "php":
                        logo.setImageResource(R.drawable.php);
                        break;
                    case "javascript":
                        logo.setImageResource(R.drawable.javascript);
                        break;
                    case "r":
                        logo.setImageResource(R.drawable.r_logo);
                        break;
                }

                logo.animate().translationYBy(3000).rotation(3600).setDuration(600);
                calculate.setText("Play Again");// we set the caluclate button to play again
                i++;
            }
        }
        else{// if we are in the result page we need to return to the home page when the button is pressed
                result.setText("");
                logo.setImageDrawable(null);
                logo.setTranslationY(-3000);
                text.setVisibility(View.VISIBLE);
                spinner.setVisibility(View.VISIBLE);
                calculate.setText("Calculate");
                i++;
            }

    }

    public void showResults(View view){
        // This button show the results of all his searches

        if(j == 1) { // if it is not pressed we go to the results
            table.setVisibility(View.VISIBLE);
            j++;
            result.setText("");
            logo.setVisibility(View.GONE);
            text.setVisibility(View.GONE);
            spinner.setVisibility(View.GONE);
            results.setText("Back");
            calculate.setVisibility(View.GONE);
        }
        else{// if pressed we go to the last page we visited the if statements make sure to go back to the pages we were at
            if(i%2 == 0){
                result.setText("" + percentage_love + " %");
            }
            else{
                result.setText("");
                text.setVisibility(View.VISIBLE);
                spinner.setVisibility(View.VISIBLE);
                calculate.setText("Calculate");
            }

            table.setVisibility(View.GONE);
            results.setText("Results");
            logo.setVisibility(View.VISIBLE);
            calculate.setVisibility(View.VISIBLE);

            j=1;
        }

    }
}