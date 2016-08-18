package com.gestion.pilotage.enums;

/**
 * Choix oui ou non.
 * 
 * @author rija.n.ramampiandra
 * 
 */
public enum ChoixEnum {
	OUI(1), NON(0), NO_CHOICE(-1);
	private Integer id;

	private ChoixEnum(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}