package cn.qtech.mtf.modules.web;

import cn.qtech.mtf.modules.entity.Question;
import cn.qtech.mtf.modules.entity.User;
import cn.qtech.mtf.modules.sevice.QuizService;
import cn.qtech.mtf.modules.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by mtf81 on 2017/4/5.
 */
@Controller
@RequestMapping("/sys")
public class SysController {

	@Autowired
	private QuizService quizService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage(Model model) {

		List<Question> allQuiz = quizService.getAllQuiz();
		model.addAttribute("allQuiz",allQuiz);

		return "sys/home";
	}
	@RequestMapping(value = "/help",method = RequestMethod.GET)
	public String help(){
		return "/sys/help";
	}

	@RequestMapping(value = "/msg/{toId}", method = RequestMethod.GET)
	public String tmp(@PathVariable Integer toId, Model model){

		User toUser = userService.selectById(toId);
		model.addAttribute("toUser", toUser);
//		model.addAttribute("toUserId",toId);
		return "msg";
	}

}
