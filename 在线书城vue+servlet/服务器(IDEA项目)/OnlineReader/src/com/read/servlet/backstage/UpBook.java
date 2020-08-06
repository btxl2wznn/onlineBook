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

public class UpBook extends HttpServlet {
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
        String b_id=object.getString("_id");
        String b_named=object.getString("name");
        String b_author=object.getString("author");
        String b_info=object.getString("info");
        String b_type=object.getString("type");
        String b_imgsrc=object.getString("icon");
        b_imgsrc="book"+b_imgsrc.substring(b_imgsrc.lastIndexOf("/"));
        PrintWriter out=resp.getWriter();
        JSONObject jsonObject=new JSONObject();
        if(b_id!=null&&!b_id.equals(""))
        {
//            System.out.println("nihao");
            Backstage backstage=new Backstageimpl();

            if(backstage.UpBook(Integer.parseInt(b_id),b_named,b_author,b_info,b_type,b_imgsrc))
            {
//                System.out.println("nihao");
                jsonObject.put("message","修改成功");
            }
            else {
//                System.out.println("nihao");
                jsonObject.put("message","增加失败,请检查书本ID与书本名");
            }
        }
        else {
            jsonObject.put("message","书本ID不为空");
        }
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
