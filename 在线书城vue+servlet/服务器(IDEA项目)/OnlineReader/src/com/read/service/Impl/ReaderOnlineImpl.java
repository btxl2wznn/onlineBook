package com.read.service.Impl;

import com.read.bean.Book;
import com.read.bean.Capter;
import com.read.bean.Type;
import com.read.dao.Bookdao;
import com.read.dao.Capterdao;
import com.read.dao.Userdao;
import com.read.dao.impl.Bookdaoimpl;
import com.read.dao.impl.Capterdaoimpl;
import com.read.dao.impl.Userdaoimpl;
import com.read.service.ReaderOnline;

import java.util.ArrayList;

public class ReaderOnlineImpl implements ReaderOnline {

    @Override
    public int pagesNum(int num) {
        Bookdao bookdao=new Bookdaoimpl();
        return bookdao.pagesNum(20);
    }

    @Override
    public ArrayList<Book> queryPageBook(int start, int num) {
        Bookdao bookdao=new Bookdaoimpl();
        return bookdao.queryPageBook(start,20);
    }

    @Override
    public void giveThumbUp(int b_id) {
        Bookdao bookdao= new Bookdaoimpl();
        bookdao.giveThumbUp(b_id);
    }

    @Override
    public boolean addShelf(int user_id, int b_id) {
        Userdao userdao=new Userdaoimpl();
        return userdao.addShelf(user_id,b_id);
    }

    @Override
    public ArrayList<Book> getUserShelf(int user_id) {
        Userdao userdao=new Userdaoimpl();
        return userdao.getUserShelf(user_id);
    }

    @Override
    public int GetBookID(String bname) {
        Bookdao bookdao=new Bookdaoimpl();
        return bookdao.queryByName(bname);
    }
    @Override
    public int getThumbUp(int b_id) {
        Bookdao bookdao=new Bookdaoimpl();
        return bookdao.getThumbUp(b_id);
    }

    @Override
    public int getUserId(String u_name) {
        Userdao userdao=new Userdaoimpl();
        return userdao.getUserId(u_name);
    }

    @Override
    public ArrayList<Book> queryBooks(String b_name) {
        Bookdao bookdao=new Bookdaoimpl();
        return  bookdao.queryBooks(b_name);
    }

    @Override
    public ArrayList<Capter> query(String name, int b_id) {
        Capterdao capterdao=new Capterdaoimpl();
        return capterdao.query(name,b_id);
    }

    @Override
    public ArrayList<Capter> queryByID(int b_id) {
        Capterdao capterdao=new Capterdaoimpl();
        return capterdao.queryByName(b_id);
    }

    @Override
    public ArrayList<Type> queryTypeNum() {
        Bookdao bookdao=new Bookdaoimpl();
        return bookdao.queryTypeNum();
    }

    @Override
    public Capter queryByNum(int b_id, int c_num) {
        Capterdao capterdao=new Capterdaoimpl();
        return capterdao.queryByNum(b_id, c_num);
    }

    @Override
    public ArrayList<Book> queryByType(String b_type) {
        Bookdao bookdao=new Bookdaoimpl();
        return bookdao.queryByType(b_type);
    }

    @Override
    public ArrayList<Book> queryPageByType(int start, int num, String type) {
        Bookdao bookdao=new Bookdaoimpl();
        return bookdao.queryPageByType(start*20,20,type);
    }

    @Override
    public int typePagesNum(int num, String type) {
        Bookdao bookdao=new Bookdaoimpl();
        return bookdao.typePagesNum(20,type);
    }

    @Override
    public ArrayList<Book> queryHotBook() {
        Bookdao bookdao=new Bookdaoimpl();
        return bookdao.queryHotBook();
    }

    @Override
    public boolean delShelf(int u_id, int b_id){
        Userdao userdao=new Userdaoimpl();
        return userdao.delShelf( u_id,  b_id);
    }


}
