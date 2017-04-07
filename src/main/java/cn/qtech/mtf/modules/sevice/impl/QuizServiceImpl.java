package cn.qtech.mtf.modules.sevice.impl;

import cn.qtech.mtf.modules.dao.QuestionMapper;
import cn.qtech.mtf.modules.entity.Question;
import cn.qtech.mtf.modules.sevice.QuizService;
import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mtf81 on 2017/4/7.
 */
@Service
public class QuizServiceImpl implements QuizService {
	@Autowired
	private QuestionMapper questionMapper;
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
}
