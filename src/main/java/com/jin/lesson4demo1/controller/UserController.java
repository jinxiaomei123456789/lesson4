package com.jin.lesson4demo1.controller;


import com.jin.lesson4demo1.mapper.UserMapper;
import com.jin.lesson4demo1.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    //查询所有用户
    @RequestMapping(value = "/userList")
    public List<User> userList(){
        return userMapper.findAll();
    }
    //根据id查询用户
    @RequestMapping(value = "/findone/{id}")
    public User findOne(@PathVariable("id") Integer id){
        return userMapper.findOne(id);
    }

    //更新用户
    @RequestMapping(value = "/userUpdate/{id}")
    public User  findOne(@PathVariable("id") Integer id, @RequestParam("username") String username,@RequestParam("password") String password){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);

        return userMapper.save(user);
    }
    //插入一个用户
    @RequestMapping("/userInsert")
    public User userInsert(@RequestParam("username") String username,@RequestParam("password") String password){
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        return  userMapper.save(user);
    }


    //删除一个用户
    @RequestMapping("/userDelete/{id}")
    public void userDelete(@PathVariable("id") Integer id){
        userMapper.delete(id);
    }


}
