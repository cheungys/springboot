package com.zys.boot.email.vo;

import java.io.Serializable;

/**
 * 系统名称:
 * 模块名称: 邮件服务
 * 类 名 称: EmailFile
 * 类 定 义: 邮件附件类
 * 开发人员: Administrator
 * 开发时间: 2019/05/12  9:49
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
public class EmailFile implements Serializable {
    //附件id
    private String id;
    //附件名称
    private String fileName;
    //所关联的邮件id
    private String emailId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "EmailFile{" +
                "id='" + id + '\'' +
                ", fileName='" + fileName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
