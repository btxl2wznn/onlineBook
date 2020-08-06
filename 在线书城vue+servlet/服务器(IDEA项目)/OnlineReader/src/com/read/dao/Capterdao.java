package com.read.dao;

import com.read.bean.Capter;

import java.util.ArrayList;

public interface Capterdao {
    ArrayList<Capter> queryByName(String b_name);//通过书名查章节
    String queryByCid(int c_id);
    boolean upCapter(int c_id,String c_name,String C_text);
    boolean addCapter(String b_name,int c_num,String c_name,String c_text);
    boolean delCapter(int c_id);
    public ArrayList<Capter> query(String name,int b_id);
    public Capter queryBycid(int c_id);
    public ArrayList<Capter> queryByName(int b_id);
    public Capter queryByNum(int b_id,int c_num);

}