package cn.qtech.mtf.modules.entity;

import java.util.Date;

public class Banner {
    private Integer id;

    private Integer questionId;

    private String img;

    private String alt;

    private Date createDate;

    public Banner(Integer id, Integer questionId, String img, String alt, Date createDate) {
        this.id = id;
        this.questionId = questionId;
        this.img = img;
        this.alt = alt;
        this.createDate = createDate;
    }

    public Banner() {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt == null ? null : alt.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}