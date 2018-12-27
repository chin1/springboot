package com.example.service.imp;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by wb.chenshuren on 2018/12/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(String id) {
        System.out.println(id+"进入实现类获取数据！");
        User user = new User();
        user.setId(id);
        user.setName("香菇");
        user.setAge(18);
        return user;
    }

    @Override
    public User getUserput(String id) {
        System.out.println(id+"进入实现类获取数据！");
        User user = new User();
        user.setId(id);
        user.setName("香菇");
        user.setAge(20);
        return user;
    }

    @Override
    public void deleteUser(String id) {
        System.out.println(id+"进入实现类删除数据！");
    }
}
