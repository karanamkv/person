package com.hcl.rest.service;

import com.hcl.rest.dto.LoginRequestDto;
import com.hcl.rest.dto.LoginResponseDto;

public interface LoginService {
	
	public LoginResponseDto login(LoginRequestDto loginRequestDto);

}
