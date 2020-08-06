package com.read.service.Impl;

import com.read.bean.Book;
import com.read.bean.Capter;
import com.read.bean.User;
import com.read.dao.Bookdao;
import com.read.dao.Capterdao;
import com.read.dao.Userdao;
import com.read.dao.impl.Bookdaoimpl;
import com.read.dao.impl.Capterdaoimpl;
import com.read.dao.impl.Userdaoimpl;

import java.util.ArrayList;

public class Backstageimpl implements com.read.service.Backstage {

    @Override
    public ArrayList<User> queryAllUser() {
        Userdao userdao=new Userdaoimpl();
        return null;

    }

    @Override
    public ArrayList<Book> GetAllBooks() {
        Bookdao bookdao=new Bookdaoimpl();
        return bookdao.queryAllBook();
    }

    @Override
    public boolean DeleteBook(int id) {
        Bookdao bookdao=new Bookdaoimpl();
        return bookdao.delBook(id);
    }

    @Override
    public boolean AddBookByID(String name, String author, String category, String outline, String icon) {
        Bookdao bookdao=new Bookdaoimpl();
        return  bookdao.addBook(name, author, outline,category, icon);
    }

    @Override
    public ArrayList<Capter> GetBookCapter(String b_name) {
        Capterdao capterdao=new Capterdaoimpl();
        return capterdao.queryByName(b_name);
    }

    @Override
    public boolean AddAdmin(String password, String username,String nick) {
        Userdao userdao=new Userdaoimpl();
        return userdao.addAdminUser(password,username,nick);

    }

    @Override
    public ArrayList<User> QureyALLUsers(String user_type) {
        Userdao userdao=new Userdaoimpl();
        return    userdao.queryAllUser(user_type);
    }

    @Override
    public boolean AddCapter(String bname, int Cnum, String Ctitle, String Context) {
        Capterdao capterdao=new Capterdaoimpl();
        return capterdao.addCapter(bname,Cnum,Ctitle,Context);
    }

    @Override
    public boolean DeleleCapter(int Cid) {
        Capterdao capterdao=new Capterdaoimpl();
        return capterdao.delCapter(Cid);
    }

    @Override
    public boolean DeletetUser(int userid) {
        Userdao userdao=new Userdaoimpl();
        return userdao.delUser(userid);
    }

    @Override
    public boolean UpBook(int b_id, String b_name, String b_author, String b_info, String b_type, String b_imgsrc) {
        Bookdao bookdao=new Bookdaoimpl();
        return bookdao.upBook(b_id, b_name, b_author, b_info, b_type, b_imgsrc);
    }

    @Override
    public boolean UpUser(int user_id, String user_pwd, String user_name, String user_nick) {
        Userdao userdao=new Userdaoimpl();
        return userdao.upUser(user_id, user_pwd, user_name, user_nick);
    }

    @Override
    public Book QueryBook(int b_id) {
        Bookdao bookdao=new Bookdaoimpl();
        return bookdao.queryById(b_id);
    }

    @Override
    public boolean UpCapter(int c_id, String c_name, String C_text) {
        Capterdao capterdao=new Capterdaoimpl();
        return capterdao.upCapter(c_id,c_name,C_text);
    }

    @Override
    public boolean AddUser(String user_pwd, String user_name, String user_nick) {
        Userdao userdao=new Userdaoimpl();
        return userdao.addUser(user_pwd, user_name, user_nick);
    }

    @Override
    public Capter queryBycid(int c_id) {
        Capterdao capterdao=new Capterdaoimpl();
        return capterdao.queryBycid(c_id);
    }

    @Override
    public User queryByName(String name) {
        Userdao userdao=new Userdaoimpl();
        return userdao.queryByName(name);
    }


}
