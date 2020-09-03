package fr.diginamic.offi.manager;

import java.util.HashMap;
import java.util.Map;

import fr.diginamic.offi.dao.EntiteDao;
import fr.diginamic.offi.entity.Entite;

/**
 * Classe de service générique qui propose un traitement commun à un certain
 * nombre d'entités comme les catégories, les marques et les produits
 * 
 */
public abstract class EntiteService<T extends Entite> {

	/** classe */
	protected Class<T> classe;

	/** entiteDao */
	protected EntiteDao<T> entiteDao;

	/** cache mémoire */
	protected Map<String, T> cache = new HashMap<String, T>();

	/**
	 * Constructeur
	 * 
	 * @param classe    classe à traiter
	 * @param entiteDao DAO à utiliser
	 */
	public EntiteService(Class<T> classe, EntiteDao<T> entiteDao) {
		super();
		this.classe = classe;
		this.entiteDao = entiteDao;
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionEntite(T entite) {

		T entiteBase = cache.get(entite.getNom());
		if (entiteBase != null) {
			entite.setId(entiteBase.getId());
			return;
		}

		entiteBase = entiteDao.find(entite.getNom());
		if (entiteBase == null) {
			entiteDao.insert(entite);
			cache.put(entite.getNom(), entite);
		} else {
			entite.setId(entiteBase.getId());
		}
	}
}
