package com.gestion.pilotage.utils;

/**
 * Constant utiliser par l'application.
 * 
 * @author rija.n.ramampiandra
 * 
 */
public interface ViewName {

	/**
	 * page edit user.
	 */
	String PAGE_ADD_OR_EDIT_DEVELOPPEUR = "/userAddOrEdit";

	/**
	 * Page user.
	 */
	String PAGE_LISTE_DEVELOPPEUR = "/userListe";

	/**
	 * Choix
	 * <ul>
	 * <li>OUI</li>
	 * <li>NON</li>
	 * </ul>
	 */
	String CHOICE_ACTIF_OR_NOT = "choixActifOuNon";

	/**
	 * Appel fichier errorPage.html.
	 */
	String PAGE_SUCCESS_PAGE = "/inscriptionSuccess";

	/**
	 * Page racine.
	 */
	String PAGE_RACINE = "/";

	/**
	 * Page index.
	 */
	String PAGE_INDEX = "/index";

	/**
	 * Page.
	 */
	String PAGE = "page";

	/**
	 * Page erreur custom.
	 */
	String PAGE_ERROR_PAGE = "errorPage";

	/**
	 * Page erreur general.
	 */
	String PAGE_GENERAL_ERROR_PAGE = "generalErrorPage";

	/**
	 * Page erreur Java.
	 * <ul>
	 * <li>NumberFormatException.java</li>
	 * </ul>
	 */
	String PAGE__ERROR_THROWABLE_PAGE = "errorThrowable";

	/**
	 * Appel fichier index.html.
	 */
	String VIEW_INDEX = "index";

	/**
	 * Appel fichier errorPage.html.
	 */
	String VIEW_ERROR_PAGE = "error/errorPage";

	/**
	 * Appel fichier error/general-error.html.
	 */
	String VIEW_GENERAL_ERROR_PAGE = "error/general-error";

	/**
	 * Afficher la vue ajout.
	 */
	String SHOW_ADD_VIEW = "/ajouter";

	/**
	 * Ajout action dans le DB.
	 */
	String ADD_TO_DB = "/addAction";

	/**
	 * Sauvegarder les données dans la base de données.
	 */
	String SAVE_TO_DB = "/saveedit";
}
