package com.hzp.Dao;

import com.hzp.Pojo.User;

import java.util.List;

public interface UserDao {
    List<User> findByName(String name);
}
