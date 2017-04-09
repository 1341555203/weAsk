package cn.qtech.mtf.modules.entity;

import java.util.Date;

public class Choice {
    private Integer id;

    private Integer questionId;

    private Integer replierId;

    private Integer answerId;

    private Date createDate;

    public Choice(Integer id, Integer questionId, Integer replierId, Integer answerId, Date createDate) {
        this.id = id;
        this.questionId = questionId;
        this.replierId = replierId;
        this.answerId = answerId;
        this.createDate = createDate;
    }

    public Choice() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getquestionId() {
        return questionId;
    }

    public void setquestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getReplierId() {
        return replierId;
    }

    public void setReplierId(Integer replierId) {
        this.replierId = replierId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}