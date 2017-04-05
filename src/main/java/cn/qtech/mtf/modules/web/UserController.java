package cn.qtech.mtf.modules.web;

import cn.qtech.mtf.common.persistence.utils.EncodeUtil;
import cn.qtech.mtf.modules.dto.UserDto;
import cn.qtech.mtf.modules.entity.User;
import cn.qtech.mtf.modules.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by mtf81 on 2017/4/5.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("currentUser")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String loginPage(){

		return "user/login";
	}

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@Valid UserDto userDto, Errors errors, HttpSession httpSession){

		userDto.setPassword(EncodeUtil.EncodeByMd5(userDto.getPassword()));
		if(errors.hasErrors()){
			return "user/login";
		}
		User currentUser=userService.selectByEmailPassword(userDto);
		if(currentUser!=null){
			if(currentUser.getUserType().equals("1")){
				httpSession.setAttribute("admin",currentUser);
				return "redirect:/admin/desk";
			}
			httpSession.setAttribute("currentUser",currentUser);
			return "redirect:/user/account";
		}
		return "user/login";
	}

	@RequestMapping(value = "/signUp",method = RequestMethod.GET)
	public String signUpInit(){

		return "user/signup";
	}
	@RequestMapping(value="/signUp",method = RequestMethod.POST)
	public String signUp(@Valid UserDto userDto, Errors errors, ModelMap modelMap){
		if(errors.hasErrors()){
			return "user/signup";
		}
		else if(userService.selectByEmail(userDto.getEmail())!=null){
			modelMap.put("errorMessage","邮箱已存在!");
			return "user/signup";
		}
		User user=new User();
		user.setEmail(userDto.getEmail());
		user.setPassword(EncodeUtil.EncodeByMd5(userDto.getPassword()));
		user.setUsername(userDto.getUsername());
		userService.register(user);
		modelMap.addAttribute("userDto",user);
		return "redirect:/user/success";
	}

	@RequestMapping(value = "/success",method = RequestMethod.GET)
	public String success(){

		return "user/success";
	}
	@RequestMapping(value = "/account",method = RequestMethod.GET)
	public String account(HttpSession httpSession,Model model){
		User currentUser=(User)httpSession.getAttribute("currentUser");
		if(currentUser!=null) {
			model.addAttribute(currentUser);
			return "user/account";
		}
		return "redirect:/user/login";
	}
	/*
	user/account/update
	 */
	@RequestMapping(value = "/account/update",method = RequestMethod.GET)
	public String updateInit(HttpSession httpSession,Model model){
		model.addAttribute("currentUser",httpSession.getAttribute("currentUser"));
		return "user/account_update";
	}
	@RequestMapping(value = "/account/update",method = RequestMethod.POST)
	public String updateAccount(UserDto userDto,HttpSession httpSession){
		System.out.println(userDto);
		User user=(User)httpSession.getAttribute("currentUser");
		user.setUsername(userDto.getUsername());
		user.setGender(userDto.getGender());
		userService.update(user);
		return "redirect:/user/account";
	}

	@RequestMapping(value = "/signout",method = RequestMethod.GET)
	public String signOut(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "redirect:/sys/home";
	}

}
