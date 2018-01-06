package com.example.eslam.myplayground;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class NumberedFragment extends Fragment {

    private int number;

    public NumberedFragment() {
        // Required empty public constructor
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(getClass().getSimpleName(),String.format("Fragment number %s: onCreateView",number));
        View view = inflater.inflate(R.layout.fragment_numbered, container, false);
        view.findViewById(R.id.rootView).setBackgroundColor(generateRandomColor());
        TextView textView = view.findViewById(R.id.numberTextView);
        textView.setText(String.valueOf(number));
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(getClass().getSimpleName(),String.format("Fragment %s: onCreate",number));
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(getClass().getSimpleName(),String.format("Fragment %s: onStart",number));
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(getClass().getSimpleName(),String.format("Fragment %s: onResume",number));
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(getClass().getSimpleName(),String.format("Fragment %s: onPause",number));
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(getClass().getSimpleName(),String.format("Fragment %s: onStop",number));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(getClass().getSimpleName(),String.format("Fragment %s: onDestroyView",number));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(getClass().getSimpleName(),String.format("Fragment %s: onDestroy",number));
    }

    private int generateRandomColor() {
        Random random = new Random();
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);
        return Color.rgb(red, green, blue);
    }

}
