package com.example.run_the_world;

public class MyApplication {
    private String someVariable;

    public String getSomeVariable() {
        return someVariable;
    }

    public void setSomeVariable(String someVariable) {
        this.someVariable = someVariable;
    }
}

// set
//((MyApplication) this.getApplication()).setSomeVariable("foo");

// get
// String s = ((MyApplication) this.getApplication()).getSomeVariable();