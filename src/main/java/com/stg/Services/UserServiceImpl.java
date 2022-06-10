package com.stg.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.Exception.CustomException;
import com.stg.entity.User;
import com.stg.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User loginUser(String userName, String userPassword) {

		User users = userRepository.findByUserNameAndUserPassword(userName, userPassword);

		if (users == null) {
			throw new CustomException("Invalid User credentials");
		} else {
			return users;
		}
	}

	@Override
	public User createUser(User user) {

		return userRepository.save(user);
	}

}
