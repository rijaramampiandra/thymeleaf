package com.gestion.pilotage.controlleur.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	 * @return the index.html.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getRequest(ModelMap m) {
		// Apple errorPage.html
		ModelAndView model = new ModelAndView(ViewName.VIEW_ERROR_PAGE);
		return model;
	}

}
