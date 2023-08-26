package com.hzp.Dao;

import com.hzp.Pojo.User;
import com.hzp.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ASUS
 * @projectName JSON_class
 * @description:
 * @date 2021-12-10 10:33
 */
public class UserDaoImp implements UserDao{
    public Connection conn=null;
    public PreparedStatement ps=null;
    public  ResultSet rs=null;
    @Override
    public List<User> findByName(String name) {
        conn=DBUtil.getConn();
        String sql="SELECT * FROM `friend_user` WHERE `username` LIKE ?;";
        try {
            ps= conn.prepareStatement(sql);
            ps.setString(1,"%"+name+"%");
            rs= ps.executeQuery();
            List<User> list=new ArrayList<>();
            while(rs.next()){
                User u=new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setName(rs.getString("name"));
                u.setAge(rs.getInt("age"));
                u.setGender(rs.getString("gender"));
                u.setPhone(rs.getString("phone"));
                list.add(u);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
