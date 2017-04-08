package cn.qtech.mtf.modules.sevice.impl;

import cn.qtech.mtf.modules.dao.AnswerMapper;
import cn.qtech.mtf.modules.dao.QuestionMapper;
import cn.qtech.mtf.modules.dao.UserMapper;
import cn.qtech.mtf.modules.dto.AnswerDto;
import cn.qtech.mtf.modules.dto.QuizViewDto;
import cn.qtech.mtf.modules.entity.Answer;
import cn.qtech.mtf.modules.entity.Question;
import cn.qtech.mtf.modules.entity.User;
import cn.qtech.mtf.modules.sevice.AnswerService;
import cn.qtech.mtf.modules.sevice.QuizService;
import cn.qtech.mtf.modules.sevice.UserService;
import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mtf81 on 2017/4/7.
 */
@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AnswerMapper answerMapper;
	@Autowired
	private AnswerService answerService;

	@Override
	public int saveQuiz(Question question) {
		 questionMapper.insertSelective(question);
		int id=question.getId();
		return id;
	}

	@Override
	public void delQuiz(Integer id) {

	}

	@Override
	public Question getQuizById(Integer id) {
		return questionMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Question> getAllQuiz() {
		return null;
	}

	@Override
	public List<Question> getQuizByUserId(Integer userId) {
		return null;
	}

	@Override
	public QuizViewDto getQuizViewDtosByQuestionId(Integer questionId) {
		QuizViewDto quizViewDto =new QuizViewDto();
//		获得Question
		Question question = this.getQuizById(questionId);
//		获得提问者User
		User asker = userMapper.selectByPrimaryKey(question.getUserId());
//		获得Question的所有Answer
		List<Answer> answers = answerService.getAnswerByQuestionId(questionId);
//		遍历answers，找到对应回答者User，整合到AnserDto中，加入到List里
		List<AnswerDto> answerDtos = new ArrayList<AnswerDto>();
		for(Answer a:answers){
			AnswerDto answerDto = new AnswerDto();
			User replier = new User();
			replier = userMapper.selectByPrimaryKey(a.getUserId());
			answerDto.setAnswer(a);
			answerDto.setUser(replier);
			answerDtos.add(answerDto);
		}
//		将结果添加到quziViewDto中返回
		quizViewDto.setQuestion(question);
		quizViewDto.setAsker(asker);
		quizViewDto.setAnswers(answerDtos);

		return quizViewDto;
	}
}
