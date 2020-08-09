package com.zys.boot.user.entity;

import lombok.Data;

import java.util.List;
@Data
public class Role {
    private String id;
    private String roleName;
    private String userId;
    private User user;
    private List<Permission> permissions;

    public Role(String id, String roleName, User user, List<Permission> permissions) {
        this.id = id;
        this.roleName = roleName;
        this.user = user;
        this.permissions = permissions;
    }

    public Role() {
    }
}
