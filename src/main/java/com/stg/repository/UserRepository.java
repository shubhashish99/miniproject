package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public abstract User findByUserNameAndUserPassword(String userName, String userPassword);

}
