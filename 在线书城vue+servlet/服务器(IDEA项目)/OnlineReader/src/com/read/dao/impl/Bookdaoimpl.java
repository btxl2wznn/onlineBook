package com.read.dao.impl;

import com.read.bean.Book;
import com.read.bean.Type;
import com.read.bean.User;
import com.read.dao.Bookdao;
import com.read.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Bookdaoimpl implements Bookdao {

    @Override
    public ArrayList<Book> queryAllBook() {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        ArrayList<Book> books =new ArrayList<Book>();
        // 准备数据库连接
        String sql="SELECT * FROM books;";
        try {
            ps=connection.prepareStatement(sql);

            re=ps.executeQuery();
            //如果查询到返回true
            while(re.next()) {
                Book book=new Book(re.getInt("bid"),re.getString("bname"),re.getString("bauthor"),
                        re.getString("bintroduction"),re.getString("btype"),re.getInt("readtimes"),
                        re.getInt("collectiontimes"),re.getString("bimg"));
                books.add(book);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }

        return books;
    }

    @Override
    public boolean addBook( String b_name, String b_author, String b_info, String b_type,  String b_imgsrc) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        Book b=new Book( b_name,  b_author,  b_info, b_type,  0,  0,  b_imgsrc);
        // 准备数据库连接
        String sql="insert into books(bname,bauthor,bintroduction,btype,bimg) "
                + "values('" + b.getB_name()+"','" + b.getB_author() + "','"+ b.getB_info()+
                "','" + b.getB_type()+ "','" + b.getB_imgsrc()+ "')";
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
    public boolean upBook(int b_id, String b_name, String b_author, String b_info, String b_type, String b_imgsrc) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="Update books set bname=?,bauthor=?,bintroduction=?,btype=?,bimg=? where bid=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1,b_name);
            ps.setString(2,b_author);
            ps.setString(3,b_info);
            ps.setString(4,b_type);
            ps.setString(5,b_imgsrc);
            ps.setInt(6,b_id);
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
    public boolean delBook(int b_id) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="delete from books where bid=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,b_id);
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
    public Book queryById(int b_id) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="SELECT * FROM books where bid=?;";
        try {

            ps=connection.prepareStatement(sql);
            ps.setInt(1, b_id);

            re=ps.executeQuery();
            //如果查询到返回true
            if (re.next()) {
                return new Book(re.getInt("bid"),re.getString("bname"),re.getString("bauthor"),
                        re.getString("bintroduction"),re.getString("btype"),re.getInt("readtimes"),
                        re.getInt("collectiontimes"),re.getString("bimg"));

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
    public int queryByName(String b_name) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="SELECT * FROM books where bname=?;";
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1, b_name);

            re=ps.executeQuery();
            //如果查询到返回true
            if (re.next()) {
                return re.getInt("bid");

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }return 0;
    }



    public ArrayList<Book> queryPageBook(int start,int num) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        ArrayList<Book> books =new ArrayList<Book>();
        // 准备数据库连接
        String sql="SELECT * FROM books limit ?,?;";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,start);
            ps.setInt(2,num);
            re=ps.executeQuery();
            //如果查询到返回true
            while(re.next()) {
                Book book=new Book(re.getInt("bid"),re.getString("bname"),re.getString("bauthor"),
                        re.getString("bintroduction"),re.getString("btype"),re.getInt("readtimes"),
                        re.getInt("collectiontimes"),re.getString("bimg"));
                books.add(book);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }

        return books;
    }

    public int pagesNum(int num) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="SELECT COUNT(*) as count FROM books";
        try {
            ps=connection.prepareStatement(sql);
            re=ps.executeQuery();
            //如果查询到返回true
            if(re.next()) {
                return re.getInt("count")/num+1;

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
    public int getThumbUp(int b_id) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="SELECT readtimes FROM books where bid=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,b_id);
            re=ps.executeQuery();
            //如果查询到返回true
            if(re.next()) {
                return re.getInt("readtimes");

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


    public void giveThumbUp(int b_id) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="update books set readtimes=readtimes+1 where bid = ?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,b_id);
            ps.execute();
            //如果查询到返回true

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }

    }
    public ArrayList<Book> queryBooks(String b_name) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        ArrayList<Book> books =new ArrayList<Book>();
        // 准备数据库连接
        String sql="SELECT * FROM books where bname like '%"+b_name+"%'or bauthor like '%"+b_name+"%' or btype like '%"+b_name+"%';";
        System.out.println(sql);
        try {
            ps=connection.prepareStatement(sql);

            re=ps.executeQuery();
            //如果查询到返回true
            while(re.next()) {
                Book book=new Book(re.getInt("bid"),re.getString("bname"),re.getString("bauthor"),
                        re.getString("bintroduction"),re.getString("btype"),re.getInt("readtimes"),
                        re.getInt("collectiontimes"),re.getString("bimg"));
                books.add(book);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }

        return books;
    }
    public ArrayList<Book> queryByType(String b_type) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        ArrayList<Book> books =new ArrayList<Book>();
        // 准备数据库连接
        String sql="SELECT * FROM books where btype=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1,b_type);
            re=ps.executeQuery();
            //如果查询到返回true
            while(re.next()) {
                Book book=new Book(re.getInt("bid"),re.getString("bname"),re.getString("bauthor"),
                        re.getString("bintroduction"),re.getString("btype"),re.getInt("readtimes"),
                        re.getInt("collectiontimes"),re.getString("bimg"));
                books.add(book);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }

        return books;
    }
    public ArrayList<Type> queryTypeNum() {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        ArrayList<Type> ts=new ArrayList<Type>();
        // 准备数据库连接
        String sql="SELECT btype,COUNT(*) as count FROM books group by btype;";
        try {
            ps=connection.prepareStatement(sql);
            re=ps.executeQuery();
            //如果查询到返回true
            while(re.next()) {
                Type t=new Type(re.getString("btype"),re.getInt("count"));
                ts.add(t);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }

        return ts;
    }
    public ArrayList<Book> queryPageByType(int start, int num,String type) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        ArrayList<Book> books =new ArrayList<Book>();
        // 准备数据库连接
        String sql="SELECT * FROM books where btype = ? limit ?,?;";
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1,type);
            ps.setInt(2,start);
            ps.setInt(3,num);
            re=ps.executeQuery();
            //如果查询到返回true
            while(re.next()) {
                Book book=new Book(re.getInt("bid"),re.getString("bname"),re.getString("bauthor"),
                        re.getString("bintroduction"),re.getString("btype"),re.getInt("readtimes"),
                        re.getInt("collectiontimes"),re.getString("bimg"));
                books.add(book);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }

        return books;
    }

    public int typePagesNum(int num, String type) {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        // 准备数据库连接
        String sql="SELECT COUNT(*) as count FROM books WHERE bid IN (SELECT bid FROM books where btype = ?)";
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1,type);
            re=ps.executeQuery();
            //如果查询到返回true
            if(re.next()) {
                return re.getInt("count")/num+1;

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
    public ArrayList<Book> queryHotBook() {
        DBUtil dbUtil=new DBUtil();
        Connection connection=dbUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet re = null;
        ArrayList<Book> books =new ArrayList<Book>();
        // 准备数据库连接
        String sql="SELECT * FROM books order  by readtimes desc;";
        try {
            ps=connection.prepareStatement(sql);

            re=ps.executeQuery();
            //如果查询到返回true
            int i=0;
            while(re.next()&&i<10) {
                Book book=new Book(re.getInt("bid"),re.getString("bname"),re.getString("bauthor"),
                        re.getString("bintroduction"),re.getString("btype"),re.getInt("readtimes"),
                        re.getInt("collectiontimes"),re.getString("bimg"));
                books.add(book);
                i++;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            dbUtil.closeConnection(connection, ps, re);

        }

        return books;
    }





}
