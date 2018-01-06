package com.example.eslam.myplayground;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FragmentsActivity extends AppCompatActivity {

    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);
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
}
