package com.zys.boot.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zys
 * 系统名称:
 * 模块名称: 用户模块
 * 类 名 称: LoginController
 * 类 定 义: 登录控制器
 * 开发时间: 2019/05/14  10:57
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }
}
