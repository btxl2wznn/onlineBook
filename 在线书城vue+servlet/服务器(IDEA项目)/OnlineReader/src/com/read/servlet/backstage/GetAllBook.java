package com.read.servlet.backstage;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.read.bean.Book;
import com.read.bean.Ip;
import com.read.service.Backstage;
import com.read.service.Impl.Backstageimpl;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GetAllBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Backstage backstage=new Backstageimpl();
        ArrayList<Book> books=backstage.GetAllBooks();
        PrintWriter printWriter=resp.getWriter();
//        System.out.println("你好");
        if(books!=null&&books.size()>0)
        {
//            System.out.println("你好");
            JSONArray jsonArray=new JSONArray();
            for(int i=0;i<books.size();i++)
            {
//                System.out.println("你好");
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("_id",books.get(i).getB_id());
                jsonObject.put("name",books.get(i).getB_name());
                jsonObject.put("author",books.get(i).getB_author());
                jsonObject.put("category",books.get(i).getB_type());
                jsonObject.put("outline",books.get(i).getB_info());
                jsonObject.put("icon", Ip.ip+books.get(i).getB_imgsrc());
                jsonArray.add(jsonObject);
            }

            printWriter.print(jsonArray);
            printWriter.flush();
            printWriter.close();
        }
    }
}
