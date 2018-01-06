package com.example.eslam.myplayground;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MyTabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tab);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        for (int i = 0; i < 6; i++) {
            TabLayout.Tab tab = tabLayout.newTab().setText("Tab " + (i + 1)).setCustomView(R.layout.layout);
            TextView textView = tab.getCustomView().findViewById(R.id.text);
            textView.setText("Tab " + (i + 1));
            if (i == 0)
                tab.getCustomView().findViewById(R.id.imageView).setVisibility(View.VISIBLE);
            tabLayout.addTab(tab);
        }
        /*tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));*/
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(MyTabActivity.this, tab.getText(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MyTabActivity.this, "" + tab.getPosition(), Toast.LENGTH_SHORT).show();
                TextView textView = tab.getCustomView().findViewById(R.id.text);
                textView.setText(tab.getText());
                tab.getCustomView().findViewById(R.id.imageView).setVisibility(View.VISIBLE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Toast.makeText(MyTabActivity.this, tab.getText(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MyTabActivity.this, "" + tab.getPosition(), Toast.LENGTH_SHORT).show();
                TextView textView = tab.getCustomView().findViewById(R.id.text);
                textView.setText(tab.getText());
                tab.getCustomView().findViewById(R.id.imageView).setVisibility(View.GONE);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
