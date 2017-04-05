package cn.qtech.mtf.modules.dao;

import cn.qtech.mtf.common.persistence.annotation.MyBatisDao;
import cn.qtech.mtf.modules.dto.UserDto;
import cn.qtech.mtf.modules.entity.User;

import java.util.List;

@MyBatisDao
public interface UserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User selectByEmail(String email);

	User selectByEmailPassword(UserDto userDto);

	List<User> findAllUser();
}