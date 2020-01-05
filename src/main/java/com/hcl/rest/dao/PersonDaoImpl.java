package com.hcl.rest.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.hcl.rest.dto.PersonRequestDto;
import com.hcl.rest.dto.PersonResponseDto;
import com.hcl.rest.entity.Persion;

@Repository
public class PersonDaoImpl  implements  PersonDao{
	
	private static final Logger logger=LoggerFactory.getLogger(PersonDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession() {
		Session session=null;
		try {
			
			session=sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session=sessionFactory.openSession();
		}
		return session;
	}
	@Transactional
	public PersonResponseDto addUser(PersonRequestDto personRequestDto) {
		logger.info("inside add user method");
		
		Persion persion=new Persion();
		BeanUtils.copyProperties(personRequestDto, persion);
		getSession().save(persion);
		logger.info("person added successfully");
		PersonResponseDto personResponseDto=new PersonResponseDto();
		personResponseDto.setMessage("person added successfully");
		personResponseDto.setStatusCode(HttpStatus.OK.value());
		
		return personResponseDto;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Persion> listPerson() {
		List<Persion> personList=getSession().createCriteria(Persion.class).list();
		return personList;
	}
	@Transactional
	public Persion getPersonById(int id) {
		Persion persion=(Persion) getSession().get(Persion.class, id);
		return persion;
	}
	@Transactional
	public PersonResponseDto updatePerson(Persion persion) {
		getSession().update(persion);
		logger.info("person updated successfully");
		PersonResponseDto personResponseDto=new PersonResponseDto();
		personResponseDto.setMessage("persion updated successfully");
		personResponseDto.setStatusCode(HttpStatus.OK.value());
		return personResponseDto;
	}
	@Transactional
	public PersonResponseDto deletePersionById(int id) {
		Persion persion=(Persion) getSession().load(Persion.class, id);
		/*
		 * if(null!=persion) { getSession().delete(persion); }
		 */
		
		if(persion.getId() == id) {
			getSession().delete(persion);
			PersonResponseDto personResponseDto=new PersonResponseDto();
			personResponseDto.setMessage("person deleted successfully");
			personResponseDto.setStatusCode(HttpStatus.OK.value());
			return personResponseDto;
		}
		PersonResponseDto personResponseDto=new PersonResponseDto();
		personResponseDto.setMessage("person not found");
		personResponseDto.setStatusCode(HttpStatus.NO_CONTENT.value());
		return personResponseDto;
	}

}
