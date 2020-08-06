package com.read.servlet.backstage;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.read.bean.User;
import com.read.service.Backstage;
import com.read.service.Impl.Backstageimpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GetComUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String user_type="普通用户";
        PrintWriter out=resp.getWriter();
//        System.out.println("这里是普通用户增加");
        if(user_type!=null&&!user_type.equals(""))
        {
            Backstage backstage=new Backstageimpl();
            ArrayList<User> users=backstage.QureyALLUsers(user_type);
            if(users.size()>0)
            {
                JSONArray jsonArray=new JSONArray();
                for (User user : users) {
                    JSONObject jsonObject1 = new JSONObject();
                    jsonObject1.put("username", user.getUser_name());
                    jsonObject1.put("_id", user.getUser_id());
                    jsonObject1.put("nick", user.getUser_nick());
                    jsonArray.add(jsonObject1);
                }

                out.print(jsonArray);
                out.flush();
                out.close();
            }

        }


    }
}
