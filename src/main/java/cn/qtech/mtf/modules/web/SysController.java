package cn.qtech.mtf.modules.web;

import cn.qtech.mtf.modules.entity.Question;
import cn.qtech.mtf.modules.sevice.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage(Model model) {

		List<Question> allQuiz = quizService.getAllQuiz();
		model.addAttribute("allQuiz",allQuiz);

		return "sys/home";
	}


}
