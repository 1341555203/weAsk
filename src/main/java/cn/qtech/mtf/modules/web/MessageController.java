package cn.qtech.mtf.modules.web;

import cn.qtech.mtf.modules.dto.MessageList;
import cn.qtech.mtf.modules.entity.Message;
import cn.qtech.mtf.modules.entity.User;
import cn.qtech.mtf.modules.sevice.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mtf81 on 2017/5/21.
 */
@RestController
@RequestMapping("/msg")
public class MessageController {

	@Autowired
	private MessageService messageService;

	//发送给{toId}的消息
	@RequestMapping(value = "/talk/{toId}", method = RequestMethod.GET)
	public List<Message> postedMsg(@PathVariable int toId, Model model,HttpSession session) {
		User currentUser = (User) session.getAttribute("currentUser");
		List<Message> messages =messageService.getTalkMessage(currentUser.getId(),toId);
//		model.addAttribute("messages", messages);
		return messages;
	}

	//接收的消息
	@RequestMapping(value = "/receive", method = RequestMethod.GET)
	public List<Message> receiveMsg(HttpSession session, Model model) {
		List<Message> messages = new ArrayList<Message>();
		User currentUser = (User) session.getAttribute("currentUser");
		if (currentUser != null) {
			 messages = messageService.getUnreadMessage(currentUser.getId());
		}
//		model.addAttribute("messages", messages);
		return messages;
	}

	//get message count
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public Integer getMsgCount(HttpSession session) {
		User currentUser = (User) session.getAttribute("currentUser");
		int count = 0;
		if (currentUser != null) {
			List<Message> tmp = messageService.getUnreadMessage(currentUser.getId());
			count = tmp == null ? 0 : tmp.size();
		}
		return count;
	}

	@RequestMapping(value = "/setRead",method = RequestMethod.GET)
	public String setRead( Integer toId,HttpSession session){
		User currentUser = (User)session.getAttribute("currentUser");
		messageService.setMessageRead(toId,currentUser.getId());
		return "success";
	}

	// post message
	@RequestMapping(value = "/send",method = RequestMethod.POST)
	public String sendMsg(@RequestBody Message message){
		if(message!=null) {
			messageService.saveMessage(message);
		}
		return "success";
	}
	/*
	消息轮询
	消息发送
	消息动态展示/刷新消息页面
	设为已读
	 */

}
