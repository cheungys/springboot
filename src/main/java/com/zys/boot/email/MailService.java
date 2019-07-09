package com.zys.boot.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;


/**
 * 系统名称:
 * 模块名称: 邮件服务
 * 类 名 称: MailService
 * 类 定 义:
 * 开发人员: Administrator
 * 开发时间: 2019/05/14  12:07
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

/**
 * @author zys
 */
@Service
public class MailService {
    private final Logger logger = LoggerFactory.getLogger(MailService.class);
    @Autowired
    private JavaMailSender sender;
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送普通邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        try {
            sender.send(mailMessage);
            logger.info("简易邮件已发送！！！");
        } catch (Exception e) {
            logger.error("邮件发送异常", e);
        }

    }

    /**
     * 发送带附件的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param filePath
     */
    public void sendAttachmentsMail(String to, String subject, String content, List<String> filePath) {
        MimeMessage message = sender.createMimeMessage();

        try {
            // true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            if (filePath != null && filePath.size() > 0) {
                for (int i = 0; i < filePath.size(); i++) {
                    FileSystemResource file = new FileSystemResource(new File(filePath.get(i)));
                    String fileName = filePath.get(i).substring(filePath.get(i).lastIndexOf(File.separator));
                    helper.addAttachment(fileName, file);
                }
            }
            sender.send(message);
            logger.info("带附件的邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送带附件的邮件时发生异常！", e);
        }
    }
}
