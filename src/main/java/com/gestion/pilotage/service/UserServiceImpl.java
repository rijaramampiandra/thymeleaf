package com.gestion.pilotage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.pilotage.dao.UserDAO;
import com.gestion.pilotage.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Autowired(required = true)
	@Qualifier(value = "userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public void addUser(User p) {
		this.userDAO.addUser(p);
	}

	@Override
	@Transactional
	public void updateUser(User p) {
		this.userDAO.updateUser(p);
	}

	@Override
	@Transactional
	public List<User> findAllUsers() {
		return this.userDAO.findAllUser();
	}

	@Override
	@Transactional
	public User findUserById(int id) {
		return this.userDAO.findUserById(id);
	}

	@Override
	@Transactional
	public void removeUser(int id) {
		this.userDAO.removeUser(id);
	}

	@Override
	@Transactional
	public List<User> findByCriteria(User criteria) {
		return this.userDAO.findByCriteria(criteria);
	}

}
