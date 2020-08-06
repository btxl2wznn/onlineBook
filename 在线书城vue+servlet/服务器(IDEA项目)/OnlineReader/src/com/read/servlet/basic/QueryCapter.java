package com.read.servlet.basic;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.read.bean.Capter;
import com.read.service.Impl.ReaderOnlineImpl;
import com.read.service.ReaderOnline;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class QueryCapter extends HttpServlet {
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
        String Cname=object.getString("name");
        String Bname=object.getString("bname");
//        System.out.println(Cname);
        //实例化PrintWriter对象，为之后输出数据做准备
        PrintWriter out=resp.getWriter();
        if(Cname!=null||!Cname.equals(""))
        {
            ReaderOnline readerOnline=new ReaderOnlineImpl();
            ArrayList<Capter> Capters = readerOnline.query(Cname,readerOnline.GetBookID(Bname));
            JSONArray jsonArray=new JSONArray();
            System.out.println("nihao");
            for (Capter capter : Capters) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("_id", capter.getC_id());
                jsonObject.put("num", capter.getC_num());
                jsonObject.put("title", capter.getC_name());
//                jsonObject.put("outline", book.get(i).getB_info());
                jsonArray.add(jsonObject);
            }
            out.print(jsonArray);
            out.flush();
            out.close();
        }
    }
}
