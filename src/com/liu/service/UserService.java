package com.liu.service;

import com.liu.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    //登录方法  判断role是否为1
    public String login(User u);

    //注册方法
    public String regUser(User u);

    //查询所有方法 展示用户信息
    public List<User> queryAll();
    //分页查询
    public Map<String,Object> queryAll(int a, int b);
    //根据id删除 用于删除用户
    public String deleteById(int id);

    //根据id查询 用于查看用户信息
    public User queryById(int id);

    //根据名字差一个  与第一个同方法  用于查询一个
    //区别：不需要比较验证码
    public List<User> queryByUsername(String str);
}
