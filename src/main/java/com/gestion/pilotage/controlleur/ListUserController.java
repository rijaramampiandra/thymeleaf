package com.gestion.pilotage.controlleur;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.pilotage.dao.UserDAOImpl;
import com.gestion.pilotage.model.User;
import com.gestion.pilotage.service.UserService;
import com.gestion.pilotage.utils.ViewName;

@Controller
@RequestMapping(value = ViewName.PAGE_LISTE_DEVELOPPEUR)
public class ListUserController {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired(required = true)
	@Qualifier(value = "userService")
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getRequest() {
		logger.info("Appel liste des clients!");

		ModelAndView map = new ModelAndView();
		map.setViewName(ViewName.PAGE_LISTE_DEVELOPPEUR);

		List<User> list = userService.findAllUsers();
		map.addObject("listUser", list);
		// Utiliser sur le header
		map.addObject(ViewName.PAGE, ViewName.PAGE_LISTE_DEVELOPPEUR);

		return map;
	}

}