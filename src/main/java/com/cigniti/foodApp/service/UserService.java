package com.cigniti.foodApp.service;

import java.util.List;

import com.cigniti.foodApp.entity.User;

public interface UserService {

	

	public List<User> findAll();

	public void save(User user);

	public User findByUserId(int id);

	public void deleteByUserId(int id);

}
