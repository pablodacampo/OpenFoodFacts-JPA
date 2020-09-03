package fr.diginamic.offi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.offi.entity.Entite;

/**
 * Classe mère des DAO pour les objets très simples qui n'ont que les 2 colonnes
 * suivantes: ID, NOM
 * 
 */
public abstract class EntiteDao<T extends Entite> extends AbstractDao {

	/** Classe de l'entité */
	protected Class<T> classe;

	/**
	 * Constructeur
	 * 
	 * @param em     entityManager
	 * @param classe classe
	 */
	public EntiteDao(EntityManager em, Class<T> classe) {
		super(em);
		this.classe = classe;
	}

	/**
	 * Insère une nouvelle entité en base de données
	 * 
	 * @param entite entité
	 */
	public void insert(T entite) {
		em.persist(entite);
	}

	/**
	 * Extrait une entité de la base en fonction de son nom, ou retourne null si
	 * l'additif n'existe pas.
	 * 
	 * @param nom nom de l'entité
	 * @return T
	 */
	public T find(String nom) {

		TypedQuery<T> query = em.createQuery("FROM " + classe.getSimpleName() + " WHERE nom=:nom", classe);
		query.setParameter("nom", nom);

		List<T> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}
}
