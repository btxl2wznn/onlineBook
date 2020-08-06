package com.read.servlet.Filter;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GetFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("开始拦截");
        servletResponse.setContentType("application/json");
        servletResponse.setContentType("GetImg/json;charset=UTF-8");

        BufferedReader br=servletRequest.getReader();
        String json=br.readLine();
        System.out.println(json);
        br.close();
//        BufferedReader br = new BufferedReader(new InputStreamReader(
//                (ServletInputStream) servletRequest.getInputStream(), "utf-8"));
//        StringBuffer sb = new StringBuffer("");
//        String temp;
//        while ((temp = br.readLine()) != null) {
//            sb.append(temp);
//        }
//        br.close();
//        System.out.println(sb.toString());
        JSONObject object=JSONObject.parseObject(json);
        System.out.println(object);
        System.out.println(object.size());
        String username=object.getString("username");
        String password=object.getString("password");
        System.out.println(username);
        System.out.println(password);
        if(username!=null&&!username.equals("")&&password!=null&&!password.equals(""))
        {

            filterChain.doFilter(servletRequest,servletResponse);
        }
        else {
            JSONObject jsonObject=new JSONObject();
            PrintWriter out=servletResponse.getWriter();
            try {
                jsonObject.put("message","用户名和密码不为空");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            out.print(jsonObject);
            out.flush();
            out.close();

        }
    }

    @Override
    public void destroy() {

    }
}
