package com.zys.boot.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zys.boot.base.controller.BaseController;
import com.zys.boot.base.exception.CommonException;
import com.zys.boot.base.model.JsonResult;
import com.zys.boot.base.utils.StringUtil;
import com.zys.boot.email.service.SenderService;
import com.zys.boot.email.vo.EmailSend;
import com.zys.boot.user.entity.User;
import com.zys.boot.base.utils.ExcelUtil;
import com.zys.boot.user.model.CancelInVo;
import com.zys.boot.user.model.LoginInVo;
import com.zys.boot.user.model.UserModel;
import com.zys.boot.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author zys
 * 系统名称:
 * 模块名称: 用户模块
 * 类 名 称: MailSender
 * 类 定 义: 操作用户控制器
 * 开发时间: 2019/05/14  10:57
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

@RestController
@RequestMapping(value = "/users")
@Api(description = "用户接口文档")
public class UserController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private SenderService senderService;


    /**
     * 登录
     *
     * @param
     * @return
     * @throws Exception 请求报文示例：
     *                   {
     *                   "user": {
     *                   "userName": "kelisi",
     *                   "password": "123456"
     *                   }
     *                   }
     */
    @ApiOperation(value = "用户登陆", notes = "凭用户名、密码登陆")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult login(@RequestBody LoginInVo loginInVo) {
        try {
            if (StringUtil.isNotNull(loginInVo.getUserName()) && StringUtil.isNotNull(loginInVo.getPassword())) {
                //检验该用户是否存在
                User user = userService.login(loginInVo);
                //如果存在用户
                if (null != user) {
                    //校验登陆密码是否和该用户保存的密码一致
                    if (loginInVo.getPassword().equals(user.getPassword())) {
                        logger.info("登录成功了");
                        return renderSuccess("登录成功");
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return renderError("登录成功");
        }
        logger.info("登录失败");
        return renderError("登录失败");
    }

    /**
     * 修改密码
     *
     * @param loginInVo
     * @return
     */
    @ApiOperation(value = "修改用户密码", notes = "用户登录密码修改")
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public JsonResult updatePassword(@RequestBody LoginInVo loginInVo) {
        User user;
        boolean flag;
        if (StringUtil.isBlank(loginInVo.getNewPassword())) {
            throw new CommonException("新密码不能为空");
        } else {
            Integer i = 6;
            if (loginInVo.getNewPassword().trim().length() < i) {
                throw new CommonException("新密码长度不能小于6位数");
            } else {
                //根据用户名查询用户
                user = userService.login(loginInVo);
                if (StringUtil.isNotNull(user)) {
                    if (user.getPassword().equals(loginInVo.getPassword())) {
                        flag = userService.updatePassword(loginInVo);
                    } else {
                        throw new CommonException("原密码错误");
                    }
                    logger.info(String.valueOf(flag));
                    logger.info("修改成功");
                    return renderSuccess("修改密码成功");
                }
            }
        }
        return renderError("修改密码失败");
    }

    /**
     * 注册用户
     *
     * @param userModel
     * @return
     */
    @ApiOperation(value = "新增用户", notes = "用户注册")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public JsonResult register(UserModel userModel) {
        if (userModel != null) {
            checkParam(userModel);
        }
        try {
            userService.registerUser(userModel);
        } catch (Exception e) {
            return renderError(e.getMessage());
        }
        return renderSuccess("注册成功!");
    }

    /**
     * 校验请求参数
     *
     * @param userModel
     * @return
     */
    @RequestMapping("/checkParam")
    public Object checkParam(UserModel userModel) {
        int mixSize = 6;
        int maxSize = 20;
        if (StringUtil.isNull(userModel.getUserName())) {
            throw new CommonException("用户名不能为空");
        }
        if (StringUtil.isNull(userModel.getEmail())) {
            throw new CommonException("邮箱不能为空");
        }
        if (StringUtil.isNull(userModel.getPassword())) {
            throw new CommonException("密码不能为空");
        }
        if (userModel.getPassword().trim().length() < mixSize || userModel.getPassword().trim().length() > maxSize) {
            throw new CommonException("密码长度不能小于6位，大于20位");
        }
        return userModel;
    }

    /**
     * 注销用户
     *
     * @param userModel
     * @return
     */
    @ApiOperation(value = "注销用户", notes = "用户注销")
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public JsonResult deleteUser(@RequestBody UserModel userModel) {
        if (StringUtil.isNull(userModel.getUserName())) {
            throw new CommonException("用户名不能为空");
        }
        if (StringUtil.isNull(userModel.getEmail())) {
            throw new CommonException("邮箱不能为空");
        }
        User user = new User();
        user.setUserName(userModel.getUserName());
        List<User> userList = userService.seleteByInfo(user);

        if (userList != null && userList.size() == 1) {
            for (User user1 : userList) {
                if (user1.getEmail().equals(userModel.getEmail())) {
                    //随机验证码
                    String vCode = UUID.randomUUID().toString().substring(0, 6);
                    //收件箱
                    String toEmail = user1.getEmail();

                    String url = "http://192.168.31.28:8888/user/confirmDeleteInfo?email=" + toEmail + "&" + "vCode=" + vCode;
                    EmailSend emailSend = new EmailSend();
                    emailSend.setToUsers(toEmail);
                    emailSend.setTitle("注销用户确认！");
                    emailSend.setContent(url);
                    try {
                        senderService.sendEmail(emailSend);
                    } catch (Exception e) {
                        throw new CommonException(e.getMessage());
                    }
                    user1.setvCode(vCode);
                    userService.modifyUser(user1);
                    logger.info("收件箱为" + toEmail);
                    logger.info("验证码发送成功" + vCode);
                    return renderSuccess("请查收邮件链接确认是否注销!");
                }
            }
            return renderError("邮箱不匹配,销户失败");
        }
        return renderError("用户异常");
    }

    /**
     * 通过点击链接确认销户
     *
     * @param cancelInVo
     * @return
     */
    @RequestMapping("/confirmDeleteInfo")
    public JsonResult confirmDeleteInfo(CancelInVo cancelInVo) {
        User user = new User();
        if (StringUtil.isNotNull(cancelInVo.getEmail())) {
            user.setEmail(cancelInVo.getEmail());
        }
        if (StringUtil.isNotNull(cancelInVo.getvCode())) {
            user.setvCode(cancelInVo.getvCode());
        }
        boolean flag = userService.confirmInfo(user);
        if (flag) {
            UserModel userModel = new UserModel();
            userModel.setEmail(cancelInVo.getEmail());
            userService.deleteUser(userModel);
            return renderSuccess("注销用户成功");
        }
        return renderError("注销用户失败");
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "modifyUser", method = RequestMethod.PUT)
    public JsonResult modifyUserInfo(User user) {
        if (StringUtil.isNull(user.getUserName())) {
            throw new CommonException("用户名不能为空");
        }
        try {
            User us = userService.modifyUser(user);
            if (us != null) {
                return renderSuccess(us);
            }
        } catch (Exception e) {
            return renderError(e.getMessage());
        }
        return renderError("修改失败");
    }

    /**
     * 导出所有客户信息
     *
     * @param response
     * @return
     */
    @ApiOperation(value = "导出客户信息", notes = "请直接复制请求Url新建窗口进行请求")
    @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public JsonResult exportExcel(HttpServletResponse response) {
        List<User> userList = userService.findAll();
        List<User> users = new ArrayList<>();
        if (userList.size() != 0) {
            for (User u : userList) {
                if (StringUtil.isNotNull(u.getCardType())) {
                    String idCard = "01";
                    String hMCard = "02";
                    if (u.getCardType().equals(idCard)) {
                        u.setCardType("身份证");
                    } else if (u.getCardType().equals(hMCard)) {
                        u.setCardType("港澳通行证");
                    } else {
                        u.setCardType("");
                    }
                }

                users.add(u);
            }

            ExcelUtil.exportExcel(users, "花名册", "用户详情", User.class, "系统用户信息.xls", response);
            logger.info("导出成功!!!");
            return renderSuccess("导出成功");
        }
        return renderError("导出失败");
    }

    /**
     * 导入客户
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "导入客户信息")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public JsonResult importExcel(MultipartFile file) {
        if (file == null) {
            return null;
        }
        List<User> userList = ExcelUtil.importExcel(file, User.class);
        if (userList.size() != 0) {
            for (User user : userList) {
                System.out.println(user.toString());
            }
        }
        logger.info("Excel导入成功！！！");
        return renderSuccess("导入成功");
    }

    /**
     * @return
     */
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public List<User> getAllUser() {
//        ResponseVO responseVO = new ResponseVO();
////        List<User> userList = userService.findAll();
////        if (userList.size() > 0) {
////            responseVO.setCode(0);
////            responseVO.setCount(userList.size());
////            responseVO.setData(userList);
////            return responseVO;
////        }
////        responseVO.setMsg("获取所有用户信息失败");
////        return responseVO;
        List<User> userList = userService.findAll();
        System.out.println(userList.toString());
        return userList;
    }

}
