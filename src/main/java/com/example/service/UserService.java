package com.example.service;

import com.example.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by wb.chenshuren on 2018/12/27.
 */
//@CacheConfig(cacheNames="usersAll")
// 类级别的注解：如果我们在此注解中定义cacheNames，则此类中的所有方法上 @Cacheable的cacheNames默认都是此值。当然@Cacheable也可以重定义cacheNames的值
public interface UserService {

    //如果缓存没有值，从则执行方法并缓存数据，如果缓存有值，则从缓存中获取值
    @Cacheable(value = "users",key = "'user_'+#id")
    User getUser(String id);

    //每次执行都会执行方法，无论缓存里是否有值，同时使用新的返回值的替换缓存中的值
    @CachePut(value = "users",key = "'user_'+#id")
    User getUserput(String id);

    @CacheEvict(value="users", key="'user_'+#id",condition="#id!=1")
    void deleteUser(String id);
}
