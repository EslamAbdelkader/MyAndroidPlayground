package com.example.eslam.myplayground;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.eslam.myplayground.launch_modes_activites.SingleInstanceActivity;
import com.example.eslam.myplayground.launch_modes_activites.SingleTaskActivity;
import com.example.eslam.myplayground.launch_modes_activites.StandardActivity;

public class LaunchModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode);

        findViewById(R.id.standardActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LaunchModeActivity.this, StandardActivity.class));
            }
        });

        findViewById(R.id.singleTopActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LaunchModeActivity.this, SingleTaskActivity.class));
            }
        });

        findViewById(R.id.singleTaskActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LaunchModeActivity.this, SingleTaskActivity.class));
            }
        });

        findViewById(R.id.singleInstanceActivityButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LaunchModeActivity.this, SingleInstanceActivity.class));
            }
        });

    }
}
