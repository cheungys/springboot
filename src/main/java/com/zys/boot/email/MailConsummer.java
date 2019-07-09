package com.zys.boot.email;

import com.rabbitmq.client.Channel;
import com.zys.boot.email.vo.EmailSend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

import java.util.Map;

/**
 * @author: zys
 * 系统名称:
 * 模块名称: 邮件服务
 * 类 名 称: MailConsummer
 * 类 定 义: 邮件消费者
 * 开发人员: Administrator
 * 开发时间: 2019/05/14  12:05
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Component
public class MailConsummer {
    private final Logger logger = LoggerFactory.getLogger(MailConsummer.class);

    @Autowired
    private MailService mailService;
    @Autowired
    private TemplateEngine templateEngine;

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "email", durable = "true"), exchange = @Exchange(value = "mail-exchange", durable = "true", type = "topic"), key = "mail.*"))
    @RabbitHandler
    public void onMailMessage(@Payload EmailSend emailSend, @Headers Map<String, Object> headers, Channel channel) throws Exception {
        logger.info("******收到消息**********");
        mailService.sendAttachmentsMail(emailSend.getToUsers(), emailSend.getTitle(), emailSend.getContent(), emailSend.getFilepath());
        Long d = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(d, false);


    }
}
