package com.example.eslam.myplayground;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<VfgTcLandingModel.PermissionItem> myList = new ArrayList<>();
        myList.add(new VfgTcLandingModel.PermissionItem("Title","Desc", VfgTcLandingModel.PermissionItem.PermissionIconEnum.TELEPHONE));
        myList.add(new VfgTcLandingModel.PermissionItem("Title","Desc", VfgTcLandingModel.PermissionItem.PermissionIconEnum.LOCATION));
        myList.add(new VfgTcLandingModel.PermissionItem("Title","Desc", ((BitmapDrawable)getApplicationContext().getDrawable(R.drawable.vfg_tc_location)).getBitmap()));
        VfgTcLandingModel model = new VfgTcLandingModel("Title","Header","Desc","Button",myList,"Footer Text Test","Test","Text");

        TermsAndConditionsManager.initLandingPage(getApplicationContext(),model);

    }
}
