package com.read.servlet.basic;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.read.bean.Type;
import com.read.service.Impl.ReaderOnlineImpl;
import com.read.service.ReaderOnline;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GetTypeNum extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        ReaderOnline readerOnline=new ReaderOnlineImpl();
        ArrayList<Type> capters=readerOnline.queryTypeNum();
        PrintWriter printWriter=resp.getWriter();
//        System.out.println("你好");
        if(capters!=null&&capters.size()>0)
        {
//            System.out.println("你好");
            JSONArray jsonArray=new JSONArray();
            for(int i=0;i<capters.size();i++)
            {
//                System.out.println("你好");
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("num",capters.get(i).getT_num());
                jsonArray.add(jsonObject);
            }
//            System.out.println(jsonArray);
            printWriter.print(jsonArray);
            printWriter.flush();
            printWriter.close();
        }
    }
}
