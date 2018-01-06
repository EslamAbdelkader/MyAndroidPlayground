package com.example.eslam.myplayground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode().setDuration(3000));
        setContentView(R.layout.activity_spinner);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(SpinnerActivity.this,
                R.layout.support_simple_spinner_dropdown_item,
                Arrays.asList("Eslam", "Ahmed", "Doaa")));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SpinnerActivity.this,
                        "Item Selected: " + adapterView.getItemAtPosition(i).toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(SpinnerActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.checkButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SpinnerActivity.this,
                        "Item selected: "+spinner.getSelectedItem().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.setButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner.setSelection(2);
                //ADSAd
            }
        });

    }
}
