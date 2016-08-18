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
	 * @param p
	 */
	public void addUser(User p);

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
	 * @param id
	 *            the id.
	 * @return the user.
	 */
	List<User> findByCriteria(User criteria);
}
