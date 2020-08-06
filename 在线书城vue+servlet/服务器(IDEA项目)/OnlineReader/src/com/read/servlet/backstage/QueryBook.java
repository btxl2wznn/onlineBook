package com.read.servlet.backstage;

import com.alibaba.fastjson.JSONObject;
import com.read.bean.Book;
import com.read.bean.Ip;
import com.read.service.Backstage;
import com.read.service.Impl.Backstageimpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

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
        String bname=object.getString("id");
//        System.out.println(bname);
        //实例化PrintWriter对象，为之后输出数据做准备
        PrintWriter out=resp.getWriter();
        JSONObject jsonObject=new JSONObject();
        if(bname!=null||!bname.equals(""))
        {
            Backstage backstage=new Backstageimpl();
            Book book=backstage.QueryBook(Integer.parseInt(bname));
            jsonObject.put("id",book.getB_id());
            jsonObject.put("name",book.getB_name());
            jsonObject.put("author",book.getB_author());
            jsonObject.put("category",book.getB_type());
            jsonObject.put("outline",book.getB_info());
            jsonObject.put("icon", Ip.ip +book.getB_imgsrc());

        }
        else {
            jsonObject.put("message","请输入查询的书籍名");
        }
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
