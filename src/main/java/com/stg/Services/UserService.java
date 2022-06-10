package com.stg.Services;

import com.stg.entity.User;

public interface UserService {

	public abstract User loginUser(String userName, String userPassword); // validation

	public abstract User createUser(User user); // create

}
