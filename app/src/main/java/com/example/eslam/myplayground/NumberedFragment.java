package com.example.eslam.myplayground;


import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class NumberedFragment extends Fragment {

    private final String NUMBER_KEY = "number";
    private int number;

    public NumberedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NUMBER_KEY, number);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (savedInstanceState != null) {
            number = savedInstanceState.getInt(NUMBER_KEY);
        }
        Log.i(getClass().getSimpleName(), String.format("Fragment number %s: onCreateView", number));
        View view = inflater.inflate(R.layout.fragment_numbered, container, false);
        view.findViewById(R.id.rootView).setBackgroundColor(generateRandomColor());
        TextView textView = view.findViewById(R.id.numberTextView);
        textView.setText(String.valueOf(number));
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(getClass().getSimpleName(), String.format("Fragment %s: onAttach", number));
        Toast.makeText(context, String.format("Fragment %s: onAttach", number), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(getClass().getSimpleName(), String.format("Fragment %s: onCreate", number));
        Toast.makeText(getActivity(), String.format("Fragment %s: onCreate", number), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(getClass().getSimpleName(), String.format("Fragment %s: onStart", number));
        Toast.makeText(getActivity(), String.format("Fragment %s: onStart", number), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(getClass().getSimpleName(), String.format("Fragment %s: onResume", number));
        Toast.makeText(getActivity(), String.format("Fragment %s: onResume", number), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(getClass().getSimpleName(), String.format("Fragment %s: onPause", number));
        Toast.makeText(getActivity(), String.format("Fragment %s: onPause", number), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(getClass().getSimpleName(), String.format("Fragment %s: onStop", number));
        Toast.makeText(getActivity(), String.format("Fragment %s: onStop", number), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(getClass().getSimpleName(), String.format("Fragment %s: onDestroyView", number));
        Toast.makeText(getActivity(), String.format("Fragment %s: onDestroyView", number), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(getClass().getSimpleName(), String.format("Fragment %s: onDestroy", number));
        Toast.makeText(getActivity(), String.format("Fragment %s: onDestroy", number), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(getClass().getSimpleName(), String.format("Fragment %s: onDetach", number));
        Toast.makeText(getActivity(), String.format("Fragment %s: onDetach", number), Toast.LENGTH_SHORT).show();
    }

    private int generateRandomColor() {
        Random random = new Random();
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);
        return Color.rgb(red, green, blue);
    }

}
