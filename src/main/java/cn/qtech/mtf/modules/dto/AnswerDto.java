package cn.qtech.mtf.modules.dto;

import cn.qtech.mtf.modules.entity.Answer;
import cn.qtech.mtf.modules.entity.User;

/**
 * Created by mtf81 on 2017/4/8.
 */
public class AnswerDto {
	User user;
	Answer answer;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
}
