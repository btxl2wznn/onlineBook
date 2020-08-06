package com.read.dao;

import com.read.bean.Book;
import com.read.bean.User;

import java.util.ArrayList;

public interface Userdao {
    public boolean login(String name,String pass);//用户登录
    public boolean adminlogin(String name,String pass);//管理员登录
    public ArrayList<User> queryAllUser();          //查询所有用户
    public boolean addUser( String user_pwd, String user_name, String user_nick);           //增加用户
    public boolean addAdminUser( String user_pwd, String user_name, String user_nick);     //增加管理员用户
    public boolean delUser(int user_id);                       //删除用户
    public boolean upUser(int user_id,String user_pwd, String user_name, String user_nick);                         //修改用户
    public User queryByName(String name);                   //通过用户名查询用户
    public ArrayList<User> queryAllUser(String user_type); //按身份查询所有用户
    public ArrayList<Book> getUserShelf(int user_id); //获取用户收藏
    public boolean addShelf(int user_id, int b_id); //为用户增加收藏
    public int getUserId(String u_name);
    public boolean delShelf(int u_id, int b_id);

}

