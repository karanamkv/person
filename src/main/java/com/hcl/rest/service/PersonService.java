package com.hcl.rest.service;

import java.util.List;

import com.hcl.rest.dto.PersonRequestDto;
import com.hcl.rest.dto.PersonResponseDto;
import com.hcl.rest.entity.Persion;

public interface PersonService {
	
	public PersonResponseDto addUser(PersonRequestDto personRequestDto);
	
	public List<Persion> listPerson();
	
	public Persion getPersonById(int id);
	
	public PersonResponseDto updatePerson(Persion persion);

	public PersonResponseDto deletePersionById(int id);
}
