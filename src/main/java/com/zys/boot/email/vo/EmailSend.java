package com.zys.boot.email.vo;

import com.zys.boot.email.vo.EmailFile;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统名称:
 * 模块名称: 邮件服务
 * 类 名 称: EmailSend
 * 类 定 义: 邮件发送实体
 * 开发人员: Administrator
 * 开发时间: 2019/05/12  9:52
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
public class EmailSend implements Serializable {
    private String id;
    /**
     * 发件用户ID
     */
    private String userId;
    /**
     * 发件人
     */
    private String fromUser;
    /**
     * 收件人
     */
    private String toUsers;
    /**
     * 抄送人
     */
    private String ccUsers;
    /**
     * 主题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 附件列表
     */
    private List<EmailFile> files;
    /**
     * 收件时间
     */
    private Date sendDate;
    /**
     * 删除标识
     */
    private String delTag;
    /**
     * 开始时间
     */
    private String beginTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 附件路径
     */
    private List<String> filepath;

    public List<String> getFilepath() {
        return filepath;
    }

    public void setFilepath(List<String> filepath) {
        this.filepath = filepath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUsers() {
        return toUsers;
    }

    public void setToUsers(String toUsers) {
        this.toUsers = toUsers;
    }

    public String getCcUsers() {
        return ccUsers;
    }

    public void setCcUsers(String ccUsers) {
        this.ccUsers = ccUsers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<EmailFile> getFiles() {
        return files;
    }

    public void setFiles(List<EmailFile> files) {
        this.files = files;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getDelTag() {
        return delTag;
    }

    public void setDelTag(String delTag) {
        this.delTag = delTag;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "EmailSend{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", fromUser='" + fromUser + '\'' +
                ", toUsers='" + toUsers + '\'' +
                ", ccUsers='" + ccUsers + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", files=" + files +
                ", sendDate=" + sendDate +
                ", delTag='" + delTag + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
