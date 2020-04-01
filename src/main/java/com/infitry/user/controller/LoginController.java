package com.infitry.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infitry.user.component.UserComponent;
import com.infitry.user.entity.User;
import com.infitry.user.result.TransResult;

/**
 * @since 2020. 3. 31.
 * @author leesw
 * @mail leesw504@gmail.com
 * @description : 로그인 컨트롤러
 */
@RestController
@CrossOrigin
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Autowired
	UserComponent userComponent;
	
	/**
	 * @since 2020. 3. 31.
	 * @author leesw
	 * @description : 로그인 처리
	 */
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	TransResult login(@RequestBody User user) {
		TransResult result = new TransResult(true);
		
		User loginUser = userComponent.getUserById(user.getId());
		if (loginUser == null) {
			logger.error("로그인 유저가 존재하지 않습니다.");
			result.setErrorMessage("로그인 유저가 존재하지 않습니다.");
			result.setSuccess(false);
		}
		
		if (!encoder.matches(user.getPassword(), loginUser.getPassword())) {
			logger.error("비밀번호가 다릅니다.");
			result.setErrorMessage("비밀번호가 다릅니다.");
			result.setSuccess(false);
		}
		//TODO redis를  활용해 캐쉬추가 로그인 처리 추가할 것
		logger.info(result.toString());
		
		return result;
	}
	
	/**
	 * @since 2020. 3. 31.
	 * @author leesw
	 * @description : 로그아웃 처리
	 */
	@RequestMapping(value="/logout" , method = RequestMethod.POST)
	TransResult logout(@RequestBody User user){
		TransResult result = new TransResult(true);
		
		//TODO redis에서 캐쉬삭제해서  로그아웃 처리 추가할 것
		User findUser = userComponent.getUserById(user.getId());
		if (findUser == null) {
			logger.error("로그아웃 유저가 존재하지 않습니다.");
			result.setErrorMessage("로그아웃 유저가 존재하지 않습니다.");
			result.setSuccess(false);
		} 
		return result;
	}
}
