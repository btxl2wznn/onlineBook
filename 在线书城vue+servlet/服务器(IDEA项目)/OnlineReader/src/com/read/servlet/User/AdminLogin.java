package com.read.servlet.User;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.read.service.Impl.UserLoginImpl;
import com.read.service.UserLogin;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("GetImg/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BufferedReader br=req.getReader();
        String json=br.readLine();
//        System.out.println(json);
        br.close();
        JSONObject object=JSONObject.parseObject(json);
        String username=object.getString("username");
        String password=object.getString("password");
//        System.out.println(username);
//        System.out.println(password);
        //实例化PrintWriter对象，为之后输出数据做准备
        PrintWriter out=resp.getWriter();
        if(username==null||username.equals("")||password==null||password.equals(""))
        {
            JSONObject jsonObject=new JSONObject();

            try {
                jsonObject.put("message","用户名和密码不为空");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            out.print(jsonObject);
            out.flush();
            out.close();
            return;
        }

//        System.out.println(username);
        //实例化接口对象
        UserLogin userLogin = new UserLoginImpl();
        //实例化JSON对象，储存要发送的数据
        JSONObject jsonObject=new JSONObject();
//        boolean Check = userLogin.Login(username, password);
        if (!userLogin.AdminLogin(username,password)) {
            try {
                jsonObject.put("username",username);
                jsonObject.put("message","账号密码错误");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else {
//            ServletContext application = this.getServletContext();
            //建立服务器的session对象并获取游览器的sessionID
//            HttpSession session = req.getSession();
//            String sessionID = session.getId();
//            System.out.println(sessionID);
            //获取服务器的已用户登录信息
//            Map<String, String> loginUserMap= (Map<String, String>) application.getAttribute("DL");
            //不存在则新建
//            if (loginUserMap == null) {
//                loginUserMap = new HashMap<String, String>();
//            }
//            int controll=0;//指示是否有相已登录用户
//            System.out.println(loginUserMap);
//            //如果此用户名在已登录的用户名中中
//            for (String userna : loginUserMap.keySet()) {
//                System.out.println(userna);
//                //当此用户名等于里面的用户名时
//                if (userna.equals(username)) {
//                    //判断服务器中存储的SessionID与用户游览器的是否相等
//                    if (loginUserMap.containsValue(sessionID)) {
//                        controll++;
//                        //相等则输出用户已登录
//                        try {
//                            jsonObject.put("message","用户已登录");
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        System.out.println("用户已登录");
//                    } else {
//                        //不相等则移除该账户已登录的信息
//                        System.out.println("该账号已在其他地区登录");
//                        controll++;
//                        try {
//                            jsonObject.put("message","该账号已在其他地区登录");
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        loginUserMap.remove(username);
//                    }
//                }
//            }
//            if(controll==0) {
//                //指示器为0，说明该账号并未登录
//                loginUserMap.put(username, sessionID);


                try {
                    jsonObject.put("username", username);
                    jsonObject.put("message", "登录成功");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
//            }
//            application.setAttribute("DL", loginUserMap);

        }
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
