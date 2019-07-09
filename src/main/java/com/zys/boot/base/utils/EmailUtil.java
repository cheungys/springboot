package com.zys.boot.base.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 系统名称: 智慧客服平台
 * 模块名称: 客户关系数据平台
 * 类 名 称: EmailUtil
 * 软件版权: 远传股份有限公司
 * 功能说明：为智慧客服平台提供数据支撑
 * 系统版本：v5.0.1.0
 * 开发人员: zys
 * 开发时间: 2019/02/07  23:10
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public class EmailUtil {
    public static void send_mail(String to, String content) throws MessagingException {
        //创建连接对象  连接到邮件服务器
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.qq.com");
        //发送端口
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        //发件账号he密码

        Session sessions = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //两个参数分别是发送邮件的账户和密码
                return new PasswordAuthentication("993874575@qq.com","tqrdzuxcdgrobdjh");
            }
        });

        //创建邮件对象
        Message message = new MimeMessage(sessions);
        //设置发件人
        message.setFrom(new InternetAddress("993874575@qq.com"));
        //设置收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        //设置主题
        message.setSubject("销户验证码");
        //设置邮件正文  第二个参数是邮件发送的类型
        message.setContent(content, "text/html;charset=UTF-8");
        //发送一封邮件
        Transport.send(message);

    }

}
