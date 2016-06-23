package com.health.service;

import com.health.model.User;
import com.health.model.UserDetails;

public interface IUserService {
	public User checkUser (User user);
	public boolean addorUpdataUser (User user);
	public User getUser (int id);
	public UserDetails getUserDetails (int id);
	public User getUser (String userName);
}
