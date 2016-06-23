package com.health.dao;

import com.health.model.User;
import com.health.model.UserDetails;

public interface IUserDao {
	public User checkUser (User user);
	public boolean addorUpdataUser (User user);
	public User getUser (int id);
	public UserDetails getUserDetails (int id);
	public User getUser (String userName);
}
