package com.hcl.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.rest.dto.PersonRequestDto;
import com.hcl.rest.dto.PersonResponseDto;
import com.hcl.rest.entity.Persion;
import com.hcl.rest.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {
	@Autowired
	PersonService persionService;
	
	@RequestMapping(value = "/welcome",method = RequestMethod.POST)
	public String welcome() {
		return "welcome";
	}
	@RequestMapping(value = "/PersonController/addUser",method = RequestMethod.POST)
	public PersonResponseDto addUser(PersonRequestDto personRequestDto) {
		return persionService.addUser(personRequestDto);
	}
	@RequestMapping(value = "/PersonController/listperson", method = RequestMethod.GET)
	public List<Persion> listPerson(){
		return persionService.listPerson();
	}
	
	@RequestMapping(value = "/PersonController/persionById", method = RequestMethod.GET)
	public Persion getPersonById(int id) {
		return persionService.getPersonById(id);
	}
	
	@RequestMapping(value = "/PersonController/updateperson", method = RequestMethod.PUT)
	public PersonResponseDto updatePerson(Persion persion) {
		return persionService.updatePerson(persion);
	}
	
	@RequestMapping(value = "/PersonController/deletePersionById", method = RequestMethod.DELETE)
	public PersonResponseDto deletePersionById(int id ) {
		return persionService.deletePersionById(id);
		
	}

	
}
