package cn.qtech.mtf.modules.entity;

public class Attachment {
    private Integer id;

    private String attType;

    private String attName;

    private String attOrigin;

    public Attachment(Integer id, String attType, String attName, String attOrigin) {
        this.id = id;
        this.attType = attType;
        this.attName = attName;
        this.attOrigin = attOrigin;
    }

    public Attachment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttType() {
        return attType;
    }

    public void setAttType(String attType) {
        this.attType = attType == null ? null : attType.trim();
    }

    public String getAttName() {
        return attName;
    }

    public void setAttName(String attName) {
        this.attName = attName == null ? null : attName.trim();
    }

    public String getAttOrigin() {
        return attOrigin;
    }

    public void setAttOrigin(String attOrigin) {
        this.attOrigin = attOrigin == null ? null : attOrigin.trim();
    }
}