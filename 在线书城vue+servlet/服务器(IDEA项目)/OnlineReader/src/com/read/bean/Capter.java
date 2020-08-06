package com.read.bean;

public class Capter {
    private int c_id;
    private int b_id;

private int c_num;
    public Capter( int b_id, String c_name, String c_text) {

        this.b_id = b_id;
        this.c_name = c_name;
        this.c_text = c_text;
    }

    public Capter(int c_id,int b_id, String c_name, String c_text,int c_num) {
        this.c_id = c_id;
        this.b_id = b_id;
        this.c_name = c_name;
        this.c_text = c_text;
        this.c_num= c_num;
    }

    private  String c_name;
    private  String c_text;

    public int getC_num() {
        return c_num;
    }

    public void setC_num(int c_num) {
        this.c_num = c_num;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_text() {
        return c_text;
    }

    public void setC_text(String c_text) {
        this.c_text = c_text;
    }

    @Override
    public String toString() {
        return "Capter{" +
                "c_id=" + c_id +
                ", b_id=" + b_id +
                ", c_name='" + c_name + '\'' +
                ", c_text='" +
        '}';
    }
}
