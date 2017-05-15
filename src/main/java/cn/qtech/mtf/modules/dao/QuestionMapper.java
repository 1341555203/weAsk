package cn.qtech.mtf.modules.dao;

import cn.qtech.mtf.common.persistence.annotation.MyBatisDao;
import cn.qtech.mtf.modules.entity.Question;

import java.util.List;

@MyBatisDao
public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    void setFinishByPrimaryKey(Integer id);

    List<Question> getQuestionByUserId(Integer id);

    List<Question> getAnswerdQuizByUserId(Integer id);

	List<Question> getAllQuiz();

	List<Question> getQuestionsByTitleKeyWord(String keyWord);

	List<Question> getQuestionsByContentKeyWord(String keyWord);
}