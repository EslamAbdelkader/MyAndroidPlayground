package com.example.eslam.myplayground;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.example.eslam.myplayground.Name.AHMED;
import static com.example.eslam.myplayground.Name.ESLAM;

/**
 * Created by Eslam on 12/1/2017.
 */

@Retention(RetentionPolicy.SOURCE)
@StringDef({ESLAM,AHMED})
public @interface Name {
    String ESLAM = "eslam";
    String AHMED = "ahmed";
}
