package com.read.servlet.basic;

import com.alibaba.fastjson.JSONObject;
import com.read.service.Impl.ReaderOnlineImpl;
import com.read.service.ReaderOnline;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GiveThumbUp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader br=req.getReader();
        String bookid=br.readLine();
//        System.out.println("这里是点赞");
//        System.out.println(bookid);
        br.close();
//        JSONObject object=JSONObject.parseObject(json);
//        System.out.println(bookid);
        //实例化PrintWriter对象，为之后输出数据做准备
        PrintWriter out=resp.getWriter();
        if(bookid!=null||!bookid.equals(""))
        {
            ReaderOnline readerOnline=new ReaderOnlineImpl();
            readerOnline.giveThumbUp(Integer.parseInt(bookid));
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("message","点赞成功");
            out.print(jsonObject);
            out.flush();
            out.close();
        }

    }

}
