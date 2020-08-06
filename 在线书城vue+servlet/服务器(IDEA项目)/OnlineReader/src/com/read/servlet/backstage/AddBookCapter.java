package com.read.servlet.backstage;

import com.alibaba.fastjson.JSONObject;
import com.read.bean.Book;
import com.read.service.Backstage;
import com.read.service.Impl.Backstageimpl;
import com.read.service.Impl.ReaderOnlineImpl;
import com.read.service.ReaderOnline;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AddBookCapter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader br=req.getReader();
        String json=br.readLine();
//        System.out.println("这里是增加章节");
//        System.out.println(json);
        br.close();
        JSONObject object=JSONObject.parseObject(json);
        String bookname=object.getString("book");
        String captername=object.getString("title");
        String capternum=object.getString("num");
        String context=object.getString("body");
//        System.out.println(bookname);
//        System.out.println(captername);
//        System.out.println(capternum);
//        System.out.println(context);
        Backstage backstage=new Backstageimpl();
        //实例化PrintWriter对象，为之后输出数据做准备
        PrintWriter out=resp.getWriter();
        JSONObject jsonObject=new JSONObject();
        if(bookname==null||bookname.equals("")||captername==null||captername.equals("")||capternum==null||capternum.equals(""))
        {
            jsonObject.put("message","内容不能为空");
        }
        else {
            ReaderOnline readerOnline=new ReaderOnlineImpl();
            int bid=readerOnline.GetBookID(bookname);
            Book book=backstage.QueryBook(bid);
            if(book!=null&&!book.getB_name().equals(""))
            {
                if(backstage.AddCapter(bookname,Integer.parseInt(capternum),captername,context))
                {
                    jsonObject.put("message","添加成功");
                }
                else {
                    jsonObject.put("message","该章节已存在");
                }
            }
            else {
                jsonObject.put("message","该书不存在");
            }

        }
        out.print(jsonObject);
        out.flush();
        out.close();

    }
}
