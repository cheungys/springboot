package com.zys.boot.user.service.impl;

import com.zys.boot.user.dao.RoleMapper;
import com.zys.boot.user.dao.UserMapper;
import com.zys.boot.user.entity.Role;
import com.zys.boot.user.entity.User;
import com.zys.boot.user.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;

    @Override
    public User addUser(User user) {
        int i = userMapper.insert(user);
        if (i > 0) {
            return user;
        }
        return null;
    }

    @Override
    public Role addRole(Role role) {

        if (roleMapper.saveRole(role) > 0) {
            return role;
        }

        return null;
    }

    @Override
    public User findByName(String name) {
        User user = new User();
        user.setUserName(name);
        List<User> userList = userMapper.selectByUser(user);
        return userList.get(0);
    }
}
