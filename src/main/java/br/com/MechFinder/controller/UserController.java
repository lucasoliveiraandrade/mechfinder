package br.com.MechFinder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String test(){
		
		return "test ok";
	}
}
