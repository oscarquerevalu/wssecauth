package com.ripley.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ripley.ws.model.Usuariosms;
import com.ripley.ws.service.OtpService;
import com.ripley.ws.service.UsuariosmsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author oquerevalu
 * Jan 16, 2018
 */
//@Controller
@RestController
@RequestMapping("/api/adminvaltok")
@Api(value = "Authadm", description = "Authadm API", produces = "application/json")
public class AdminAuthController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public OtpService otpService;
	
	@Autowired
	public UsuariosmsService usuariosmsService;

	@RequestMapping(value ="/validateOtp", method = RequestMethod.GET)
	@ApiOperation(value = "ValidacionAuth", notes = "Validación de autenticación")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Authenticado"),
	})
	public @ResponseBody String validateOtp(@RequestParam("otpnum") int otpnum,@RequestParam("id") String id){

		final String SUCCESS = "SUCCESS";

		final String FAIL = "FAIL";
		
		String  idExits =  usuariosmsService.findId(id);
		
		if(idExits == null) return FAIL;

		logger.info(" Otp Number : "+otpnum);

		//Validate the Otp 
		if(otpnum >= 0){
			int serverOtp = otpService.getOtp(id+otpnum);

			if(serverOtp > 0){
				if(otpnum == serverOtp){
					otpService.clearOTP(id);
					return SUCCESS;
				}else{
					return FAIL;
				}
			}else {
				return FAIL;
			}
		}else {
			return FAIL;
		}
	}
}
