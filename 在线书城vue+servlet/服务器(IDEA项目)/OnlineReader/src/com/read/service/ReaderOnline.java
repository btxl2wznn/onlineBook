package com.read.service;

import com.read.bean.Book;
import com.read.bean.Capter;
import com.read.bean.Type;

import java.util.ArrayList;

public interface ReaderOnline {
    public int pagesNum(int num); //获取书籍页数
    public ArrayList<Book> queryPageBook(int start, int num); //根据页码返回图书信息
    public void giveThumbUp(int b_id);
    public boolean addShelf(int user_id, int b_id);//为用户添加收藏
    public ArrayList<Book> getUserShelf(int user_id); //获取用户收藏
    public int GetBookID(String bname); //根据书本名获取书本ID
    public int getThumbUp(int b_id);
    public int getUserId(String u_name);
    public ArrayList<Book> queryBooks(String b_name);
    public ArrayList<Capter> query(String name,int b_id);
    public ArrayList<Capter> queryByID(int b_id);
    public ArrayList<Type> queryTypeNum();
    public Capter queryByNum(int b_id,int c_num);
    public ArrayList<Book> queryByType(String b_type);
    public ArrayList<Book> queryPageByType(int start, int num,String type);
    public int typePagesNum(int num, String type);
    public ArrayList<Book> queryHotBook();
    public boolean delShelf(int u_id, int b_id);
}
