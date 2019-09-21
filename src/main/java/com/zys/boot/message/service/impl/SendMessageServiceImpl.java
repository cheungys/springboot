package com.zys.boot.message.service.impl;

import com.alibaba.fastjson.JSON;
import com.zhenzi.sms.ZhenziSmsClient;
import com.zys.boot.base.utils.StringUtil;
import com.zys.boot.message.dao.MessageMapper;
import com.zys.boot.message.entity.Message;
import com.zys.boot.message.service.SendMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author zys
 * 系统名称:
 * 模块名称: 短信服务
 * 类 名 称: SendMessageServiceImpl
 * 类 定 义: 发送短信实现类
 * 开发时间: 2019/09/08  1:30
 * 审核人员:
 * 相关文档: doc/短信API文档.pdf
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Repository
@Transactional
public class SendMessageServiceImpl implements SendMessageService {
    private static final Logger logger = LoggerFactory.getLogger(SendMessageServiceImpl.class);

    @Resource
    private MessageMapper messageMapper;
    /**
     * 服务请求地址（仅供个人开发或学习用，详情请看说明文档）
     */
    private String apiUrl = "https://sms_developer.zhenzikj.com";
    /**
     * 应用id ，可通过用户中心，应用详情查看
     */
    private String appId = "102453";
    /**
     * 应用密钥
     */
    private String appSecret = "f90a124c-f416-4281-9db5-63993c9cef2e";
    ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
    /**
     * 发送成功标识
     */
    private static final String SEND_SUCCESS_FLAG = "0";
    private static final String CODE = "code";

    @Override
    public boolean sendMessage(Message message) {

        String result;
        if (StringUtil.isNotNull(message)) {
            if (StringUtil.isNotBlank(message.getReceives())) {
                try {
                    result = client.send(message.getReceives(), message.getContent());
                    if (SEND_SUCCESS_FLAG.equals(JSON.parseObject(result).get(CODE).toString())) {
                        //做入库操作
                        message.setId(UUID.randomUUID().toString().replace("-",""));
                        message.setCreateTime(String.valueOf(System.currentTimeMillis()));
                        message.setSendFlag(Integer.parseInt(SEND_SUCCESS_FLAG));
                        return saveMessage(message);
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return false;
    }

    @Override
    public List<Message> getMessageRecords(Message message) {
        return null;
    }

    @Override
    public boolean saveMessage(Message message) {
        if (StringUtil.isNotEmpty(message)) {
            if (messageMapper.insert(message) > 0) {
                return true;
            }
        }
        return false;
    }
}
