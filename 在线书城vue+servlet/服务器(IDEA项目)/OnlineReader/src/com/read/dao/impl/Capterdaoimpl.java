package com.read.dao.impl;

import com.read.bean.Capter;
import com.read.dao.Capterdao;
import com.read.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Capterdaoimpl implements Capterdao {
    @Override
    public ArrayList<Capter> queryByName(String b_name) {
        int id=new Bookdaoimpl().queryByName(b_name);
        System.out.println(id);
        ArrayList<Capter>cs=new ArrayList<Capter>();
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="SELECT * FROM bookscontent where bid=?;";
        try {

            ps=connection.prepareStatement(sql);
            ps.setInt(1, id);

            re=ps.executeQuery();
            //如果查询到返回true
            while (re.next()) {
                Capter c= new Capter(re.getInt("cid"),re.getInt("bid"),re.getString("cname"),re.getString("ctext"),re.getInt("chapter_num"));
                cs.add(c);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);


        }
        return cs;
    }

    @Override
    public String queryByCid(int c_id) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="SELECT * FROM bookscontent where cid=?;";
        try {

            ps=connection.prepareStatement(sql);
            ps.setInt(1, c_id);

            re=ps.executeQuery();
            //如果查询到返回true
            if (re.next()) {
                return re.getString("ctext");

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);


        }return null;
    }

    @Override
    public boolean upCapter(int c_id, String c_name, String C_text) {
        if(C_text==""){C_text=new Capterdaoimpl().queryByCid(c_id);}
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="Update bookscontent set cname=?,ctext=? where cid=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1,c_name);
            ps.setString(2,C_text);
            ps.setInt(3,c_id);
            ps.execute();
            //如果查询到返回true
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }

        return true;
    }

    @Override
    public boolean addCapter(String b_name, int c_num, String c_name, String c_text) {
        int bid=new Bookdaoimpl().queryByName(b_name);
        if(bid==0) return false;
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        Capter b=new Capter( bid,c_name,c_text);
        // 准备数据库连接
        String sql="insert into bookscontent(bname,cname,ctext,bid,chapter_num) "
                + "values('" + b_name+"','" + b.getC_name() + "','"+ b.getC_text()+
                "','" + bid+ "','" + c_num+ "')";
        try {
            ps=connection.prepareStatement(sql);
            if(ps.executeUpdate()>0)
            {
                return  true;
            }
                //如果查询到返回true
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }

        return false;
    }

    @Override
    public boolean delCapter(int c_id) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="delete from bookscontent where cid=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,c_id);
            ps.execute();
            //如果查询到返回true
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }

        return true;
    }
    public ArrayList<Capter> query(String name,int b_id) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        ArrayList<Capter> cs =new ArrayList<Capter>();
        // 准备数据库连接
        String sql="SELECT * FROM bookscontent where cname like '%"+name+"%'and bid="+b_id+";";
        try {
            ps=connection.prepareStatement(sql);

            re=ps.executeQuery();
            //如果查询到返回true
            while(re.next()) {
                Capter c= new Capter(re.getInt("cid"),re.getInt("bid"),re.getString("cname"),re.getString("ctext"),re.getInt("chapter_num"));
                cs.add(c);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }

        return cs;
    }

    @Override
    public Capter queryBycid(int c_id) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="SELECT * FROM bookscontent where cid=?;";
        try {

            ps=connection.prepareStatement(sql);
            ps.setInt(1, c_id);

            re=ps.executeQuery();
            //如果查询到返回true
            if (re.next()) {
               return new Capter(re.getInt("cid"),re.getInt("bid"),re.getString("cname"),re.getString("ctext"),re.getInt("chapter_num"));


            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);


        }return null;
    }
    public ArrayList<Capter> queryByName(int id) {

        ArrayList<Capter>cs=new ArrayList<Capter>();
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="SELECT * FROM bookscontent where bid=?;";
        try {

            ps=connection.prepareStatement(sql);
            ps.setInt(1, id);

            re=ps.executeQuery();
            //如果查询到返回true
            while (re.next()) {
                Capter c= new Capter(re.getInt("cid"),re.getInt("bid"),re.getString("cname"),re.getString("ctext"),re.getInt("chapter_num"));
                cs.add(c);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);


        }
        return cs;
    }
    public Capter queryByNum(int b_id,int c_num) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        ArrayList<Capter> cs =new ArrayList<Capter>();
        // 准备数据库连接
        String sql="SELECT * FROM bookscontent where chapter_num=? and bid=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,c_num);
            ps.setInt(2,b_id);
            re=ps.executeQuery();
            //如果查询到返回true
            while(re.next()) {
                return new Capter(re.getInt("cid"),re.getInt("bid"),re.getString("cname"),re.getString("ctext"),re.getInt("chapter_num"));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }

        return null;
    }
}
