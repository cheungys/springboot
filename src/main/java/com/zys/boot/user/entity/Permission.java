package com.zys.boot.user.entity;

import lombok.Data;

/**
 * 权限类
 */
@Data
public class Permission{
    private String id;
    private String permissionName;
    private String roleId;
    private Role role;

    public Permission(String id, String permissionName, Role role) {
        this.id = id;
        this.permissionName = permissionName;
        this.role = role;
    }

    public Permission() {
    }
}
