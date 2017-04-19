package com.pulsar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pulsar.entity.User;
import com.pulsar.loader.UserDataLoader;
import com.pulsar.repository.UserRepository;
import com.pulsar.services.EmailValidation;
import com.pulsar.services.UserValidation;

@RestController
@RequestMapping("/")
public class StartupController {

	@Autowired
	EmailValidation ev;
	@Autowired
	UserValidation uv;
	@Autowired
	UserDataLoader ul;

	@RequestMapping("/")
	public ModelAndView redirect (ModelMap model)
	{
		
		 return new ModelAndView("redirect:/login.html",model);
	}
	
	@Secured("ROLE_USER")
	@RequestMapping("/logincheck")
	public ModelAndView login (ModelMap model)
	{
		
		 return new ModelAndView("redirect:/Welcome.html",model);
	}
	
	@Secured("ROLE_USER")
	@RequestMapping("/newUser")
	public ModelAndView addUser (ModelMap model,@RequestParam("emailAddress") String emailAddress, 
								@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, 
								@RequestParam("password") String password)
	{
		System.out.println("emailAddress::::"+emailAddress);
		
		int exsist = uv.getUserExistance(emailAddress);
		System.out.println("Exsist::"+exsist);
		
		if (exsist > 0)
		{
			System.out.println("User Exsists!!");
			return new ModelAndView("redirect:/Welcome.html",model);
		}
		else
		{
			if (ul.userDataLoad(emailAddress, firstName, lastName, password))
			{
				boolean succesFlag = ev.validateEmail(emailAddress,firstName);
				if (succesFlag)
				{
					return new ModelAndView("redirect:/Welcome.html",model);
				}
				else
				{	
					return new ModelAndView("redirect:/Welcome.html",model);
				}
			}
			else
			{
				System.out.println("Insode the seepost:::");
				return new ModelAndView("redirect:/Welcome.html",model);
			}
		}	
	}
}
