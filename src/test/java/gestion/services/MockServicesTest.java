package gestion.services;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gestion.pilotage.controlleur.ListUserController;
import com.gestion.pilotage.dao.UserDAO;
import com.gestion.pilotage.model.User;
import com.gestion.pilotage.service.UserServiceImpl;

public class MockServicesTest {
	private UserServiceImpl mockUserServiceImpl;
	private UserDAO mockUserDao;

	@Autowired
	private ListUserController list;

	/**
	 * setUp overrides the default, We will use it to instantiate our required
	 * objects so that we get a clean copy for each test.
	 */
	@Before
	public void setUp() {
		mockUserServiceImpl = new UserServiceImpl();
		mockUserDao = createStrictMock(UserDAO.class);
		mockUserServiceImpl.setUserDAO(mockUserDao);
	}

	/**
	 * This method will test the "rosy" scenario of passing a valid arguments
	 * and retrieveing the useraccounts.
	 */
	@Test
	public void testListUtilisateur() {
		final List<User> listUser = new ArrayList<User>();
		User user = new User();
		user.setNom("Nom");
		listUser.add(user);
		expect(mockUserDao.findAllUser()).andReturn(listUser);
		// Setup is finished need to activate the mock
		replay(mockUserDao);

		// fill in the values that you may want to return as results
		final List<User> results = mockUserServiceImpl.findAllUsers();
		Assert.assertEquals("Test mock dao", 1, results.size());
	}
}
