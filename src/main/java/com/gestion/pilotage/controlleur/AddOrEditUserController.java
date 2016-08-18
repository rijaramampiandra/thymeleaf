package com.gestion.pilotage.controlleur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.pilotage.dao.UserDAOImpl;
import com.gestion.pilotage.enums.ChoixEnum;
import com.gestion.pilotage.model.User;
import com.gestion.pilotage.service.UserService;
import com.gestion.pilotage.utils.EncryptionPasswordUtils;
import com.gestion.pilotage.utils.VerifyUtils;
import com.gestion.pilotage.utils.ViewName;
import com.gestion.pilotage.validator.InputValidator;

/**
 * Cette controlleur permet de gerer la mise a jour des user.
 * 
 * @author rija.n.ramampiandra
 * 
 */
@Controller
@RequestMapping(value = ViewName.PAGE_ADD_OR_EDIT_DEVELOPPEUR)
public class AddOrEditUserController {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired(required = true)
	@Qualifier(value = "userService")
	private UserService userService;

	@RequestMapping(value = ViewName.SHOW_ADD_VIEW, method = RequestMethod.GET)
	public ModelAndView ajouterUser() {

		ModelAndView model = new ModelAndView();
		model.setViewName(ViewName.PAGE_ADD_OR_EDIT_DEVELOPPEUR);
		User dev = new User();
		// dev.setType(new Type("Java", 1));
		dev.setDate(new Date());

		model.addObject("user", dev);
		model.addObject(ViewName.PAGE, ViewName.PAGE_ADD_OR_EDIT_DEVELOPPEUR);
		model.addObject("add", true);

		return model;
	}

	@RequestMapping(value = ViewName.ADD_TO_DB, method = RequestMethod.POST)
	public ModelAndView ajouterUserToDb(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user, ModelMap model) {

		if (StringUtils.isBlank(user.getNom())) {
			return generateViewError(user, "errorNom", "Nom obligatoire!");
		}

		user.setNom(user.getNom().trim());

		if (user.getNom().length() > 100) {
			logger.error("Nom trop longue (maximum 100 caractères)!");
			return generateViewError(user, "errorNom", "Nom trop longue (maximum 100 caractères)!");
		}

		if (!StringUtils.isBlank(user.getPrenom()) && user.getNom().length() > 100) {
			logger.error("Préom(s) trop longue (maximum 100 caractères)!");
			return generateViewError(user, "errorPrenom", "Prénom(s) trop longue (maximum 100 caractères)!");
		}

		if (StringUtils.isBlank(user.getPassword())) {
			logger.error("Mot de passe vide!");
			return generateViewError(user, "errorPassword", "Mot de passe obligatoire!");
		}

		user.setPassword(user.getPassword().trim());
		if (!InputValidator.validatePassword(user.getPassword())) {
			logger.error("Mot de passe érroné!");
			return generateViewError(user, "errorPassword", "Le mot de passe doit contenir : <br />" + "<ul>"
					+ "<li>Au moins un chiffre</li>" + "<li>Au moins un caractère en minuscule.</li>"
					+ "<li>Au moins un caractère en majuscule.</li>"
					+ "<li>Au moins un caractère spéciaux (@#$%!).</li>"
					+ "<li>Minimum 6 caractères et maximum 20 caractères.</li>" + "</ul>");
		}

		if (StringUtils.isBlank(user.getEmail())) {
			logger.error("Email obligatoire!");
			return generateViewError(user, "errorEmail", "Email obligatoire");
		}

		user.setEmail(user.getEmail().trim());

		boolean validEmail = InputValidator.validateEmail(user.getEmail());
		if (!validEmail) {
			logger.error("Email invalide!");
			return generateViewError(user, "errorEmail", "Email invalide!");
		}

		User dev = new User();
		dev.setEmail(user.getEmail());
		List<User> list = userService.findByCriteria(dev);
		if (list != null && list.size() > 0) {
			logger.error("Email déjà éxistant!");
			return generateViewError(user, "errorEmail", "Email déjà éxistant!");
		}

		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		logger.error(gRecaptchaResponse);
		// Verify CAPTCHA.
		boolean valid = VerifyUtils.verify(gRecaptchaResponse);
		if (!valid) {
			logger.error("Captcha invalide!");
			return generateViewError(user, "errorCaptcha", "Captcha invalide!");
		}

		user.setDate(new Date());
		user.setActif(0);
		String passWordCrypted = user.getPassword();
		try {
			passWordCrypted = EncryptionPasswordUtils.cryptedPassword(user.getPassword());
		} catch (Exception e) {
			logger.error("Erreur sur cryptage de mot de passe!");
		}
		user.setPassword(passWordCrypted);

		if (user.getNom() != null) {
			user.setNom(user.getNom().toUpperCase());
		}
		userService.addUser(user);
		logger.info("Insertion avec succès!" + user);

		ModelAndView map = new ModelAndView();
		map.setViewName(ViewName.PAGE_SUCCESS_PAGE);
		return map;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam(value = "id", required = false) String id) {
		if (StringUtils.isBlank(id)) {
			ModelAndView model = new ModelAndView(ViewName.VIEW_ERROR_PAGE);
			model.addObject("errorMessage", "Dévelopeur obligatoire.");
			model.addObject(ViewName.PAGE, ViewName.VIEW_ERROR_PAGE);
			model.addObject("edit", true);

			return model;

		}

		ModelAndView model = new ModelAndView(ViewName.PAGE_ADD_OR_EDIT_DEVELOPPEUR);
		model.addObject("msg", id);
		int idInt = Integer.valueOf(id);
		User user = userService.findUserById(idInt);
		model.addObject("user", user);
		// Utiliser sur le header
		model.addObject(ViewName.PAGE, ViewName.PAGE_ADD_OR_EDIT_DEVELOPPEUR);
		model.addObject("edit", true);

		return model;
	}

	@RequestMapping(value = ViewName.SAVE_TO_DB, method = RequestMethod.POST)
	public String saveUserToDB(@ModelAttribute("user") User user, ModelMap model) {
		if (user.getNom() != null) {
			user.setNom(user.getNom().toUpperCase());
		}
		User userDb = userService.findUserById(user.getId());
		user.setPassword(userDb.getPassword());
		userService.updateUser(user);

		return "redirect:" + ViewName.PAGE_LISTE_DEVELOPPEUR;
	}

	private ModelAndView generateViewError(User user, String errorName, String errorMessage) {

		ModelAndView modelToReturn = new ModelAndView();
		modelToReturn.setViewName(ViewName.PAGE_ADD_OR_EDIT_DEVELOPPEUR);

		modelToReturn.addObject("user", user);
		modelToReturn.addObject(ViewName.PAGE, ViewName.PAGE_ADD_OR_EDIT_DEVELOPPEUR);
		modelToReturn.addObject(errorName, true);
		modelToReturn.addObject("error", errorMessage);
		modelToReturn.addObject("add", true);
		return modelToReturn;
	}

	@ModelAttribute(ViewName.CHOICE_ACTIF_OR_NOT)
	public List<Integer> listeChoixOuiOuNon() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(ChoixEnum.NON.getId());
		list.add(ChoixEnum.OUI.getId());
		return list;
	}
}