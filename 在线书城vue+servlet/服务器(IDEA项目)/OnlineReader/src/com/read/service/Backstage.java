package com.read.service;

import com.read.bean.Book;
import com.read.bean.Capter;
import com.read.bean.User;

import java.util.ArrayList;

public interface Backstage {
    public ArrayList<User>  queryAllUser();
    public ArrayList<Book> GetAllBooks();
    public boolean DeleteBook(int id);
    public boolean AddBookByID(String name,String author,String category,String outline,String icon);
    public ArrayList<Capter> GetBookCapter(String b_name);
    public boolean AddAdmin(String password,String username,String nick);
    public ArrayList<User> QureyALLUsers(String user_type);
    public boolean AddCapter(String bname,int Cnum,String Ctitle,String Context);
    public boolean DeleleCapter(int Cid);
    public boolean DeletetUser(int userid);
    public boolean UpBook(int b_id,String b_name, String b_author, String b_info, String b_type,  String b_imgsrc);
    public boolean UpUser(int user_id,String user_pwd, String user_name, String user_nick);
    public Book QueryBook(int b_id);
    public boolean UpCapter(int c_id,String c_name,String C_text);
    public boolean AddUser( String user_pwd, String user_name, String user_nick);
    public Capter queryBycid(int c_id);
    public User queryByName(String name);                   //通过用户名查询用户


}
