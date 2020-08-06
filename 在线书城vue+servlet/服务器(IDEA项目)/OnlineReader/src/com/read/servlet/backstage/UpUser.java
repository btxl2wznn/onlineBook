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

public class UpUser extends HttpServlet {
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
//        System.out.println(object);
        String id=object.getString("_id");
//        System.out.println(id);
        String username=object.getString("username");
//        System.out.println(username);
        String password=object.getString("password");
//        System.out.println(password);
        String nick=object.getString("nick");
//        System.out.println(nick);
        PrintWriter out=resp.getWriter();
        JSONObject jsonObject=new JSONObject();
        if(id==null||id.equals("")||username==null||username.equals("")||password==null||password.equals(""))
        {
            jsonObject.put("message","用户名密码不为空");
        }
        else {
            Backstage backstage=new Backstageimpl();
//            System.out.println("你好");
            if(backstage.UpUser(Integer.parseInt(id),password,username,nick))
            {
                jsonObject.put("message","操作成功");
            }
            else {
                jsonObject.put("message","操作失败,请检查输入的用户名");
            }
        }
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
