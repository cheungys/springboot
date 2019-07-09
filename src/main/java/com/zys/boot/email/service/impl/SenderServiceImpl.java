package com.zys.boot.email.service.impl;

import com.zys.boot.email.vo.EmailSend;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 import com.zys.boot.email.service.SenderService;
/**
 * @author zys
 * 系统名称:
 * 模块名称: 邮件模块
 * 类 名 称: SenderServiceImpl
 * 类 定 义:
 * 开发时间: 2019/06/09  21:38
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Service
public class SenderServiceImpl implements SenderService{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendEmail(EmailSend emailSend) {
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(emailSend.getId());
        rabbitTemplate.convertAndSend("mail-exchange", "mail.test", emailSend, correlationData);
    }
}
