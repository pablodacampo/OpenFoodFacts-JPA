package fr.diginamic.offi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.offi.entity.Marque;
import fr.diginamic.offi.entity.Produit;

public class ProduitDao extends EntiteDao<Produit> {

	/**
	 * Constructeur
	 * 
	 * @param em entity Manager
	 */
	public ProduitDao(EntityManager em) {
		super(em, Produit.class);
	}

	/**
	 * Recherche un produit en fonction de son nom et pour une marque donnée
	 * 
	 * @param nom    nom du produit
	 * @param marque marque
	 * @return {@link Produit}
	 */
	public Produit find(String nom, Marque marque) {
		TypedQuery<Produit> query = em.createQuery("FROM Produit WHERE nom=:nom AND marque=:marque", classe);
		query.setParameter("nom", nom);
		query.setParameter("marque", marque);

		List<Produit> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}
}
