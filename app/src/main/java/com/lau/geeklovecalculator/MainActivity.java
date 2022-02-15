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

        if(i%2 != 0) {
            language = spinner.getSelectedItem().toString();
            name = text.getText().toString();

            if (name.equalsIgnoreCase("")) {
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

                switch (language.toLowerCase(Locale.ROOT)) {

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
                }

                logo.animate().translationYBy(3000).rotation(3600).setDuration(600);
                calculate.setText("Play Again");
                i++;
            }
        }
        else{
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

        if(j == 1) {
            table.setVisibility(View.VISIBLE);
            j++;
            result.setText("");
            logo.setVisibility(View.GONE);
            text.setVisibility(View.GONE);
            spinner.setVisibility(View.GONE);
            results.setText("Back");
            calculate.setVisibility(View.GONE);
        }
        else{
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