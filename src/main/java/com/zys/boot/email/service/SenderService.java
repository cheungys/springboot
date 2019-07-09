package com.zys.boot.email.service;

import com.zys.boot.email.vo.EmailSend;

public interface SenderService {
    /**
     * 生产者发送邮件
     * @param emailSend
     */
    void sendEmail(EmailSend emailSend);
}
