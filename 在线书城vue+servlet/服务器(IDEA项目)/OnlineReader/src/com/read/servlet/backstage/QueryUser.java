package com.read.servlet.backstage;

import com.alibaba.fastjson.JSONObject;
import com.read.bean.User;
import com.read.service.Backstage;
import com.read.service.Impl.Backstageimpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader br=req.getReader();
        String json=br.readLine();
//        System.out.println("这里是按用户名查询用户");
//        System.out.println(json);
        br.close();
        JSONObject object=JSONObject.parseObject(json);
        String bname=object.getString("username");
//        System.out.println(bname);
        //实例化PrintWriter对象，为之后输出数据做准备
        PrintWriter out=resp.getWriter();
        JSONObject jsonObject=new JSONObject();
        if(bname!=null&&!bname.equals(""))
        {
//            System.out.println("你好");
            Backstage backstage=new Backstageimpl();
            User book=backstage.queryByName(bname);
            jsonObject.put("_id",book.getUser_id());
            jsonObject.put("username",book.getUser_name());
            jsonObject.put("nick",book.getUser_nick());
            jsonObject.put("password",book.getUser_pwd());
//            System.out.println(book);
        }
        else {
            jsonObject.put("message","请输入查询的账号");
        }
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
