package cn.qtech.mtf.modules.web;

import cn.qtech.mtf.modules.entity.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mtf81 on 2017/5/21.
 */
@Controller
@RequestMapping("/msg")
public class MessageController {

	@RequestMapping(value = "/{toId}",method = RequestMethod.GET)
	public String getMsg(@PathVariable int toId, Model model){
		List<Message> messages = new ArrayList<Message>();
		Message msg = new Message();
		msg.setId(1);
		msg.setContent("hello");
		msg.setCreateDate(new Date());
		msg.setToUserId(1);
		msg.setFromUserId(2);

		Message msg2 = new Message();
		msg2.setId(2);
		msg2.setContent("hi my guy");
		msg2.setCreateDate(new Date());
		msg2.setToUserId(2);
		msg2.setFromUserId(1);

		Message msg3 = new Message();
		msg3.setId(3);
		msg3.setContent("hi 1233y");
		msg3.setCreateDate(new Date());
		msg3.setToUserId(1);
		msg3.setFromUserId(2);

		messages.add(msg);
		messages.add(msg2);
		messages.add(msg3);
		model.addAttribute("messages",messages);
		return "msg";
	}

	//get message count

	// post message

	/*
	消息轮询
	消息发送
	消息动态展示/刷新消息页面

	 */

}
