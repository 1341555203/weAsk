package cn.qtech.mtf.modules.dao;

import cn.qtech.mtf.common.persistence.annotation.MyBatisDao;
import cn.qtech.mtf.modules.entity.Message;

import java.util.List;

@MyBatisDao
public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> unreadMessageList(Integer userId);

    List<Message> talkMessage(Integer fromUserId,Integer toUserId);
}