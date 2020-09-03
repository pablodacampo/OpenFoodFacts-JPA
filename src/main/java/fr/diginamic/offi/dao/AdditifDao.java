package fr.diginamic.offi.dao;

import javax.persistence.EntityManager;

import fr.diginamic.offi.entity.Additif;

public class AdditifDao extends EntiteDao<Additif> {

	/**
	 * Constructeur
	 * 
	 * @param em entityManager
	 */
	public AdditifDao(EntityManager em) {
		super(em, Additif.class);
	}
}
