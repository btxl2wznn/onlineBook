package com.read.bean;

public class Book {
    private int b_id;
    private String b_name;
    private String b_author;      //作者
    private  String b_info;     //书籍简介
    private String b_type;      //书籍种类
    private  int  b_times;     //浏览量
    private int b_coleclion;   //收藏数
    private  String b_imgsrc ;//图片路径

    public Book(int b_id, String b_name, String b_author, String b_info, String b_type, int b_times, int b_coleclion, String b_imgsrc) {
        this.b_id = b_id;
        this.b_name = b_name;
        this.b_author = b_author;
        this.b_info = b_info;
        this.b_type = b_type;
        this.b_times = b_times;
        this.b_coleclion = b_coleclion;
        this.b_imgsrc = b_imgsrc;
    }
    public Book( String b_name, String b_author, String b_info, String b_type, int b_times, int b_coleclion, String b_imgsrc) {
        this.b_name = b_name;
        this.b_author = b_author;
        this.b_info = b_info;
        this.b_type = b_type;
        this.b_times = b_times;
        this.b_coleclion = b_coleclion;
        this.b_imgsrc = b_imgsrc;
    }


    @Override
    public String toString() {
        return "Book{" +
                "b_id=" + b_id +
                ", b_name='" + b_name + '\'' +
                ", b_author='" + b_author + '\'' +
                ", b_info='" + b_info + '\'' +
                ", b_type='" + b_type + '\'' +
                ", b_times=" + b_times +
                ", b_coleclion=" + b_coleclion +
                ", b_imgsrc='" + b_imgsrc + '\'' +
                '}';
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getB_author() {
        return b_author;
    }

    public void setB_author(String b_author) {
        this.b_author = b_author;
    }

    public String getB_info() {
        return b_info;
    }

    public void setB_info(String b_info) {
        this.b_info = b_info;
    }

    public String getB_type() {
        return b_type;
    }

    public void setB_type(String b_type) {
        this.b_type = b_type;
    }

    public int getB_times() {
        return b_times;
    }

    public void setB_times(int b_times) {
        this.b_times = b_times;
    }

    public int getB_coleclion() {
        return b_coleclion;
    }

    public void setB_coleclion(int b_coleclion) {
        this.b_coleclion = b_coleclion;
    }

    public String getB_imgsrc() {
        return b_imgsrc;
    }

    public void setB_imgsrc(String b_imgsrc) {
        this.b_imgsrc = b_imgsrc;
    }
}
