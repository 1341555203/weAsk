package cn.qtech.mtf.modules.sevice;

import cn.qtech.mtf.modules.entity.Comment;

import java.util.List;

/**
 * Created by mtf81 on 2017/5/16.
 */
public interface CommentService {
	List<Comment> getCommentsByQuizId(Integer quizId);
	void addComment(Comment comment);
}
