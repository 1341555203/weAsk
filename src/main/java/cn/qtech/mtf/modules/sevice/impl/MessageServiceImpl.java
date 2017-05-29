package cn.qtech.mtf.modules.sevice.impl;

import cn.qtech.mtf.modules.dao.MessageMapper;
import cn.qtech.mtf.modules.entity.Message;
import cn.qtech.mtf.modules.sevice.MessageService;
import org.hibernate.validator.internal.util.logging.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by mtf81 on 2017/5/29.
 */
@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageMapper mapper;

	@Override
	public List<Message> getTalkMessage(Integer fromUserId, Integer toUserId) {
		List<Message> m1 = mapper.talkMessage(fromUserId,toUserId);
		List<Message> m2 = mapper.talkMessage(toUserId,fromUserId);
		m1.addAll(m2);
		Collections.sort(m1);
		return m1;
	}

	@Override
	public List<Message> getUnreadMessage(Integer userId) {
		return mapper.unreadMessageList(userId);
	}

	@Override
	public void setMessageRead(Integer toId, Integer fromId) {
		List<Message> messages = mapper.talkMessage(toId,fromId);
		for (Message m : messages) {
				m.setIsRead("1");
				mapper.updateByPrimaryKeySelective(m);
			}
	}

//	@Override
//	public void setMessageRead(List<Message> messages) {
//		if ((messages != null) && (messages.size() != 0)) {
//			for (Message m : messages) {
//				m.setIsRead("1");
//				mapper.updateByPrimaryKeySelective(m);
//			}
//		}
//	}

	@Override
	public void saveMessage(Message message) {

		mapper.insertSelective(message);
	}
}
