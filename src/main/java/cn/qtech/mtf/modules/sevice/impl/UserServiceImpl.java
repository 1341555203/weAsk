package cn.qtech.mtf.modules.sevice.impl;


import cn.qtech.mtf.modules.dao.UserMapper;
import cn.qtech.mtf.modules.dto.UserDto;
import cn.qtech.mtf.modules.entity.User;
import cn.qtech.mtf.modules.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by mtf81 on 2017/2/3.
 */
@Service
class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public User selectByEmailPassword(UserDto userDto) {
		return userMapper.selectByEmailPassword(userDto);
	}

	@Override
	public User selectByEmailUsername(UserDto userDto) {
		return null;
	}

	@Override
	public void register(User user) {

		user.setCreateDate(new Date());
		userMapper.insertSelective(user);
	}

	@Override
	public void update(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User selectByEmail(String email) {
		return userMapper.selectByEmail(email);
	}

	@Override
	public List<User> findAllUser() {
		return userMapper.findAllUser();
	}

	@Override
	public void delUser(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}

}
