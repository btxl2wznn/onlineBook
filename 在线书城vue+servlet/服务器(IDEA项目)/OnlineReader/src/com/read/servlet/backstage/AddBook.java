package com.read.servlet.backstage;

import com.alibaba.fastjson.JSONObject;
import com.read.service.Backstage;
import com.read.service.Impl.Backstageimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
@MultipartConfig(location = "G://PE")
public class AddBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader br = req.getReader();
        String json = br.readLine();
//        System.out.println("这里是增加");
//        System.out.println(json);
        br.close();
        JSONObject object = JSONObject.parseObject(json);
        String name = object.getString("name");
        String author = object.getString("author");
        String category = object.getString("category");
        String outline = object.getString("outline");
        String icon = object.getString("icon");
        PrintWriter out = resp.getWriter();
        JSONObject jsonObject = new JSONObject();
//        System.out.println(icon);
//        System.out.println(name);
//        System.out.println(author);
//        System.out.println(category);
//        System.out.println(outline);
//        System.out.println(icon);
        if (name == null || "".equals(name) || author == null || "".equals(author) || category == null || "".equals(category) || outline == null || "".equals(outline)||icon==null||"".equals(icon)) {
                jsonObject.put("message","内容不能为空");
        }else {
            icon = "book" + icon.substring(icon.lastIndexOf("/"));
            Backstage backstage = new Backstageimpl();
            //实例化PrintWriter对象，为之后输出数据做准备
            if (backstage.AddBookByID(name, author, category, outline, icon)) {
//            HttpSession session=req.getSession();
//            System.out.println(session.getId());
                jsonObject.put("message", "添加成功");
            } else {
                jsonObject.put("message", "该书籍已存在");
            }

        }
        out.print(jsonObject);
        out.flush();
        out.close();


    }

}
