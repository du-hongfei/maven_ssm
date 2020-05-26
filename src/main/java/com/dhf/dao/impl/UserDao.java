package com.dhf.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.dhf.dao.IUserDao;
import com.dhf.model.User;

@Repository("userDao")
public class UserDao extends SqlSessionDaoSupport implements IUserDao{

	@Override
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory SessionFactory) {
		
		super.setSqlSessionFactory(SessionFactory);
	}
	@Override
	public User login(User user) {
		return getSqlSession().getMapper(IUserDao.class).login(user);
	}

	@Override
	public List<User> list() {
		return getSqlSession().getMapper(IUserDao.class).list();
	}
	@Override
	public void add(User user) {
		
		getSqlSession().getMapper(IUserDao.class).add(user);
	}
	@Override
	public void delete(int id) {
		getSqlSession().getMapper(IUserDao.class).delete(id);
	}
	@Override
	public void update(User user) {
		getSqlSession().getMapper(IUserDao.class).update(user);
	}


}
