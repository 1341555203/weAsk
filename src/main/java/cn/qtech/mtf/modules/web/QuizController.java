package cn.qtech.mtf.modules.web;

import cn.qtech.mtf.modules.entity.Question;
import cn.qtech.mtf.modules.sevice.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by mtf81 on 2017/4/6.
 */
@Controller
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	private QuizService quizService;
	@RequestMapping(value = "/startup",method = RequestMethod.GET)
	public String startupPage(){

		return "quiz/startup";
	}

	@RequestMapping(value = "/startup",method = RequestMethod.POST)
	public String startUp(@Valid Question question, Errors errors, HttpSession httpSession){
		if(errors.hasErrors()){
			return "quiz/startup";
		}
		Question question1=question;
		int savedQuizId;
		savedQuizId=quizService.saveQuiz(question1);
		return "redirect:/quiz/view/"+savedQuizId;
	}
	@RequestMapping(value = "/view/{id}",method = RequestMethod.GET)
	public String view(@PathVariable int id,Model model){
		int quizId =id;
		Question quiz=quizService.getQuizById(id);
		model.addAttribute(quiz);
		return "quiz/view";
	}
}
