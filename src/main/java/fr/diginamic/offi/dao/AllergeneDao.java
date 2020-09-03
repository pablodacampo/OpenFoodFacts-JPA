package fr.diginamic.offi.dao;

import javax.persistence.EntityManager;

import fr.diginamic.offi.entity.Allergene;

public class AllergeneDao extends EntiteDao<Allergene> {

	/**
	 * Constructeur
	 * 
	 * @param em entityManager
	 */
	public AllergeneDao(EntityManager em) {
		super(em, Allergene.class);
	}
}
