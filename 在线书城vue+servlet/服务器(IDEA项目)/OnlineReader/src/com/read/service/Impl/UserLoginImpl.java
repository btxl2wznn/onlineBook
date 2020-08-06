package com.read.service.Impl;

import com.read.dao.Userdao;

import com.read.dao.impl.Userdaoimpl;
import com.read.service.UserLogin;

public class UserLoginImpl implements UserLogin {

    @Override
    public boolean Login(String username, String password) {
        Userdao userdao=new Userdaoimpl();
        return userdao.login(username,password);
    }

    @Override
    public boolean AdminLogin(String username, String password) {
        Userdao userdao=new Userdaoimpl();
        return userdao.adminlogin(username,password);
    }
}
