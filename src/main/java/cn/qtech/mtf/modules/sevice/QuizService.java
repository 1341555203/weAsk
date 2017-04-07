package cn.qtech.mtf.modules.sevice;

import cn.qtech.mtf.modules.entity.Question;
import cn.qtech.mtf.modules.entity.User;

import java.util.List;

/**
 * Created by mtf81 on 2017/4/7.
 */
public interface QuizService {
	int saveQuiz(Question question);
	void delQuiz(Integer id);
	Question getQuizById(Integer id);
	List<Question> getAllQuiz();
	List<Question> getQuizByUserId(Integer userId);

}
