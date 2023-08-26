package com.hzp.Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

/**
 * @author ASUS
 * @projectName javaweb_test
 * @description: JDBC_Hieght
 * @date 2021-10-16 19:23
 */
public class DBUtil {
    public static String Driver_Name=null;
    public static String URL=null;
    public static String User_name=null;
    public static String Password=null;
    public static Connection conn=null;
    public static Statement st=null;
    public static ResultSet rs=null;

    static {
        Properties properties=new Properties();
        try {
            properties.load(new InputStreamReader(new FileInputStream("D://Java//IDEA_Practice//JSON_class//src//com//hzp//Util//db.properties")));
            Driver_Name=properties.getProperty("driver");
            URL=properties.getProperty("url");
            User_name=properties.getProperty("username");
            Password=properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn()
    {
        try {
            Class.forName(Driver_Name);
            conn=DriverManager.getConnection(URL,User_name,Password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void  close(Connection conn,Statement st,ResultSet rs)
    {
        try {
            if(rs!=null)
            {
                rs.close();
            }
            if(st!=null)
            {
                st.close();
            }
            if(conn!=null)
            {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
