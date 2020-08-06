package com.read.servlet.basic;

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

public class QueryBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader br=req.getReader();
        String json=br.readLine();
//        System.out.println("谢谢");
//        System.out.println(json);
        br.close();
        JSONObject object=JSONObject.parseObject(json);
        String bname=object.getString("name");
//        System.out.println(bname);
        //实例化PrintWriter对象，为之后输出数据做准备
        PrintWriter out=resp.getWriter();
        if(bname!=null||!bname.equals(""))
        {

            ReaderOnline readerOnline=new ReaderOnlineImpl();
            ArrayList<Book> book=readerOnline.queryBooks(bname);
            JSONArray jsonArray=new JSONArray();
//            System.out.println("nihao");
            for (Book value : book) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("_id", value.getB_id());
                jsonObject.put("name", value.getB_name());
                jsonObject.put("author", value.getB_author());
                jsonObject.put("category", value.getB_type());
                jsonObject.put("info",value.getB_info());
                jsonObject.put("icon", Ip.ip+ value.getB_imgsrc());
                jsonArray.add(jsonObject);
            }
            out.print(jsonArray);
            out.flush();
            out.close();
        }

    }
}
