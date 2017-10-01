package br.com.MechFinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.MechFinder.Model.User;
import br.com.MechFinder.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User getById(Long id){
		return userRepository.findOne(id);
	}
	
	public List<User> getAll()
	{
		return (List<User>)userRepository.findAll();
	}
}
