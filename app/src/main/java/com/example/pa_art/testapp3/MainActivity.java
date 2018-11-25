package com.example.pa_art.testapp3;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView dice_view;
    private String dice_str = "";
    private String dice_names[] = {"4面ダイス", "6面ダイス", "8面ダイス", "10面ダイス", "12面ダイス", "20面ダイス"};
    private int dice_max[] = {4, 6, 8, 10, 12, 20};
    private int dice_num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup button
        Button button = findViewById(R.id.dice_button);
        // set listener to button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dice_view = findViewById(R.id.text_dice);
                dice_str = "" + ((int)(Math.random() * (dice_max[dice_num])) + 1);
                dice_view.setText(dice_str);
            }
        });

        // setup spinner
        final Spinner spinner = findViewById(R.id.dice_spinner);
        // setup ArrayAdapter
        ArrayAdapter<String> dice_adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                dice_names
        );
        // layout spinner ??
        dice_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // set adapter to spinner
        spinner.setAdapter(dice_adapter);
        // default selection of spinner
        spinner.setSelection(1);

        // spinner change handler; set listener to spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // if dropdown-list selected
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dice_num = spinner.getSelectedItemPosition();
            }
            // if no dropdown-list selected
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                dice_num = 1;
            }
        });

    }



}
