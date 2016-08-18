package com.gestion.pilotage.controlleur.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.pilotage.utils.ViewName;

/**
 * Page erreur general Java.
 * 
 * @author rija.n.ramampiandra
 * 
 */
@Controller
@RequestMapping(value = ViewName.PAGE__ERROR_THROWABLE_PAGE)
public class ErrorThrowablePageControlleur {

	/**
	 * Appel de la page d'index html.
	 * 
	 * @param request
	 *            the req.
	 * @param model
	 *            the model.
	 * @return the page.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getRequest(HttpServletRequest request, ModelMap model) {
		model.addAttribute("errorCode", "Erreur Java.");
		model.addAttribute("errorMessage", "Erreur code Java");

		// Apple errorPage.html
		ModelAndView m = new ModelAndView(ViewName.VIEW_GENERAL_ERROR_PAGE);
		return m;
	}

}
