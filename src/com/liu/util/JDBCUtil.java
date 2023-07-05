package com.liu.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    //创建properties集合储存db中的数据
    private static Properties ps = new Properties();
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    //利用静态代码块 取得其中的数据  io流
    static{
        InputStream is = JDBCUtil.class.getResourceAsStream("/com/liu/conf/db.properties");
        try {
            ps.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            is.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    //获得链接
    public static Connection getConnection(){
        //创建链接
        try{
            String driver = ps.getProperty("driver");
            String url = ps.getProperty("url");
            String username = ps.getProperty("username");
            String password = ps.getProperty("password");
            Connection conn = tl.get();

            if(conn==null){
                try {
                    //注册驱动
                    Class.forName(driver);
                    conn = DriverManager.getConnection(url,username,password);
                    tl.set(conn);
                } catch (Exception e) {
                    throw new RuntimeException("创建链接失败");
                }
            }

            return conn;
        }catch(Exception e){
            throw  new RuntimeException("返回失败");
        }
    }
    //释放资源
    public static void Close(ResultSet rs, PreparedStatement ps, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(conn!=null){
            try {
                conn.close();
                tl.remove();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
