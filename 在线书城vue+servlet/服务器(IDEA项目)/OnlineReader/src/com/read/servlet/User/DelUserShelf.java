package com.read.servlet.User;

import com.alibaba.fastjson.JSONObject;
import com.read.service.Impl.ReaderOnlineImpl;
import com.read.service.ReaderOnline;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class DelUserShelf extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader br = req.getReader();
        String json = br.readLine();
//        System.out.println("这里是按获取用户收藏");
//        System.out.println(json);
        br.close();
//        String b_name=req.getParameter("bname");
//        System.out.println(b_name);
        JSONObject object = JSONObject.parseObject(json);
        String b_id = object.getString("_id");
        String username = object.getString("username");
        PrintWriter out = resp.getWriter();
        ReaderOnline readerOnline = new ReaderOnlineImpl();
        JSONObject jsonObject1 = new JSONObject();
        int uid=readerOnline.getUserId(username);
        if (readerOnline.delShelf(uid, Integer.parseInt(b_id)))
        {
            jsonObject1.put("message","删除成功");
        }
        else {
            jsonObject1.put("message","删除失败");
        }
        out.print(jsonObject1);
        out.flush();
        out.close();
    }
}
