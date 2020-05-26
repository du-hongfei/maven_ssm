package com.dhf.service;
import java.util.List;

import com.dhf.model.User;
import com.dhf.model.UserException;

public interface IUserService {
	public User login(User user) throws UserException;
	public List<User> list();
	public void add(User user);
	public void remove(int id);
	public void update(User user);
}
