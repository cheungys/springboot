package com.zys.boot.user.dao;

import com.zys.boot.user.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper{
   int  saveRole (Role role);

   List<Role> getRoleListByUserId(@Param("userId") String userId);
}
