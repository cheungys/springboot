package com.zys.boot.user.dao;

import com.zys.boot.user.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper{

    List<Permission> getPermissionListByRoleId(@Param("roleId") String roleId);

}
