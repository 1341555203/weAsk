package cn.qtech.mtf.modules.dto;

/**
 * Created by mtf81 on 2017/2/15.
 */
public class AttachmentDto {
	private Integer ownerId;

	private String ownerType;

	public String getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
}
