package com.read.dao;

import com.read.bean.Book;
import com.read.bean.Type;

import java.util.ArrayList;

public interface Bookdao {
    public ArrayList<Book> queryAllBook() ;         //查询所有书
    public boolean addBook(String b_name, String b_author, String b_info, String b_type,  String b_imgsrc);                       //新增小说
    public boolean upBook(int b_id,String b_name, String b_author, String b_info, String b_type,  String b_imgsrc);
    public boolean delBook(int b_id);
    public Book queryById(int b_id);
    public int queryByName(String b_name);         //通过name查书返回id
    public ArrayList<Book> queryPageBook(int start,int num); //根据页码返回图书信息
    public int pagesNum(int num); //获取分页后的页数
    public void giveThumbUp(int b_id);
    public int getThumbUp(int b_id);
    public ArrayList<Book> queryBooks(String b_name);
    public ArrayList<Book> queryByType(String b_type);
    public ArrayList<Type> queryTypeNum();
    public ArrayList<Book> queryPageByType(int start, int num,String type);
    public int typePagesNum(int num, String type);
    public ArrayList<Book> queryHotBook();
}
