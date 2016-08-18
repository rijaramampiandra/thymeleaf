package com.gestion.pilotage.controlleur.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.pilotage.utils.ViewName;

/**
 * Page erreur.
 * 
 * @author rija.n.ramampiandra
 * 
 */
@Controller
@RequestMapping(value = ViewName.PAGE_ERROR_PAGE)
public class ErrorPageControlleur {

	/**
	 * Appel de la page d'index html.
	 * 
	 * @param map
	 *            the param.
	 * @return the page.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getRequest(ModelMap map) {
		// Apple errorPage.html
		ModelAndView model = new ModelAndView(ViewName.VIEW_ERROR_PAGE);
		return model;
	}

}
