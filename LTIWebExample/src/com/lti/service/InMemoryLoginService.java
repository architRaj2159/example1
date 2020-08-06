package com.lti.service;

import java.util.HashMap;

public class InMemoryLoginService {
	HashMap<String, String> hash = new HashMap<String,String>();
	
	public InMemoryLoginService() {
		hash.put("Archit", "2159");
		hash.put("Ankur", "1234");
		hash.put("Sarthak", "5678");
		hash.put("Mahima", "2166");
		hash.put("Tanmay", "1111");
	}

	public boolean authenticate(String uname, String pwd) {
		//if(uname.equals("Archit") && pwd.equals("123456")) {
		
		if(hash.containsKey(uname))
			if(hash.get(uname).equals(pwd)) 
				return true;
		return false;
		}
	}
