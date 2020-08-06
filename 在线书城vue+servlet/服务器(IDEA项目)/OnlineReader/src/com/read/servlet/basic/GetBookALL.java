package com.read.servlet.basic;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.read.bean.Book;
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

public class GetBookALL extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Backstage backstage=new Backstageimpl();
        ReaderOnline readerOnline=new ReaderOnlineImpl();
        ArrayList<Book> books=backstage.GetAllBooks();
        PrintWriter printWriter=resp.getWriter();
//        System.out.println("你好");
        if(books!=null&&books.size()>0)
        {
            int page=readerOnline.pagesNum(20);
//            System.out.println("你好");
            JSONArray jsonArray=new JSONArray();
            for (Book book : books) {
//                System.out.println("你好");
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("_id", book.getB_id());
                jsonObject.put("name", book.getB_name());
                jsonObject.put("author", book.getB_author());
                jsonObject.put("category", book.getB_type());
                jsonObject.put("outline", book.getB_info());
                jsonObject.put("icon", "http://192.168.43.111:9090/OnlineReader/" + book.getB_imgsrc());
                jsonObject.put("page",page);
                jsonArray.add(jsonObject);
            }

            printWriter.print(jsonArray);
            printWriter.flush();
            printWriter.close();
        }

    }
}
