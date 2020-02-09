package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RegisteredUser;
import com.example.demo.repo.RegisteredUserRepo;

@RestController
public class RegisteredUserController {
	@Autowired
	RegisteredUserRepo repo;
	
	@PostMapping("/registereduser")
	public RegisteredUser addUser(RegisteredUser reg_user) {
		repo.save(reg_user);
		return reg_user;
	}
	
	@RequestMapping("/login/{username}")
	public String login(@PathVariable("username")String username)
	{
		// repo.findByUP(username);
	//	System.out.println(repo.findByUP());
		 return username;
		 
	}
	
	@GetMapping("/registereduser")
	
	public List<RegisteredUser> getUser()
	{
		return repo.findAll();
		
	}
	
	

	@PostMapping("/getlogin")
	public Optional<RegisteredUser> getRegisteredUser(@RequestParam(value="username") String username, @RequestParam(value="password") String password)
	{
		return repo.findByUsernameAndPassword(username, password);
		//login post is working perfectly
	}
	

	
	@DeleteMapping("/registereduser/{id}")
	public String deleteRegisteredUser(@PathVariable int id)
	{
		RegisteredUser a = repo.getOne(id);
		repo.delete(a);
		return "{'msg' : 'deleted'}";
	}
}
