package com.zys.boot.user.service;

import com.zys.boot.user.entity.Role;
import com.zys.boot.user.entity.User;

public interface LoginService {
    User addUser(User user);

    Role addRole(Role role);

    User findByName(String name);
}
