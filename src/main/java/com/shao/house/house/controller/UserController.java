package com.shao.house.house.controller;

import com.alibaba.fastjson.JSONObject;
import com.shao.house.house.model.House;
import com.shao.house.house.model.User;
import com.shao.house.house.service.UserService;
import jdk.nashorn.internal.scripts.JO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

@CrossOrigin//解决跨域问题！
@Controller
@ResponseBody

public class UserController {
    @Autowired
    public UserService userService;

    @RequestMapping(value = {"/emailLogin"})
    public JSONObject login(@RequestBody JSONObject data) {
        System.out.println(data);
        JSONObject Object = new JSONObject();
        System.out.println("email:" + data.getString("email"));
        User user = userService.selectByEmail(data.getString("email"));
//        System.out.println("user:"+user.toString());
        if (user == null) {
            List<Integer> list = new LinkedList<>();
            System.out.println("meiyou !");
            Object.put("state", 2);
        } else {
            if (user.getPassword().equals(data.getString("pass"))) {
                Object.put("state", 0);
                Object.put("user", user);
            } else {
                Object.put("state", 1);
            }
        }
//       System.out.println(user.toString());
        return Object;
    }

    @RequestMapping(value = {"/register"})
    public JSONObject insetuser(@RequestBody JSONObject data) {
        System.out.println(data);
        User user = new User();
        user.setAboutme(data.getString("aboutme"));
        user.setAvatar(data.getString("avatar"));
        user.setCreateTime(new Date());
        user.setEmail(data.getString("email"));
        user.setName(data.getString("name"));
        user.setPassword(data.getString("password"));
        user.setPhone(data.getString("phone"));
        user.setType(true);
        user.setEnable(true);
        long state = userService.insertSelective(user);
//        long state = 1;
        JSONObject object = new JSONObject();
        if (state == 1) {
            User getUser = userService.selectByEmail(data.getString("email"));
//            User getUser=userService.selectByEmail("11");
            object.put("user", getUser);
            System.out.println("state:" + state + " user: " + getUser);
        }
        object.put("state", state);
        return object;
    }

    @RequestMapping(value = {"/edit"})
    public JSONObject upUser(@RequestBody JSONObject data) {
        System.out.println(data);
        User user = new User();
        user.setAboutme(data.getString("aboutme"));
        user.setId(data.getLong("id"));
        user.setAvatar(data.getString("avatar"));
        user.setPhone(data.getString("phone"));
        long state = userService.updateByPrimaryKeySelective(user);
//        long state = 1;
        JSONObject object = new JSONObject();
        if (state == 1) {
            User getUser = userService.selectByEmail(data.getString("email"));
//            User getUser=userService.selectByEmail("11");
            object.put("user", getUser);
            System.out.println("state:" + state + " user: " + getUser);
        }
        object.put("state", state);
        return object;
    }

    @RequestMapping(value = {"/user/{id}"})
    public User getHouseBuId(@PathVariable int id) {
        // System.out.println(new House());
        System.out.println("id:" + id);
        User user = userService.selectByPrimaryKey((long) id);
//       System.out.println(user.toString());
        return user;
    }

    @RequestMapping(value = {"/hello"})
    public String index(Object object) {
        Logger log = Logger.getLogger("hello ");
        log.info("kkkkk");
        System.out.println("hello world");
        System.out.println(object);
        return "Hello World";
    }

}

