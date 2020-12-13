package com.ysh.homework1;

public class Data {
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;

    public int type;

    public String data;
    public Data(){}
    public Data(int type, String data){
        this.data = data;
        this.type = type;
    }
    public static int getTypeOne(){return TYPE_ONE;}
    public static int getTypeTwo(){return TYPE_TWO;}

    public int getType(){return type;}
    public String getData(){return data;}
}
