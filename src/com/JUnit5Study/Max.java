package com.JUnit5Study;

public class Max {

    private int a;
    private int b;

    public int getMax(){
        int max=0;
        if(a>b){
            max=a;
        }else {
            max=b;
        }
        return max;
    }

    public Max(){}

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

}
