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

public class GetBookByType extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader br=req.getReader();
        String json=br.readLine();
//        System.out.println("这里是按分类的分页查询");
//        System.out.println(json);
        br.close();
        JSONObject object=JSONObject.parseObject(json);
        String page=object.getString("page");
        String category=object.getString("category");
//        System.out.println(category);
//        System.out.println(page);
        //实例化PrintWriter对象，为之后输出数据做准备
        PrintWriter out=resp.getWriter();
        if(page!=null||!page.equals(""))
        {
            JSONArray jsonArray=new JSONArray();
            ReaderOnline readerOnline=new ReaderOnlineImpl();
            int totalpage=readerOnline.typePagesNum(20,category);
            if(Integer.parseInt(page)>0) {
                ArrayList<Book> book = readerOnline.queryPageByType((Integer.parseInt(page) - 1)*20, 20,category);
                if (book.size() > 0 ) {
                    for (Book value : book) {
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("_id", value.getB_id());
                        jsonObject.put("name", value.getB_name());
                        jsonObject.put("author", value.getB_author());
                        jsonObject.put("category", value.getB_type());
                        jsonObject.put("info", value.getB_info());
                        jsonObject.put("icon", Ip.ip+ value.getB_imgsrc());
//                        System.out.println("ip未为"+Ip.ip+ value.getB_imgsrc());
                        jsonObject.put("page", totalpage*10);
                        jsonArray.add(jsonObject);
                    }
                    out.print(jsonArray);
                    out.flush();
                    out.close();
                } else {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("message", "没有页啦");
                    out.print(jsonObject);
                    out.flush();
                    out.close();
                }
            }
            else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("message", "已经是第一页啦");
                out.print(jsonObject);
                out.flush();
                out.close();
            }
        }

    }

}
