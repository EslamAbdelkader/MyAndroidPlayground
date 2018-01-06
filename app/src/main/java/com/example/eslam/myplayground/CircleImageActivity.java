package com.example.eslam.myplayground;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class CircleImageActivity extends AppCompatActivity {

    private TextView circleTextView;
    private EditText nameEditText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_image_actiity);

        circleTextView = (TextView) findViewById(R.id.myCircle);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String letter = name.length() > 0 ? String.valueOf(name.charAt(0)).toUpperCase() : "?";
                circleTextView.setText(letter);
                circleTextView.setBackgroundTintList(ColorStateList.valueOf(generateRandomColor()));
            }
        });
    }

    private int generateRandomColor() {
        Random random = new Random();
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);
        return Color.rgb(red, green, blue);
    }
}
