package com.pulsar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pulsar.repository.UserRepository;
@Configuration
public class UserValidation {
	
	@Autowired
	private UserRepository ur;
	
	public UserValidation ()
	{
		
	}
	
	
	public int getUserExistance(String emailAddress)
	{
		System.out.println("EmailAddress::"+emailAddress);
		System.out.println("UR:::"+ur);
		return ur.countByemailAddress(emailAddress);
	}

}
