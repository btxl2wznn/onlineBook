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

public class UpCapter extends HttpServlet {
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
        String c_id=object.getString("_id");
        String c_name=object.getString("title");
        String C_text=object.getString("body");
        PrintWriter out=resp.getWriter();
        JSONObject jsonObject=new JSONObject();
        if(c_id!=null&&!c_id.equals(""))
        {
            Backstage backstage=new Backstageimpl();
            if(backstage.UpCapter(Integer.parseInt(c_id),c_name,C_text))
            {
                jsonObject.put("message","操作成功");
            }
            else {
                jsonObject.put("message","操作失败");
            }
        }
        else {
            jsonObject.put("message","章节ID不为空");
        }
        out.print(jsonObject);
        out.flush();
        out.close();
    }

}
