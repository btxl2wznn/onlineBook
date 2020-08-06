package com.read.servlet.backstage;

import com.alibaba.fastjson.JSONObject;
import com.read.service.Backstage;
import com.read.service.Impl.Backstageimpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AddAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader br=req.getReader();
        String json=br.readLine();
//        System.out.println("这里是增加");
//        System.out.println(json);
        br.close();
        JSONObject object=JSONObject.parseObject(json);
        String username=object.getString("username");
        String password=object.getString("password");
        String nick=object.getString("nick");
        JSONObject jsonObject=new JSONObject();
        if(username==null||username.equals("")||password==null||password.equals("")) {
            jsonObject.put("message","内容不能为空");
        }
        else {
            if(nick==null)
                nick="";
            Backstage backstage=new Backstageimpl();
            if(backstage.AddAdmin(password,username,nick))
            {
                jsonObject.put("message","添加成功");
            }
            else {
                jsonObject.put("message","该名称已被注册");
            }
        }
        
        PrintWriter out=resp.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();

    }
}
