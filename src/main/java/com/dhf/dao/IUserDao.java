package com.dhf.dao;

import java.util.List;

import com.dhf.model.User;

public interface IUserDao {
public User login(User user);
public List<User> list();
public void add(User user);
public void delete(int id);
public void update(User user);
}
