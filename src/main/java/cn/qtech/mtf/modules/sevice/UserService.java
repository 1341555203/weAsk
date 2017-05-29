package cn.qtech.mtf.modules.sevice;



import cn.qtech.mtf.modules.dto.UserDto;
import cn.qtech.mtf.modules.entity.User;

import java.util.List;

/**
 * Created by mtf81 on 2017/2/3.
 */
public interface UserService {
	User selectByEmailPassword(UserDto userDto);
	User selectByEmailUsername(UserDto userDto);
	void register(User user);
	void update(User user);
	User selectByEmail(String email);
	List<User> findAllUser();
	void delUser(Integer id);
	User selectById(Integer id);
}
