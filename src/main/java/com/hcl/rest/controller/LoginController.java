package com.hcl.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.rest.dto.LoginRequestDto;
import com.hcl.rest.dto.LoginResponseDto;
import com.hcl.rest.service.LoginService;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired 
	LoginService loginService;
	
	@RequestMapping(value = "/LoginController/login", method = RequestMethod.POST)
	public LoginResponseDto login(LoginRequestDto loginRequestDto) {
		return loginService.login(loginRequestDto);
		
	}

}
