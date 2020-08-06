package com.read.servlet.basic;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.read.bean.Book;
import com.read.bean.Capter;
import com.read.bean.Ip;
import com.read.service.Backstage;
import com.read.service.Impl.Backstageimpl;
import com.read.service.Impl.ReaderOnlineImpl;
import com.read.service.ReaderOnline;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CapterRead extends HttpServlet {
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
        String c_id=object.getString("num");
        String b_id=object.getString("bookId");
//        System.out.println(c_id);
        //实例化PrintWriter对象，为之后输出数据做准备
        PrintWriter out=resp.getWriter();
        if(c_id!=null||!c_id.equals("")) {
            ReaderOnline readerOnline = new ReaderOnlineImpl();
            Backstage backstage = new Backstageimpl();
            Capter capter = readerOnline.queryByNum(Integer.parseInt(b_id), Integer.parseInt(c_id));
            if (capter == null || String.valueOf(capter.getC_id()).equals("")) {
                JSONObject jsonObject2 = new JSONObject();
                if (Integer.parseInt(c_id) > 0) {
                    jsonObject2.put("message", "无下一章");
                } else {
                    jsonObject2.put("message", "无上一章");
                }
                out.print(jsonObject2);
                out.flush();
                out.close();
            } else {
                JSONArray jsonArray = new JSONArray();
//                System.out.println("nihao");
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("_id", capter.getC_id()); //章节ID
                jsonObject.put("num", capter.getC_num());   //章节号
                jsonObject.put("title", capter.getC_name());    //章节标题
                jsonObject.put("body", capter.getC_text());      //章节内容
//            jsonObject.put("outline", book.get(i).getB_info());
                jsonArray.add(jsonObject);
                JSONObject jsonObject1 = new JSONObject();
                Book book = backstage.QueryBook(Integer.parseInt(b_id));
                jsonObject1.put("_id", book.getB_id());
                jsonObject1.put("icon", Ip.ip + book.getB_imgsrc());
                jsonObject1.put("author", book.getB_author());
                jsonObject1.put("name", book.getB_name());
                jsonObject1.put("category", book.getB_type());
                jsonArray.add(jsonObject1);
//                System.out.println(jsonArray);
                out.print(jsonArray);
                out.flush();
                out.close();
            }
        }
    }
}
