package com.pulsar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.springframework.stereotype.Component;

@Entity(name="FCT_USER")
public class User {

	@javax.persistence.Id
	@GeneratedValue
	private long Id;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="EMAIL_ADRESS")
	private String emailAddress;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="ENABLED")
	private boolean enableFlag;
	public boolean isEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(boolean enableFlag) {
		this.enableFlag = enableFlag;
	}
	public User(String firstname)
	{
		this.firstName=firstname;
	}
	private User ()
	{
		
	}
	public void setId(long id) {
		Id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
