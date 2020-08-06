package com.read.servlet.User;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.read.service.Impl.UserLoginImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class UserLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader br=req.getReader();
        String json=br.readLine();
//        System.out.println(json);
        br.close();
        JSONObject object=JSONObject.parseObject(json);
        String username=object.getString("username");
        String password=object.getString("password");
//        System.out.println(username);
//        System.out.println(password);
        //实例化PrintWriter对象，为之后输出数据做准备
        PrintWriter out=resp.getWriter();
        if(username==null||username.equals("")||password==null||password.equals(""))
        {
            JSONObject jsonObject=new JSONObject();

            jsonObject.put("message","用户名和密码不为空");
            out.print(jsonObject);
            out.flush();
            out.close();
            return;
        }

//        System.out.println(username);
        //实例化接口对象
        com.read.service.UserLogin userLogin = new UserLoginImpl();
        //实例化JSON对象，储存要发送的数据
        JSONObject jsonObject=new JSONObject();
        if (!userLogin.Login(username,password)) {
            try {
                jsonObject.put("username",username);
                jsonObject.put("message","账号密码错误");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else {
//
//            HttpSession session = req.getSession();
//            String sessionID = session.getId();
//            System.out.println(sessionID);


            try {
                jsonObject.put("username", username);
                jsonObject.put("message", "登录成功");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
