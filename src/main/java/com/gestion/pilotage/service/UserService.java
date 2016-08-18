package com.gestion.pilotage.service;

import java.util.List;

import com.gestion.pilotage.model.User;

/**
 * Service to manage user.
 * 
 * @author rija.n.ramampiandra
 * 
 */
public interface UserService {

	/**
	 * Add user to DB.
	 * 
	 * @param p
	 *            the user.
	 */
	public void addUser(User p);

	/**
	 * Maj user.
	 * 
	 * @param p
	 *            the user.
	 * 
	 */
	public void updateUser(User p);

	/**
	 * Liste des users.
	 * 
	 * @return the list.
	 */
	public List<User> findAllUsers();

	/**
	 * Get user by id.
	 * 
	 * @param id
	 *            the id.
	 * @return the user.
	 */
	public User findUserById(int id);

	/**
	 * Removo user.
	 * 
	 * @param id
	 *            the id.
	 */
	public void removeUser(int id);

	/**
	 * Obtenir le client.
	 * 
	 * @param id
	 *            the id.
	 * @return the user.
	 */
	List<User> findByCriteria(User criteria);

}
