package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.exception.NoDataException;
import com.service.UserService;

import jakarta.persistence.Id;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/alluser")
	public List<User> allUser() {
		return userService.AllUser();
	}

//	@GetMapping("/all")
////	@RequestMapping(value = "all", method = RequestMethod.GET)
//	public ResponseEntity<?> allUser1() throws NoDataException {
//		
//		List<User> list = userService.AllUser();
//		
//		return new ResponseEntity<>(list, HttpStatus.OK);
//	}
	
	

	@PostMapping("/add")
	public User addTask(@RequestBody User user) {
		User userr = userService.addUser(user);
		return  userr;
	}

	@PutMapping("/update")
	public User update(@RequestBody User user) {
		User userr = userService.update(user);

		return userr;
	}

	@GetMapping("/findbyid/{id}")
	public Optional findbyid(@PathVariable Long id){
		return userService.findbyid(id);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id){
		return userService.delete(id);
	}

}
