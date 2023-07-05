package com.liu.test;

import com.liu.dao.UserDao;
import com.liu.dao.UserDaoImpl;
import com.liu.entity.User;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserDaoImplTest {
    @Test
    public void queryByUsernameTest(){
        UserDao ud = new UserDaoImpl();
        User u = new User();
        u.setUser_id(1);
        u.setUser_name("admin");
        u.setUser_pwd("123456");
        User user = ud.queryByUserName(u);
        System.out.println(user);
    }

    @Test
    public void insert(){
        UserDao ud = new UserDaoImpl();
        User u = new User();
        u.setUser_id(1);
        u.setUser_name("刘津潮");
        u.setUser_pwd("123456");
        u.setUser_email("121245123@qq.com");
        ud.insert(u);
    }

    @Test
    public void queryAllTest(){
        UserDao ud = new UserDaoImpl();
        System.out.println(ud.queryAll());
    }

    @Test
    public void deleteById(){
        UserDao ud = new UserDaoImpl();
        ud.deleteById(36);
    }

    @Test
    public void queryByIdTest(){
        UserDao ud = new UserDaoImpl();
        User user = ud.queryById(1);
        System.out.println(user);
    }

    @Test
    public void queryByName(){
        UserDao ud = new UserDaoImpl();
        List<User> admin = ud.queryByUserName("1");
        System.out.println(admin);
    }


    @Test
    public void queryByLinmtTest(){
        UserDao ud = new UserDaoImpl();
        List<User> users = ud.queryAll(1, 3);
        System.out.println(users);
    }
}