package cn.qtech.mtf.modules.sevice;

import cn.qtech.mtf.modules.entity.Answer;

import java.util.List;

/**
 * Created by mtf81 on 2017/4/8.
 */
public interface AnswerService {
	int saveAnswer(Answer answer);
	void delAnswer(Integer id);
	Answer getAnswerById(Integer id);

	List<Answer> getAnswerByQuestionId(Integer questionId);
	List<Answer> getAnswerByUserId(Integer id);
	List<Answer> getAllAnswer();


}
