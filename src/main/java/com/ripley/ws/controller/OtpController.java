package com.ripley.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ripley.ws.entity.OtpBean;
import com.ripley.ws.service.OtpService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author oquerevalu
 * Jan 16, 2018
 */
@RestController
@RequestMapping("/api/auth")
@Api(value = "Auth", description = "Auth API", produces = "application/json")
public class OtpController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public OtpService otpService;
	
	//	@Autowired
	//	public MyEmailService myEmailService;

	@RequestMapping(value ="/generateOtp", method = RequestMethod.GET)
	@ApiOperation(value = "generaToken", notes = "Generación de token")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Token generado"),
	})
	public ResponseEntity<OtpBean> generateOtp(@RequestParam("id") String id){

//		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
//		String username = auth.getName();

		int otp = otpService.generateOTP(id);

		logger.info("OTP : "+otp);

		//Generate The Template to send OTP 
//		EmailTemplate template = new EmailTemplate("SendOtp.html");

//		Map<String,String> replacements = new HashMap<String,String>();
//		replacements.put("user", username);
//		replacements.put("otpnum", String.valueOf(otp));

//		String message = template.getTemplate(replacements);

		//		myEmailService.sendOtpMessage("oscarquerevalu@gmail.com", "OTP -SpringBoot", message);
		
//		SecurityContextHolder.clearContext();

		return new ResponseEntity<OtpBean>(new OtpBean(otp,id), HttpStatus.OK);
	}

}
