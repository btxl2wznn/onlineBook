package com.read.bean;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class User {
    private  int user_id;                  //用户id
    private String user_pwd;                //用户密码
    private boolean user_islogin=false;     //是否登录
    private String user_name;               //用户名
    private String user_nick;               //用户昵称
    private ArrayList<Book> user_sheet;     //用户书架
    private ArrayList<Book> user_history;   //用户阅读历史
    private ArrayList<Book> user_creat=null;     //用户创作书架
    private String role;
    private String uer_retime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());                //注册时间

    public User(int user_id, String user_pwd, String user_name, String user_nick, String role) {
        this.user_id = user_id;
        this.user_pwd = user_pwd;
        this.user_name = user_name;
        this.user_nick = user_nick;
        this.role=role;
    }
    public User( String user_pwd, String user_name, String user_nick, String role) {

        this.user_pwd = user_pwd;
        this.user_name = user_name;
        this.user_nick = user_nick;
        this.role=role;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_islogin=" + user_islogin +
                ", user_name='" + user_name + '\'' +
                ", user_nick='" + user_nick + '\'' +
                ", user_sheet=" + user_sheet +
                ", user_history=" + user_history +
                ", user_creat=" + user_creat +
                ", role='" + role + '\'' +
                ", uer_retime=" + uer_retime +
                '}';
    }

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_nick() {
        return user_nick;
    }

    public void setUser_nick(String user_nick) {
        this.user_nick = user_nick;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUer_retime() {
        return uer_retime;
    }

    public void setUer_retime(String uer_retime) {
        this.uer_retime = uer_retime;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public boolean isUser_islogin() {
        return user_islogin;
    }

    public void setUser_islogin(boolean user_islogin) {
        this.user_islogin = user_islogin;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public ArrayList<Book> getUser_sheet() {
        return user_sheet;
    }

    public void setUser_sheet(ArrayList<Book> user_sheet) {
        this.user_sheet = user_sheet;
    }

    public ArrayList<Book> getUser_history() {
        return user_history;
    }

    public void setUser_history(ArrayList<Book> user_history) {
        this.user_history = user_history;
    }

    public ArrayList<Book> getUser_creat() {
        return user_creat;
    }

    public void setUser_creat(ArrayList<Book> user_creat) {
        this.user_creat = user_creat;
    }



        }