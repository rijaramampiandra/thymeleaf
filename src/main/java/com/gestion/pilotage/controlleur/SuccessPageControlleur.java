package com.gestion.pilotage.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.pilotage.utils.ViewName;

/**
 * Page success.
 * 
 * @author rija.n.ramampiandra
 * 
 */
@Controller
@RequestMapping(value = ViewName.PAGE_SUCCESS_PAGE)
public class SuccessPageControlleur {

	/**
	 * Appel de la page succés.
	 * 
	 * @param map
	 *            the model.
	 * @return the success page.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getRequest(ModelMap map) {
		ModelAndView model = new ModelAndView(ViewName.PAGE_SUCCESS_PAGE);
		return model;
	}

}
