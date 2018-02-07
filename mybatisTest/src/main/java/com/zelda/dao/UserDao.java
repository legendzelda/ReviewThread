package com.zelda.dao;

import com.zelda.pojo.User;

public interface UserDao {
    /**
     * 新增一个user
     * @param user
     */
    public void insertUser(User user);

    /**
     * 根据name获取一个User对象
     * @param name
     * @return Uesr对象
     */
    public User getUser(String name);
}
