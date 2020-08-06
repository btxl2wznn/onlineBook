package com.read.servlet.User;

import com.alibaba.fastjson.JSONObject;
import com.read.bean.Book;
import com.read.service.Impl.ReaderOnlineImpl;
import com.read.service.ReaderOnline;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AddUserShelf extends HttpServlet {
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
        String bookid=object.getString("_id");
        JSONObject jsonObject=new JSONObject();
        if(username==null||username.equals("")||bookid==null||bookid.equals("")) {
            jsonObject.put("message","用户未登录");
        }
        else {
            ReaderOnline readerOnline=new ReaderOnlineImpl();
            int id=readerOnline.getUserId(username);
//            System.out.println(id);
            ArrayList<Book> books=readerOnline.getUserShelf(id);
            int bid=Integer.parseInt(bookid);
//            System.out.println(bid);
            int controll=0;
            for (Book book : books) {
//                System.out.println("123 ");
                if (book.getB_id() == bid) {
                    System.out.println("321");
                    jsonObject.put("message", "已存在");
                    controll++;
                    break;
                }
            }
//            System.out.println("321");
            if(controll==0) {
                if (readerOnline.addShelf(id, bid)) {
//                    System.out.println("321");
                    jsonObject.put("message", "添加成功");
                } else {
//                    System.out.println("121");
                    jsonObject.put("message", "添加失败");
                }
            }
        }

        PrintWriter out=resp.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();

    }
}
