package fr.diginamic.offi.manager;

import javax.persistence.EntityManager;

import fr.diginamic.offi.dao.MarqueDao;
import fr.diginamic.offi.entity.Marque;

public class MarqueService extends EntiteService<Marque> {

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public MarqueService(EntityManager em) {
		super(Marque.class, new MarqueDao(em));
	}

}
