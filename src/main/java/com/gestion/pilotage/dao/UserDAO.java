package com.gestion.pilotage.dao;

import java.util.List;

import com.gestion.pilotage.model.User;

/**
 * Acces to DB to manage user.
 * 
 * @author rija.n.ramampiandra
 * 
 */
public interface UserDAO {

	/**
	 * Ajout user.
	 * 
	 * @param user
	 *            the user.
	 */
	public void addUser(User user);

	/**
	 * Maj user.
	 * 
	 * @param p
	 *            the user.
	 */
	public void updateUser(User p);

	/**
	 * Liste user.
	 * 
	 * @return the list.
	 */
	public List<User> findAllUser();

	/**
	 * Obtenir la userne par ID.
	 * 
	 * @param id
	 *            the id.
	 * @return the user.
	 */
	public User findUserById(int id);

	/**
	 * Delete user.
	 * 
	 * @param id
	 *            the id.
	 */
	public void removeUser(int id);

	/**
	 * Obtenir le client.
	 * 
	 * @param criteria
	 *            the criteria.
	 * @return the user.
	 */
	List<User> findByCriteria(User criteria);
}
