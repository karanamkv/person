package com.hcl.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.rest.dao.PersonDao;
import com.hcl.rest.dto.PersonRequestDto;
import com.hcl.rest.dto.PersonResponseDto;
import com.hcl.rest.entity.Persion;

@Service
public class PersionServiceImpl implements PersonService{
	
	@Autowired
	PersonDao personDao;

	@Override
	public PersonResponseDto addUser(PersonRequestDto personRequestDto) {
		return personDao.addUser(personRequestDto);
	}

	@Override
	public List<Persion> listPerson() {
		return personDao.listPerson();
	}

	@Override
	public Persion getPersonById(int id) {
		return personDao.getPersonById(id);
	}

	@Override
	public PersonResponseDto updatePerson(Persion persion) {
		return personDao.updatePerson(persion);
	}

	@Override
	public PersonResponseDto deletePersionById(int id) {
		return personDao.deletePersionById(id);
		
		
	}

}
