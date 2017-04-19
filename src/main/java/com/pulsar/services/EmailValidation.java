package com.pulsar.services;import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.pulsar.util.EmailUtil;

@Configuration
public class EmailValidation {

	@Value("${pulsar.mail.smtp.user}")
	 String hostEmailId;
	
	@Value("${pulsar.mail.smtp.password}")
	 String hostEmailPassword;
	
	@Value("${pulsar.mail.smtp.host}")
	 String smtpHostServer;
	
	@Value("${pulsar.mail.smtp.port}")
	String smtpPort;
	 
	@Value("${pulsar.mail.smtp.auth}")
	String auth;
	
	@Value("${pulsar.mail.smtp.starttls.enable}")
	String ttlsEnabled;
	
	
	public boolean validateEmail(String emailId, String firstname)
	{

		    System.out.println("TLSEmail Start");
			Properties props = new Properties();
			props.put("mail.smtp.host",smtpHostServer); //SMTP Host
			props.put("mail.smtp.port", smtpPort); //TLS Port
			props.put("mail.smtp.auth", auth); //enable authentication
			props.put("mail.smtp.starttls.enable", ttlsEnabled); //enable STARTTLS
			props.put("mail.smtp.user", hostEmailId);
			props.put("mail.smtp.password", hostEmailPassword);
			
			 //create Authenticator object to pass in Session.getInstance argument
			Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(hostEmailId, hostEmailPassword);
				}
			};

		    Session session = Session.getInstance(props, auth);
		    
		    try{
		    EmailUtil.sendEmail(session, emailId,"OTP Verification", "Hi "+firstname+" This Email is for your account verification. Please do not reply.Please use the OTP at our page to verify your account");
		    
		    return true;
		    }
		    
		    catch (Exception e)
		    {
		    	return false;
		    }
		    
		    finally
		    {
		    	
		    }
	}
}
