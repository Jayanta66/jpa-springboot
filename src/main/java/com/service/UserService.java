package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;

import jakarta.persistence.Id;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> AllUser(){
		
		return userRepository.findAll();
		
	}
	
	
	public User addUser(User user) {
		return userRepository.save(user);
}


	public User update(User user) {
		return userRepository.save(user);
	}
	
	public String delete(Long id) {
		Optional user=userRepository.findById(id);
		if(user.isPresent()) {
			userRepository.delete((User) user.get());
			return "Deleted";
		}
		else
		return "Deleted";
	}

}
	