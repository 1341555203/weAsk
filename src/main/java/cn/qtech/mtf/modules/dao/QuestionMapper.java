package cn.qtech.mtf.modules.dao;

import cn.qtech.mtf.common.persistence.annotation.MyBatisDao;
import cn.qtech.mtf.modules.entity.Question;
@MyBatisDao
public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
}