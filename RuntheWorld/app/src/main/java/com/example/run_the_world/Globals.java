package com.example.run_the_world;

import android.app.Application;

public class Globals{
    private static Globals instance;

    // Global variable
    private int data;

    // Restrict the constructor from being instantiated
    private Globals(){}

    public void setData(int d){
        this.data=d;
    }
    public int getData(){
        return this.data;
    }

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }
}


//Globals g = Globals.getInstance();
//g.setData(100);
//
//int data=g.getData();