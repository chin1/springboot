package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by wb.chenshuren on 2018/12/27.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private UserService userService;

    @RequestMapping("/redisSetValue")
    public String redisSetValue(){
        if(!stringRedisTemplate.hasKey("abc")){
            stringRedisTemplate.opsForValue().append("abc","testvalue");
            return "使用redis缓存保存数据成功";
        }else{
            stringRedisTemplate.delete("abc");
            return "key已存在";
        }
    }

    @RequestMapping("/redisGetValue")
    public String redsiGetValue(){
        if(!stringRedisTemplate.hasKey("abc")){
            return "key不存在，请先保存数据";
        }else{
            String test = stringRedisTemplate.opsForValue().get("abc");
            return "获取到缓存中的数据：abc"+test;
        }
    }

    @RequestMapping("/cacheGet")
    public User cacheGet(){
        User user = userService.getUser("xianggu");
        return user;
    }

    @RequestMapping("/cachePut")
    public User cachePut(){
        User user = userService.getUserput("xianggu");
        return user;
    }
    @RequestMapping("/cacheDelete")
    public String cacheDelete(){
        userService.deleteUser("xianggu");
        return "执行了删除";
    }

}
