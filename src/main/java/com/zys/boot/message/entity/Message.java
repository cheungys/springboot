package com.zys.boot.message.entity;

import com.zys.boot.base.model.BaseBean;
import lombok.Data;

@Data
public class Message extends BaseBean {

    /**
     * 发件人
     */
    private String sender;
    /**
     * 收件人  （群）
     */
    private String receives;
    /**
     * 短信内容
     */
    private String content;
    /**
     * 短信发送成功标识 （1：成功   0：失败）
     */
    private Integer sendFlag;


}