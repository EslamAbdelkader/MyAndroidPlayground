package com.example.eslam.myplayground;

/**
 * Created by Eslam on 12/1/2017.
 */

public class MyClass {
    private String name;

    public MyClass(@Name String name) {
        this.name = name;
    }

    @Name
    public String getName() {
//        return "asdf";      //Gives a compilation error
//        return null;          //Applicable
        return name;        //Do not check the value of a variable
    }

    public void setName(@Name String name) {
        this.name = name;
    }
}
