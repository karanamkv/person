package com.hcl.rest.dao;

import com.hcl.rest.dto.LoginRequestDto;
import com.hcl.rest.dto.LoginResponseDto;

public interface LoginDao {
	public LoginResponseDto login(LoginRequestDto loginRequestDto);

}
