package com.zys.boot.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zys.boot.base.dao.DictMapper;
import com.zys.boot.base.entity.Dict;
import com.zys.boot.base.exception.CommonException;
import com.zys.boot.base.utils.EncryptUtil;
import com.zys.boot.base.utils.StringUtil;
import com.zys.boot.user.dao.UserMapper;
import com.zys.boot.user.entity.User;
import com.zys.boot.user.model.DLink;
import com.zys.boot.user.model.LoginInVo;
import com.zys.boot.user.model.UserModel;
import com.zys.boot.user.service.UserService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Repository
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private DictMapper dictMapper;

    @Override
    public User login(LoginInVo loginInVo) {
        //验证用户名是否为空
        User user = new User();
        if (StringUtil.isNotEmpty(loginInVo)){
            if (StringUtil.isNotEmpty(loginInVo.getUserName()) && StringUtil.isNotEmpty(loginInVo.getPassword())){
                user.setUserName(loginInVo.getUserName());
                user.setPassword(loginInVo.getPassword());
            }
            if (StringUtil.isNotEmpty(loginInVo.getPhone()) && StringUtil.isNotEmpty(loginInVo.getvCode())){
                user.setPhone(loginInVo.getPhone());
                user.setVCode(loginInVo.getvCode());
            }
        }
        List<User> userList = userMapper.selectByUser(user);
        if (!userList.isEmpty()){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public List<User> seleteByInfo(User user) {
        List<User> userList = userMapper.selectByUser(user);
        if (userList != null) {
            return userList;
        }
        return null;
    }

    @Override
    public boolean updatePassword(LoginInVo loginInVo) {
        loginInVo.setNewPassword(EncryptUtil.Base64Encode(loginInVo.getNewPassword()));
        loginInVo.setModifyTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        int i = userMapper.updateByUserName(loginInVo);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean registerUser(UserModel userModel) {
        User user = new User();
        user.setUserName(userModel.getUserName());
        List<User> userList = userMapper.selectByUser(user);
        if (userList != null && userList.size() != 0) {
            throw new CommonException("该用户已存在");
        } else {
            user.setUserName(userModel.getUserName());
            user.setPhone(userModel.getPhone());
            user.setEmail(userModel.getEmail());
            user.setPassword(EncryptUtil.Base64Encode(userModel.getPassword()));
            user.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            int i = userMapper.insertSelective(user);
            if (i > 0) {
                return true;
            }
            return false;
        }
    }

    /**
     * 注销用户
     *
     * @param userModel
     * @return
     */
    @Override
    public boolean deleteUser(UserModel userModel) {
        int i = userMapper.deleteByUserName(userModel.getEmail());
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @Override
    public User modifyUser(User user) {
        //更新操作
        user.setModifyTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        int i = userMapper.updateByUser(user);
        if (i > 0) {
            System.out.println("修改成功");
            List<User> userList = userMapper.selectByUser(user);
            if (userList != null && userList.size() != 0) {
                for (User user1 : userList) {
                    Dict dict = dictMapper.selectByKeyAndBelid(user1.getCardType(), 4);
                    if (dict != null) {
                        String cardNumber = dict.getDictValue();
                        user1.setCardType(cardNumber);
                    }
                    return user1;
                }
            }
        }
        System.out.println("修改失败");
        return null;
    }

    /**
     * 通过链接确认销户
     *
     * @param user
     * @return
     */
    @Override
    public boolean confirmInfo(User user) {
        List<User> userList = userMapper.selectByUser(user);
        if (userList != null && userList.size() != 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public String receiveDLinkData(String param) {
        System.out.println("传输数据========" + param);

        JSONObject jsonObject = JSON.parseObject(param);
        System.out.println("解析之后的对象=====" + jsonObject.toString());
        List<DLink> dLinks = JSON.parseArray(jsonObject.getString("dLinkList"),DLink.class);
        System.out.println(dLinks.toString());
        return null;
    }
}