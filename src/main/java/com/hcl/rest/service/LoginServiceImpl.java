package com.hcl.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.rest.dao.LoginDao;
import com.hcl.rest.dto.LoginRequestDto;
import com.hcl.rest.dto.LoginResponseDto;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginDao loginDao;
	

	@Override
	public LoginResponseDto login(LoginRequestDto loginRequestDto) {
		
		return loginDao.login(loginRequestDto);
	}
	
	

}
