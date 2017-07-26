package com.apex.user.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.apex.user.hibernateutil.HibernateUtil;
import com.apex.user.service.vo.UserVO;


@Path("/user")
public class UserResource {
	@GET
	@Path("/{user_firstName}/{user_middleName}/{user_lastName}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public UserVO getUser(@PathParam("user_firstName") String firstName, @PathParam("user_middleName") String middleName, @PathParam("user_lastName") String lastName){
		System.out.println("Entering into method");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		System.out.println("Successfully created ");		
		UserVO uservo = new UserVO();
		
		uservo.setFirstName(firstName);
		uservo.setMiddleName(middleName);
		uservo.setLastName(lastName);
		System.out.println("check1");
		session.save(uservo);
		System.out.println("check2");
		session.getTransaction().commit();
		session.close();
		return uservo;
	}
}

