package com.read.servlet.backstage;

import com.alibaba.fastjson.JSONObject;
import com.read.bean.Ip;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@MultipartConfig(location = "G://PE")
public class GetImg extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        System.out.println("upload....");
        Part part=req.getPart("icon"); //ͨ��bai���е�name���Ի�ȡ�����е��ļ�
//        System.out.println();
        String h = part.getHeader("content-disposition");
//        System.out.println("h��"+h);
//        HttpSession session=req.getSession();
//        String fname = session.getId();
        String name=part.getName();
//        System.out.println(name);
        String s=h.substring(h.lastIndexOf("."), h.length() - 1);
//        System.out.println(s);
        JSONObject jsonObject=new JSONObject();
        PrintWriter out=resp.getWriter();
        if(s.equals(".jpg")
                ||s.equals(".png")
                ||s.equals(".gif")
                ||s.equals(".bmp")
                ||s.equals(".webp")
                ||s.equals(".pcx")
        )
        {
            long c=System.currentTimeMillis();
            String ac=String.valueOf(c);
        ac = ac + s;
//        System.out.println(ac);
        String Url="F://新建文件夹//OnlineReader/out//artifacts//OnlineReader_war_exploded//book//"+ac;
        String imgUrl=Ip.ip+"book/"+ac;
        part.write(Url);
//        System.out.println(imgUrl);
        jsonObject.put("url",imgUrl);
        jsonObject.put("message","添加图片成功");

    }
        else {
            jsonObject.put("message","请放入一张图片");
        }
        out.print(jsonObject);
        out.flush();
        out.close();
    }




}
