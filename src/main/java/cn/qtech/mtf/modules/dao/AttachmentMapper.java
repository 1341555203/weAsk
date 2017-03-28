package cn.qtech.mtf.modules.dao;

import cn.qtech.mtf.common.persistence.annotation.MyBatisDao;
import cn.qtech.mtf.modules.entity.Attachment;

@MyBatisDao
public interface AttachmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attachment record);

    int insertSelective(Attachment record);

    Attachment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attachment record);

    int updateByPrimaryKey(Attachment record);
}