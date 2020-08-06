package com.read.servlet.backstage;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.read.bean.Capter;
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
import java.util.ArrayList;

public class GetBookCapter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader br=req.getReader();
        String json=br.readLine();
//        System.out.println("谢谢");
//        System.out.println(json);
        br.close();
//        String b_name=req.getParameter("bname");
//        System.out.println(b_name);
        JSONObject object=JSONObject.parseObject(json);
        String b_name=object.getString("name");
//        System.out.println(b_name);
        //实例化PrintWriter对象，为之后输出数据做准备
        PrintWriter out=resp.getWriter();
        if(b_name!=null&&!b_name.equals(""))
        {
            Backstage backstage=new Backstageimpl();
            ArrayList<Capter> capters=backstage.GetBookCapter(b_name);
            if (capters!=null&&capters.size()>0)
            {
                JSONArray jsonArray=new JSONArray();
                JSONObject jsonObject1=new JSONObject();
                ReaderOnline readerOnline=new ReaderOnlineImpl();
                int i=readerOnline.GetBookID(b_name);
//                jsonObject1.put("Up",readerOnline.getThumbUp(i));
//                jsonArray.add(jsonObject1);
                for (Capter capter : capters) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("bname", b_name);
                    jsonObject.put("title", capter.getC_name());
                    jsonObject.put("body", capter.getC_text());
                    jsonObject.put("_id", capter.getC_id());
                    jsonObject.put("num", capter.getC_num());
                    jsonArray.add(jsonObject);
                }
                out.print(jsonArray);
                out.flush();
                out.close();
            }
            else{
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("message","该书没有章节");
                out.print(jsonObject);
                out.flush();
                out.close();
            }
        }
        else {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("message","请输入要搜索的书籍名全称");
            out.print(jsonObject);
            out.flush();
            out.close();
        }
    }
}
