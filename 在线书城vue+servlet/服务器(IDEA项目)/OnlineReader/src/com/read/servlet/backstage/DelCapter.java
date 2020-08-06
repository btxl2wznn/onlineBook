package com.read.servlet.backstage;

import com.alibaba.fastjson.JSONObject;
import com.read.service.Backstage;
import com.read.service.Impl.Backstageimpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class DelCapter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader br=req.getReader();
        String num=br.readLine();
//        System.out.println("这里是按ID删除章节");
//        System.out.println(num);
        br.close();
        //实例化PrintWriter对象，为之后输出数据做准备
        PrintWriter out=resp.getWriter();
        JSONObject jsonObject=new JSONObject();
        if(num!=null&&!num.equals(""))
        {
            Backstage backstage=new Backstageimpl();
            int _id=Integer.parseInt(num);
//            System.out.println("id是:"+_id);
            if(backstage.DeleleCapter(_id))
            {
                jsonObject.put("message","删除成功");
            }

        }
        else {
            jsonObject.put("message","请输入删除作品的ID");
        }
        out.print(jsonObject);
        out.flush();
        out.close();

    }
}
