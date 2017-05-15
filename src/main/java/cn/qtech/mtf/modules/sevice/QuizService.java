package cn.qtech.mtf.modules.sevice;

import cn.qtech.mtf.modules.dto.QuizViewDto;
import cn.qtech.mtf.modules.entity.Choice;
import cn.qtech.mtf.modules.entity.Question;

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

	List<Question> getQuestionsByTitleKeyWord(String keyWord);

	List<Question> getQuestionsByContentKeyWord(String keyWord);

	List<Question> getAnswerdQuizByUserId(Integer userId);

	QuizViewDto getQuizViewDtosByQuestionId(Integer questionId);

	void chooseAnswer(Choice choice);
}
