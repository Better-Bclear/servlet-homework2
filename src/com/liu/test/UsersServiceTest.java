package com.liu.test;

import com.liu.entity.User;
import com.liu.service.UserService;
import com.liu.service.UserServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class UsersServiceTest {
    @Test
    public void loginTest(){
        UserService us = new UserServiceImpl();
        User u = new User();
//        u.setUser_name("admin");
        u.setUser_name("刘津潮");
        u.setUser_pwd("12345");
        String login = us.login(u);
        System.out.println(login);
    }
    @Test
    public void regTest123(){
        UserService us = new UserServiceImpl();
        User u = new User();
        u.setUser_name("admin");
        u.setUser_pwd("123456");
        u.setUser_email("123456@qq.com");
        String s = us.regUser(u);
        System.out.println(s);
    }
    @Test
    public void queryAll(){
        UserService us = new UserServiceImpl();
        List<User> list = us.queryAll();
        System.out.println(list);
    }

    @Test
    public void deleteById(){
        UserService us = new UserServiceImpl();
        String s = us.deleteById(35);
        System.out.println(s);
    }

    @Test
    public void queryByIdTest(){
        UserService us = new UserServiceImpl();
        User user = us.queryById(1);
        System.out.println(user);
    }

    @Test
    public void queryByNameTest(){
        UserService us = new UserServiceImpl();
        List<User> admin = us.queryByUsername("admin");
        System.out.println(admin);
    }

    @Test
    public void queryByTets(){
        UserService us = new UserServiceImpl();
        Map<String, Object> map = us.queryAll(2, 10);
        System.out.println(map);
    }
}
