package com.ripley.ws.service;

//import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @author oquerevalu
 * Dec 18, 2017
 */
@Service
public class MyEmailService  {

//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	@Autowired
//	private JavaMailSender javaMailSender;
//	 
//	public void sendOtpMessage(String to, String subject, String message) {
//		 
//		 try {
//			 MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//			 MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
//			 String htmlMsg = message;
//			 mimeMessage.setContent(htmlMsg, "text/html");
//			 helper.setTo(to);
//			 helper.setSubject(subject);
////			 helper.setFrom("abc@gmail.com");
////			 javaMailSender.send(mimeMessage);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		 
//	}
}
