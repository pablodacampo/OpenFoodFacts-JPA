package fr.diginamic.offi.manager;

import javax.persistence.EntityManager;

import fr.diginamic.offi.dao.ProduitDao;
import fr.diginamic.offi.entity.Produit;

public class ProduitService {

	/** produitDao */
	private ProduitDao produitDao;

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public ProduitService(EntityManager em) {
		this.produitDao = new ProduitDao(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionEntite(Produit entite) {
		Produit entiteBase = produitDao.find(entite.getNom(), entite.getMarque());
		if (entiteBase != null) {
			return;
		}
		produitDao.insert(entite);
	}

}
