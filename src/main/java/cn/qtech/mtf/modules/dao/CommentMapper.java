package cn.qtech.mtf.modules.dao;

import cn.qtech.mtf.common.persistence.annotation.MyBatisDao;
import cn.qtech.mtf.modules.entity.Comment;

import java.util.List;

@MyBatisDao
public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectByQuizId(Integer quizId);
}