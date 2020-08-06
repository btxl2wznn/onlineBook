package com.read.bean;

public class Type {
    String t_name;
    int t_num;

    public Type(String t_name, int t_num) {
        this.t_name = t_name;
        this.t_num = t_num;
    }

    @Override
    public String toString() {
        return "Type{" +
                "t_name='" + t_name + '\'' +
                ", t_num=" + t_num +
                '}';
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public int getT_num() {
        return t_num;
    }

    public void setT_num(int t_num) {
        this.t_num = t_num;
    }
}
