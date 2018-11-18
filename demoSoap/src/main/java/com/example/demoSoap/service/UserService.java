package com.example.demoSoap.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import net.whamdani.spring_boot_soap_demo.User;;

@Service
public class UserService {

	private static final Map<String, User> users = new HashMap<>();
	
	@PostConstruct
	public void initialze() {
		
		User wildan = new User();
		wildan.setName("Wildan");
		wildan.setEmpId(1111);
		wildan.setSalary(1000000);
		
		users.put(wildan.getName(), wildan);
	}
	
	public User getUsers(String name) {
		
		return users.get(name);
	}
	
}
