package cn.qtech.mtf.modules.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mtf81 on 2017/4/5.
 */
@Controller
@RequestMapping("/sys")
public class SysController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage() {

		return "sys/home";
	}


}
