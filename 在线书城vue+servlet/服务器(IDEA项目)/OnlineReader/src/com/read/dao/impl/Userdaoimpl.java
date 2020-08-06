package com.read.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.read.bean.Book;
import com.read.bean.User;
import com.read.dao.Userdao;
import com.read.util.DBUtil;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Userdaoimpl implements Userdao {

    @Override
    public boolean login(String name, String pass) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="SELECT * FROM users where uname=? and upwd=?;";
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);

            re=ps.executeQuery();
            //如果查询到返回true
            if (re.next()) {
                return true;

            }
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
    public boolean adminlogin(String name, String pass) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="SELECT * FROM users where uname=? and upwd=? and role='管理员';";
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);

            re=ps.executeQuery();
            //如果查询到返回true
            if (re.next()) {
                return true;

            }
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
    public ArrayList<User> queryAllUser() {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        ArrayList<User> us =new ArrayList<User>();
        // 准备数据库连接
        String sql="SELECT * FROM users;";
        try {
            ps=connection.prepareStatement(sql);

            re=ps.executeQuery();
            //如果查询到返回true
            while(re.next()) {
                User u=new User(re.getInt("uid") , re.getString("upwd"),
                        re.getString("uname") , re.getString("unick"),re.getString("role"));
                us.add(u);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }

        return us;
    }

    @Override
    public boolean addUser(String user_pwd, String user_name, String user_nick) {

        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        User user=new User( user_pwd, user_name, user_nick,"普通用户");
        // 准备数据库连接
        String sql="insert into users(upwd,uname,role,uregistTime,unick) "
                + "values('"  + user.getUser_pwd() + "','"+ user.getUser_name()+
                "','" +"普通用户"+"','"+ user.getUer_retime()+ "','" + user.getUser_nick()+ "')";
        try {
            if(new Userdaoimpl().queryByName(user_name)!=null) return false;
            ps=connection.prepareStatement(sql);

            if(ps.executeUpdate(sql)>0)
                return  true;
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
    public boolean addAdminUser( String user_pwd, String user_name, String user_nick) {

        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        User user=new User( user_pwd, user_name, user_nick,"管理员");
        // 准备数据库连接
        String sql="insert into users(upwd,uname,role,uregistTime,unick) "
                + "values('" +   user.getUser_pwd() + "','"+ user.getUser_name()+
                "','" +"管理员"+"','"+ user.getUer_retime()+ "','" + user.getUser_nick()+ "')";
        try {
            if(new Userdaoimpl().queryByName(user_name)!=null) return false;
            ps=connection.prepareStatement(sql);

            if(ps.executeUpdate(sql)>0)
                return  true;
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
    public boolean delUser(int user_id) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="delete from users where uid=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,user_id);
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
    public boolean upUser( int user_id,String user_pwd, String user_name,String user_nick) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="Update users set uname=?,upwd=?,unick=? where uid=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1,user_name);
            ps.setString(2,user_pwd);
            ps.setString(3,user_nick);
            ps.setInt(4,user_id);
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
    public User queryByName(String name) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="SELECT * FROM users where uname=? ;";
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1, name);

            re=ps.executeQuery();
            //如果查询到返回true
            if (re.next()) {
                return new User(re.getInt("uid") , re.getString("upwd"),
                        re.getString("uname") , re.getString("unick"),re.getString("role"));

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

    public ArrayList<User> queryAllUser(String user_type) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        ArrayList<User> us =new ArrayList<User>();
        // 准备数据库连接
        String sql="SELECT * FROM users where role=?;";
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1,user_type);
            re=ps.executeQuery();
            //如果查询到返回true
            while(re.next()) {
                User u=new User(re.getInt("uid") , re.getString("upwd"),
                        re.getString("uname") , re.getString("unick"),re.getString("role"));
                us.add(u);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }

        return us;
    }
    public ArrayList<Book> getUserShelf(int user_id) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        ArrayList<Book> bs =new ArrayList<Book>();
        // 准备数据库连接
        String sql="SELECT * FROM shelf where uid=?;";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,user_id);
            re=ps.executeQuery();
            //如果查询到返回true
            while(re.next()) {
                Book book=new Bookdaoimpl().queryById(re.getInt("bid"));
                bs.add(book);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }

        return bs;
    }


    public boolean addShelf(int user_id, int b_id) {
        DBUtil dbUtil=new DBUtil();
        Connection conn= dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re=null;
        String sql="insert into shelf(uid,bid) "
                + "values('"  + user_id + "','"+ b_id+ "')";
        try {
            ps=conn.prepareStatement(sql);
            if(ps.executeUpdate(sql)>0)
                return  true;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtil.closeConnection(conn, ps, re);
        }
        return false;
    }

    public int getUserId(String u_name) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;

        // 准备数据库连接
        String sql="SELECT uid FROM users where uname=?;";
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1,u_name);
            re=ps.executeQuery();
            //如果查询到返回true
            while(re.next()) {
                return re.getInt("uid");

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }

        return 0;
    }
    public boolean delShelf(int u_id, int b_id) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="delete from shelf where uid=? and bid =?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,u_id);
            ps.setInt(2,b_id);
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


}
