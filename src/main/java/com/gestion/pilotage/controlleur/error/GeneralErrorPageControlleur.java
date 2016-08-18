package com.gestion.pilotage.controlleur.error;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping(value = ViewName.PAGE_GENERAL_ERROR_PAGE)
public class GeneralErrorPageControlleur {

	/**
	 * Appel de la page d'index html.
	 * 
	 * @return the index.html.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getRequest(HttpServletRequest request, ModelMap model) {
		model.addAttribute("errorCode", request.getAttribute("javax.servlet.error.status_code"));
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		String errorMessage = null;
		if (throwable != null) {
			errorMessage = throwable.getMessage();
		}
		model.addAttribute("errorMessage", errorMessage);

		// Apple errorPage.html
		ModelAndView m = new ModelAndView(ViewName.VIEW_GENERAL_ERROR_PAGE);
		return m;
	}

}
