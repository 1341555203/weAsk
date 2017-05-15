package cn.qtech.mtf.modules.web;

import cn.qtech.mtf.modules.dto.QuizViewDto;
import cn.qtech.mtf.modules.entity.Answer;
import cn.qtech.mtf.modules.entity.Choice;
import cn.qtech.mtf.modules.entity.Question;
import cn.qtech.mtf.modules.entity.User;
import cn.qtech.mtf.modules.sevice.AnswerService;
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
import java.util.List;

/**
 * Created by mtf81 on 2017/4/6.
 */
@Controller
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private AnswerService answerService;
	@Autowired
	private QuizService quizService;

	@RequestMapping(value = "/startup", method = RequestMethod.GET)
	public String startupPage() {

		return "quiz/startup";
	}

	@RequestMapping(value = "/startup", method = RequestMethod.POST)
	public String startUp(@Valid Question question, Errors errors, HttpSession httpSession) {
		if (errors.hasErrors()) {
			return "quiz/startup";
		}
		Question question1 = question;
		int savedQuizId;
		savedQuizId = quizService.saveQuiz(question1);
		return "redirect:/quiz/view/" + savedQuizId;
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String view(@PathVariable int id, Model model) {
		int quizId = id;
//		Question quiz=quizService.getQuizById(id);

		QuizViewDto quizViewDto = quizService.getQuizViewDtosByQuestionId(quizId);
		model.addAttribute(quizViewDto);
		System.out.println(quizViewDto);

		return "quiz/view";
	}

	@RequestMapping(value = "/answer", method = RequestMethod.POST)
	public String postAnswer(@Valid Answer answer) {
		answerService.saveAnswer(answer);

		return "redirect:/quiz/view/" + answer.getQuestionId();
	}

	@RequestMapping(value = "/chooseAnswer", method = RequestMethod.POST)
	public String chooseAnswer(Choice choice) {

		quizService.chooseAnswer(choice);

		return "redirect:/quiz/view/" + choice.getquestionId();
	}

	//我的提问
	@RequestMapping(value = "/myQuiz", method = RequestMethod.GET)
	public String myQuiz(HttpSession httpSession, Model model) {
		User currentUser = (User) httpSession.getAttribute("currentUser");
		List<Question> myQuestions = quizService.getQuizByUserId(currentUser.getId());
		model.addAttribute("myQuestions", myQuestions);
		return "quiz/myquiz";
	}

	@RequestMapping(value = "/answer", method = RequestMethod.GET)
	public String myAnswer(HttpSession httpSession, Model model) {
		User currentUser = (User) httpSession.getAttribute("currentUser");
		List<Question> myAnsweredQuestions = quizService.getAnswerdQuizByUserId(currentUser.getId());
		model.addAttribute("myAnsweredQuestions", myAnsweredQuestions);
		return "quiz/myanswer";
	}

	@RequestMapping(value = "/search/{type}/{keyWord}", method = RequestMethod.GET)
	public String search(@PathVariable String type, @PathVariable String keyWord, Model model) {
		List<Question> questions = null;
		if (!(keyWord == null) && !(keyWord.equals("")))
			if (type.equals("title")) {
				questions = quizService.getQuestionsByTitleKeyWord(keyWord);
			} else if (type.equals("content")) {
				questions = quizService.getQuestionsByContentKeyWord(keyWord);
			}
		model.addAttribute("questions", questions);
		return "quiz/search";
	}
}
