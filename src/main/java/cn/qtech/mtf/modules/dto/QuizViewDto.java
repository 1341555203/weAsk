package cn.qtech.mtf.modules.dto;

import cn.qtech.mtf.modules.entity.Answer;
import cn.qtech.mtf.modules.entity.Question;
import cn.qtech.mtf.modules.entity.User;

import java.util.List;

/**
 * Created by mtf81 on 2017/4/8.
 */
public class QuizViewDto {

	User asker;
	Question question;
	List<AnswerDto> answers;
	AnswerDto choicedAnswer;

	public AnswerDto getChoicedAnswer() {
		return choicedAnswer;
	}

	public void setChoicedAnswer(AnswerDto choicedAnswer) {
		this.choicedAnswer = choicedAnswer;
	}

	public User getAsker() {
		return asker;
	}

	public void setAsker(User asker) {
		this.asker = asker;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<AnswerDto> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerDto> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "QuizViewDto{" +
				"asker=" + asker +
				", question=" + question +
				", answers=" + answers +
				", choicedAnswer=" + choicedAnswer +
				'}';
	}
}
