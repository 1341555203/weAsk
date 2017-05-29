package cn.qtech.mtf.modules.dto;

import cn.qtech.mtf.modules.entity.Message;

import java.util.List;

/**
 * Created by mtf81 on 2017/5/29.
 */
public class MessageList {
	private List<Message> messages;

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
}
