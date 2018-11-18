package com.example.demoSoap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demoSoap.service.UserService;

import net.whamdani.spring_boot_soap_demo.GetUserRequest;
import net.whamdani.spring_boot_soap_demo.GetUserResponse;

@Endpoint
public class UserEnpoint {
	
	@Autowired
	private UserService userService;
	
	@PayloadRoot(namespace = "http://whamdani.net/spring-boot-soap-demo",
			 	 localPart = "getUserRequest")
	@ResponsePayload
	public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
		
		GetUserResponse response = new GetUserResponse();
		response.setUser(userService.getUsers(request.getName()));
		
		return response;
	}
}
