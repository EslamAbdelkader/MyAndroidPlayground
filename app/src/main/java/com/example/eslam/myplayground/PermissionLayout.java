package com.example.eslam.myplayground;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Eslam on 8/14/2017.
 */

public class PermissionLayout extends RelativeLayout {
    public PermissionLayout(Context context, String title, String body, Bitmap icon) {
        super(context);
        init(context, title, body, icon);
    }

    public PermissionLayout(Context context,VfgTcLandingModel.PermissionItem permissionItem) {
        super(context);
        if(permissionItem.getPermissionIcon()!=null) {
            init(context, permissionItem.getTitle(), permissionItem.getDescription(), permissionItem.getPermissionIcon());
        }else{
            init(context, permissionItem.getTitle(), permissionItem.getDescription(), permissionItem.getIcon());
        }
    }

    public PermissionLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void init(Context context, String title, String body, VfgTcLandingModel.PermissionItem.PermissionIconEnum icon){
        Bitmap bitmap = null;
        switch (icon){
            //TODO INSERT ALL CASES & remove default
            case TELEPHONE:
                bitmap = ((BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.vfg_tc_telephone)).getBitmap();
                break;
            case LOCATION:
                bitmap =((BitmapDrawable) ContextCompat.getDrawable(context,R.drawable.vfg_tc_location)).getBitmap();
                break;
        }
        init(context,title,body,bitmap);
    }

    private void init(Context context, String title, String body, Bitmap icon) {
        View.inflate(context, R.layout.permission_layout, this);
        TextView titleTextView = findViewById(R.id.title);
        TextView bodyTextView = findViewById(R.id.body);
        ImageView iconImageView = findViewById(R.id.icon);
        titleTextView.setText(title);
        bodyTextView.setText(body);
        iconImageView.setImageBitmap(icon);
    }
}
