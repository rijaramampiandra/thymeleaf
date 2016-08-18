package com.gestion.pilotage.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.pilotage.utils.ViewName;

/**
 * Page d'accueil.
 * 
 * @author rija.n.ramampiandra
 * 
 */
@Controller
@RequestMapping(value = ViewName.PAGE_RACINE)
public class Index {

	/**
	 * Appel de la page d'index html.
	 * 
	 * @return the index.html.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getRequest() {
		// Appel index.html
		ModelAndView mav = new ModelAndView(ViewName.VIEW_INDEX);
		mav.addObject(ViewName.PAGE, ViewName.PAGE_INDEX);
		return mav;
	}

}
