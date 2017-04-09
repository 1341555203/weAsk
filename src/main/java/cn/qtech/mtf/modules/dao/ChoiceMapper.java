package cn.qtech.mtf.modules.dao;

import cn.qtech.mtf.common.persistence.annotation.MyBatisDao;
import cn.qtech.mtf.modules.entity.Choice;

@MyBatisDao
public interface ChoiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Choice record);

    int insertSelective(Choice record);

    Choice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Choice record);

    int updateByPrimaryKey(Choice record);

    Choice selectByQuestionId(Integer id);

}