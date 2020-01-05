package com.hcl.rest.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.hcl.rest.dto.LoginRequestDto;
import com.hcl.rest.dto.LoginResponseDto;
import com.hcl.rest.entity.Persion;

@Repository
public class LoginDaoImpl implements LoginDao {
	
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

	@SuppressWarnings("unchecked")
	@Override
	public LoginResponseDto login(LoginRequestDto loginRequestDto) {
		
		List<Persion> list = getSession().createCriteria(Persion.class).list();
		//System.out.println("1");
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		for (Persion per : list) {
		//	System.out.println("2");
			if(loginRequestDto.getUserName().equalsIgnoreCase(per.getUserName()))
				if(per.getPassword().equalsIgnoreCase(loginRequestDto.getPassword()))
			{
				loginResponseDto.setStatusCode(HttpStatus.ACCEPTED.value());
				loginResponseDto.setMessage("succes");
				return loginResponseDto;
			}
				
		}
			{
				loginResponseDto.setMessage("login un success");
				loginResponseDto.setStatusCode(HttpStatus.BAD_REQUEST.value());
				return loginResponseDto;
			}
		}
		
}
