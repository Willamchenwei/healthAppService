package com.health.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.dao.IUserDao;
import com.health.model.User;
import com.health.model.UserDetails;
import com.health.service.IUserService;
@Service
public class UserService implements IUserService{
	@Resource
	private IUserDao userDao;
	public User checkUser(User user) {
		return userDao.checkUser(user);
	}
	public boolean addorUpdataUser(User user) {
		return userDao.addorUpdataUser(user);
	}
	public User getUser (int id) {
		User user = userDao.getUser(id);
		return user;
	}
	public UserDetails getUserDetails (int id) {
		UserDetails userDetails = userDao.getUserDetails(id);
		return userDetails;
	}
	@Override
	public User getUser(String userName) {
		User user = userDao.getUser(userName);
		return user;
	}
}
