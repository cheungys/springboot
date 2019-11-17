package com.zys.boot.user.service;

import com.zys.boot.user.entity.User;
import com.zys.boot.user.model.LoginInVo;
import com.zys.boot.user.model.UserModel;

import java.util.List;

public interface UserService {
    //登陆
    User login(LoginInVo loginInVo);

    //查找用户信息
    List<User> seleteByInfo(User user);


    //修改密码
    boolean updatePassword(LoginInVo loginInVo);

    //注册用户
    boolean registerUser(UserModel userModel);

    //注销用户
    boolean deleteUser(UserModel userModel);

    //修改用户信息
    User modifyUser(User user);

    //链接确认销户
    boolean confirmInfo(User user);

    //查找所有用户
    List<User> findAll();

    String receiveDLinkData(String param);
}
