package com.example.eslam.myplayground;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Eslam on 8/14/2017.
 */

public class TermsAndConditionsManager {
    public static final String LANDING_PAGE_INTENT_MODEL = "model";
    public static void initLandingPage(Context context, VfgTcLandingModel model){
        Intent intent = new Intent(context, MyTranslucentActivity.class);
        intent.putExtra(LANDING_PAGE_INTENT_MODEL,model);
        context.startActivity(intent);
    }
}
