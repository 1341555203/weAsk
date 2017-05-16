package cn.qtech.mtf.modules.web;

import cn.qtech.mtf.modules.entity.Comment;
import cn.qtech.mtf.modules.sevice.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mtf81 on 2017/5/16.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String addComment(String content,Integer quizId,Integer userId){
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setQuestionId(quizId);
		comment.setUserId(userId);
		commentService.addComment(comment);
		return "redirect:/quiz/view/"+quizId;
	}
}
