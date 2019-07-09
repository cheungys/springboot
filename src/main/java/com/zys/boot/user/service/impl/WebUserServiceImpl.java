package com.zys.boot.user.service.impl;

import com.zys.boot.user.dao.UserMapper;
import com.zys.boot.user.entity.User;
import com.zys.boot.user.model.UserInVo;
import com.zys.boot.user.service.WebUserService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;


@Repository
@WebService
public class WebUserServiceImpl implements WebUserService {
    @Resource
    private UserMapper userMapper;

    @WebMethod
    @Override
    public List<User> seleteByInfo(UserInVo userInVo) {
        System.out.println("进入服务");
        User user = new User();
        if (userInVo.getEmail() != null && !userInVo.getEmail().equals("")) {
            user.setEmail(userInVo.getEmail());
        }
        if (userInVo.getName() != null && !userInVo.getName().equals("")) {
            user.setUserName(userInVo.getName());
        }
        System.out.println(user.toString());
        List<User> userList = userMapper.selectByUser(user);

            return userList;


    }

    public static void main(String[] args) {
        WebUserServiceImpl webUserService = new WebUserServiceImpl();
        UserInVo userInVo = new UserInVo();
        userInVo.setEmail("15626183846@163.com");
        userInVo.setName("zys");
        List<User> userList = webUserService.seleteByInfo(userInVo);

        if (userList != null && userList.size() != 0) {
            System.out.println(userList.toString());
        }
    }
}
