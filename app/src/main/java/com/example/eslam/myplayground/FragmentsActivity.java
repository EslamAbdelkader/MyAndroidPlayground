package com.example.eslam.myplayground;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FragmentsActivity extends AppCompatActivity {

    private final String NUMBER_KEY = "number";
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);
        number = savedInstanceState != null ? savedInstanceState.getInt(NUMBER_KEY) : 0;
        findViewById(R.id.addFragmentButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                FragmentManager fragmentManager = getFragmentManager();
                NumberedFragment fragment = new NumberedFragment();
                fragment.setNumber(number);
                fragmentManager.beginTransaction()
                        .add(R.id.fragmentContainer, fragment)
                        .commit();
            }
        });

        findViewById(R.id.addFragmentAndAddToBackStackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                FragmentManager fragmentManager = getFragmentManager();
                NumberedFragment fragment = new NumberedFragment();
                fragment.setNumber(number);
                fragmentManager.beginTransaction()
                        .add(R.id.fragmentContainer, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        findViewById(R.id.replaceFragmentButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                FragmentManager fragmentManager = getFragmentManager();
                NumberedFragment fragment = new NumberedFragment();
                fragment.setNumber(number);
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .commit();
            }
        });
        findViewById(R.id.replaceAndAddToBackStackFragmentButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                FragmentManager fragmentManager = getFragmentManager();
                NumberedFragment fragment = new NumberedFragment();
                fragment.setNumber(number);
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NUMBER_KEY, number);
    }
}
