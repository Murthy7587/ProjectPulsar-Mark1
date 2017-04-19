package com.pulsar.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.pulsar.entity.User;
import com.pulsar.repository.UserRepository;

import ch.qos.logback.classic.Logger;

@Component
public class UserDataLoader {

	@Autowired
	UserRepository ur;

	
	public UserDataLoader()
	{
		
	}
	
	
	public boolean userDataLoad(String emailAddress, String firstName, String lastName, String password)
	{
		System.out.println("Saving Details for User:::"+emailAddress);
		User us = new User(firstName);
		us.setEmailAddress(emailAddress);
		us.setFirstName(firstName);
		us.setLastName(lastName);
		us.setPassword(password);
		us.setEnableFlag(false);
		try
		{
			ur.save(us);
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		}
	}

