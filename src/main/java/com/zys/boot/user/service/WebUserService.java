package com.zys.boot.user.service;

import com.zys.boot.user.entity.User;
import com.zys.boot.user.model.UserInVo;

import java.util.List;

public interface WebUserService {

    List<User> seleteByInfo(UserInVo userInVo);

}
