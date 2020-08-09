package com.zys.boot.user.controller;

import com.zys.boot.user.entity.Role;
import com.zys.boot.user.entity.User;
import com.zys.boot.user.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Controller
@RequestMapping("/test")
@Api(description = "测试接口文档")
public class TestController {
    @Resource
    private LoginService loginService;

    /**
     * POST登录
     * @param
     * @return
     */
    @ApiOperation(value = "用户登陆", notes = "凭用户名、密码登陆")
    @PostMapping(value = "/login")
    public String login(@RequestBody User user) {
        // 添加用户认证信息
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        // 进行验证，这里可以捕获异常，然后返回对应信息
        SecurityUtils.getSubject().login(usernamePasswordToken);
        return "index";
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @ApiOperation(value = "添加用户", notes = "凭用户名、密码登陆")
    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody User user) {
        user = loginService.addUser(user);
        return "addUser is ok! \n" + user;
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @ApiOperation(value = "添加角色", notes = "凭用户名、密码登陆")
    @PostMapping(value = "/addRole")
    public String addRole(@RequestBody Role role) {
        role = loginService.addRole(role);
        return "addRole is ok! \n" + role;
    }

    /**
     * 注解的使用
     * @return
     */
    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @GetMapping(value = "/create")
    @ResponseBody
    public String create() {
        return "Create success!";
    }

    @GetMapping(value = "/index")
    public String index() {
        return "index page!";
    }

    @GetMapping(value = "/error")
    public String error() {
        return "error page!";
    }

    /**
     * 退出的时候是get请求，主要是用于退出
     * @return
     */
    @GetMapping(value = "/login1")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logout() {
        return "logout";
    }
}
