package cn.qtech.mtf.modules.entity;

import java.util.Date;

public class Answer {
    private Integer id;

    private Integer questionId;

    private Integer userId;

    private String content;

    private Date createDate;

    private String delFlag;

    public Answer(Integer id, Integer questionId, Integer userId, String content, Date createDate, String delFlag) {
        this.id = id;
        this.questionId = questionId;
        this.userId = userId;
        this.content = content;
        this.createDate = createDate;
        this.delFlag = delFlag;
    }

    public Answer() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}