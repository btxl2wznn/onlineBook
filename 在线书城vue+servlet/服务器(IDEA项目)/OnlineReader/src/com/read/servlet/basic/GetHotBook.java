package com.read.servlet.basic;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.read.bean.Book;
import com.read.bean.Ip;
import com.read.service.Backstage;
import com.read.service.Impl.Backstageimpl;
import com.read.service.Impl.ReaderOnlineImpl;
import com.read.service.ReaderOnline;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GetHotBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        ReaderOnline readerOnline=new ReaderOnlineImpl();
        ArrayList<Book> books=readerOnline.queryHotBook();
        PrintWriter printWriter=resp.getWriter();
        System.out.println("这里是获取热点书籍");
        if(books!=null&&books.size()>0)
        {
            JSONArray jsonArray=new JSONArray();
            for (Book book : books) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("_id", book.getB_id());
                jsonObject.put("name", book.getB_name());
                jsonObject.put("author", book.getB_author());
                jsonObject.put("category", book.getB_type());
                jsonArray.add(jsonObject);
            }

            printWriter.print(jsonArray);
            printWriter.flush();
            printWriter.close();
        }
    }
}
