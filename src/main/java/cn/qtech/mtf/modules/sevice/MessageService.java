package cn.qtech.mtf.modules.sevice;

import cn.qtech.mtf.modules.entity.Message;

import java.util.List;

/**
 * Created by mtf81 on 2017/5/29.
 */
public interface MessageService {
	List<Message> getTalkMessage(Integer fromUserId,Integer toUserId);
	List<Message> getUnreadMessage(Integer userId);
	void setMessageRead(Integer toId,Integer fromId);
	void saveMessage(Message message);
}
