package cn.qtech.mtf.modules.sevice.impl;

import cn.qtech.mtf.modules.dao.AnswerMapper;
import cn.qtech.mtf.modules.entity.Answer;
import cn.qtech.mtf.modules.sevice.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mtf81 on 2017/4/8.
 */
@Service
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	AnswerMapper answerMapper;

	@Override
	public int saveAnswer(Answer answer) {
		int savedAnswerId = answerMapper.insertSelective(answer);
		return savedAnswerId ;
	}

	@Override
	public void delAnswer(Integer id) {

	}

	@Override
	public Answer getAnswerById(Integer id) {
		return answerMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Answer> getAnswerByQuestionId(Integer questionId) {
		return answerMapper.getAnswersByQuestionId(questionId);
	}

	@Override
	public List<Answer> getAnswerByUserId(Integer id) {
		return null;
	}

	@Override
	public List<Answer> getAllAnswer() {
		return null;
	}
}
