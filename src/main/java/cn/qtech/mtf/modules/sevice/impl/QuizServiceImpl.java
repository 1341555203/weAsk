package cn.qtech.mtf.modules.sevice.impl;

import cn.qtech.mtf.modules.dao.AnswerMapper;
import cn.qtech.mtf.modules.dao.ChoiceMapper;
import cn.qtech.mtf.modules.dao.QuestionMapper;
import cn.qtech.mtf.modules.dao.UserMapper;
import cn.qtech.mtf.modules.dto.AnswerDto;
import cn.qtech.mtf.modules.dto.QuizViewDto;
import cn.qtech.mtf.modules.entity.Answer;
import cn.qtech.mtf.modules.entity.Choice;
import cn.qtech.mtf.modules.entity.Question;
import cn.qtech.mtf.modules.entity.User;
import cn.qtech.mtf.modules.sevice.AnswerService;
import cn.qtech.mtf.modules.sevice.QuizService;
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
	@Autowired
	private ChoiceMapper choiceMapper;

	@Override
	public int saveQuiz(Question question) {
		questionMapper.insertSelective(question);
		int id = question.getId();
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
		return questionMapper.getAllQuiz();
	}

	@Override
	public List<Question> getQuizByUserId(Integer userId) {
		return questionMapper.getQuestionByUserId(userId);
	}

	@Override
	public List<Question> getQuestionsByTitleKeyWord(String keyWord) {
		return questionMapper.getQuestionsByTitleKeyWord("%"+keyWord+"%");
	}

	@Override
	public List<Question> getQuestionsByContentKeyWord(String keyWord) {
		return questionMapper.getQuestionsByContentKeyWord("%"+keyWord+"%");
	}

	@Override
	public List<Question> getAnswerdQuizByUserId(Integer userId) {
		return questionMapper.getAnswerdQuizByUserId(userId);
	}

	@Override
	public QuizViewDto getQuizViewDtosByQuestionId(Integer questionId) {
		Answer choicedAnswer = null;
		AnswerDto choiceAnswerDto = null;
		QuizViewDto quizViewDto = new QuizViewDto();
//		获得Question
		Question question = this.getQuizById(questionId);
//		获得提问者User
		User asker = userMapper.selectByPrimaryKey(question.getUserId());
//		获得Question的所有Answer
		List<Answer> answers = answerService.getAnswerByQuestionId(questionId);
//		遍历answers，找到对应回答者User，整合到AnserDto中，加入到List里
		List<AnswerDto> answerDtos = new ArrayList<AnswerDto>();

		Choice choice = choiceMapper.selectByQuestionId(questionId);

		if (answers != null) {
			for (Answer a : answers) {
				AnswerDto answerDto = new AnswerDto();
				User replier = userMapper.selectByPrimaryKey(a.getUserId());
				answerDto.setAnswer(a);
				answerDto.setUser(replier);
				if (choice != null && a.getId() == choice.getAnswerId()) {
					choiceAnswerDto = answerDto;
				} else {
					answerDtos.add(answerDto);
				}

			}
		}

//		将结果添加到quziViewDto中
		quizViewDto.setQuestion(question);
		quizViewDto.setAsker(asker);
		quizViewDto.setAnswers(answerDtos);
		quizViewDto.setChoicedAnswer(choiceAnswerDto);

		return quizViewDto;
	}

	@Override
	public void chooseAnswer(Choice choice) {
		choiceMapper.insertSelective(choice);
		questionMapper.setFinishByPrimaryKey(choice.getquestionId());
	}
}
