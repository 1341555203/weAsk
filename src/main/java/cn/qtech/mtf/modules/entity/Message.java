package cn.qtech.mtf.modules.entity;

import java.util.Date;

public class Message {
    private Integer id;

    private Integer fromUserId;

    private Integer toUserId;

    private String content;

    private Date createDate;

    public Message(Integer id, Integer fromUserId, Integer toUserId, String content, Date createDate) {
        this.id = id;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.content = content;
        this.createDate = createDate;
    }

    public Message() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
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
}