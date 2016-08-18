package com.gestion.pilotage.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.thymeleaf.standard.expression.Assignation;

import com.gestion.pilotage.model.User;
import com.gestion.pilotage.utils.DateUtils;

/**
 * DAO implementation.
 * 
 * @author rija.n.ramampiandra
 * 
 */
@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("User saved successfully, User Details=" + p);
	}

	@Override
	public void updateUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("User updated successfully, User Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUser() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery("from User order by id").list();
		return usersList;
	}

	@Override
	public User findUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, new Integer(id));
		logger.info("User loaded successfully, User details=" + p);
		return p;
	}

	@Override
	public void removeUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("User deleted successfully, user details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByCriteria(User criteria) {
		if (criteria == null) {
			return new ArrayList<User>();
		}

		Session session = this.sessionFactory.getCurrentSession();
		StringBuilder query = new StringBuilder("from User ");

		if (StringUtils.isNotBlank(criteria.getEmail())) {
			query.append(" where email = '" + criteria.getEmail().trim() + "'");
		}

		Query result = session.createQuery(query.toString());

		return result.list();
	}

}
