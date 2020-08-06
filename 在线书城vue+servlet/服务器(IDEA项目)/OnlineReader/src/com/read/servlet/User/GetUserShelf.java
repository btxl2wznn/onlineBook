package com.read.servlet.User;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.read.bean.Book;
import com.read.bean.Ip;
import com.read.service.Impl.ReaderOnlineImpl;
import com.read.service.ReaderOnline;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GetUserShelf extends HttpServlet {

//有待商榷
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader br=req.getReader();
        String json=br.readLine();
//        System.out.println("这里是获取用户书架");
//        System.out.println(bookid);
        br.close();
        JSONObject object=JSONObject.parseObject(json);
//        System.out.println(bookid);
        //实例化PrintWriter对象，为之后输出数据做准备
        String bookid=object.getString("username");
        PrintWriter out=resp.getWriter();
        if(bookid!=null||!bookid.equals(""))
        {
            ReaderOnline readerOnline=new ReaderOnlineImpl();
            int id=readerOnline.getUserId(bookid);
//            System.out.println("用户ID为"+id);
            ArrayList<Book> books=readerOnline.getUserShelf(id);
            JSONArray jsonArray=new JSONArray();
            if(books.size()<=0)
            {
                JSONObject jsonObject1=new JSONObject();
                jsonObject1.put("message","无收藏书籍");
                out.print(jsonObject1);
                out.flush();
                out.close();
            }
            else {
            for(int i=0;i<books.size();i++) {
                for (Book book : books) {
//                    System.out.println("你好");
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("_id", book.getB_id());
                    jsonObject.put("name", book.getB_name());
                    jsonObject.put("author", book.getB_author());
                    jsonObject.put("category", book.getB_type());
                    jsonObject.put("info", book.getB_info());
                    jsonObject.put("icon", Ip.ip + book.getB_imgsrc());
                    jsonArray.add(jsonObject);
                }
                out.print(jsonArray);
                out.flush();
                out.close();
            }

            }

        }
    }
}
