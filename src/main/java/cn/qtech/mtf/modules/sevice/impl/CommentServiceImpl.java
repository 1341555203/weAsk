package cn.qtech.mtf.modules.sevice.impl;

import cn.qtech.mtf.modules.dao.CommentMapper;
import cn.qtech.mtf.modules.entity.Comment;
import cn.qtech.mtf.modules.sevice.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mtf81 on 2017/5/16.
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;
	@Override
	public List<Comment> getCommentsByQuizId(Integer quizId) {
		return commentMapper.selectByQuizId(quizId);
	}

	@Override
	public void addComment(Comment comment) {
		commentMapper.insertSelective(comment);
	}
}
