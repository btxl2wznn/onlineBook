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

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GetCapter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader br=req.getReader();
        String json=br.readLine();
//        System.out.println("这里是按ID获取章节");
//        System.out.println(json);
        br.close();
//        String b_name=req.getParameter("bname");
//        System.out.println(b_name);
        JSONObject object=JSONObject.parseObject(json);
        String b_id=object.getString("_id");
//        System.out.println(b_id);
        //实例化PrintWriter对象，为之后输出数据做准备
        PrintWriter out=resp.getWriter();
        if(b_id!=null&&!b_id.equals(""))
        {
            ReaderOnline readerOnline=new ReaderOnlineImpl();
            ArrayList<Capter> capters=readerOnline.queryByID(Integer.parseInt(b_id));
            Backstage backstage=new Backstageimpl();
            Book book=backstage.QueryBook(Integer.parseInt(b_id));
            String bname=book.getB_name();
            JSONObject jsonObject1=new JSONObject();
            JSONArray jsonArray=new JSONArray();
            jsonObject1.put("_id",book.getB_id());
            jsonObject1.put("bname",book.getB_name());
            jsonObject1.put("author",book.getB_author());
            jsonObject1.put("category",book.getB_type());
            jsonObject1.put("outline",book.getB_info());
            jsonObject1.put("icon", Ip.ip +book.getB_imgsrc());
            if (capters!=null&&capters.size()>0)
            {

//                jsonObject1.put("Up",readerOnline.getThumbUp(i));
//                jsonArray.add(jsonObject1);
                for (Capter capter : capters) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("bname", bname);
                    jsonObject.put("title", capter.getC_name());
                    jsonObject.put("_id", capter.getC_id());
                    jsonObject.put("num", String.valueOf(capter.getC_num()));
                    jsonArray.add(jsonObject);
                }
                JSONArray jsonArray1=new JSONArray();
                jsonArray1.add(jsonObject1);
                jsonArray1.add(jsonArray);
                out.print(jsonArray1);
                out.flush();
                out.close();
            }
            else{

                JSONArray jsonArray1=new JSONArray();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("bname", bname);
                jsonObject.put("title", "没有章节信息");
                jsonObject.put("_id", "");
                jsonObject.put("num", "");
                jsonArray.add(jsonObject);
                jsonArray1.add(jsonObject1);
                jsonArray1.add(jsonArray);
                out.print(jsonArray1);
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

