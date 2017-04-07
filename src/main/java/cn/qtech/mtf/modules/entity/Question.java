package cn.qtech.mtf.modules.entity;

import java.util.Date;

public class Question {
    private Integer id;

    private Integer userId;

    private String title;

    private String content;

    private Date createDate;

    private String finishFlag;

    private String delFlag;

    public Question(Integer id, Integer userId, String title, String content, Date createDate, String finishFlag, String delFlag) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.finishFlag = finishFlag;
        this.delFlag = delFlag;
    }

    public Question() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(String finishFlag) {
        this.finishFlag = finishFlag == null ? null : finishFlag.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}