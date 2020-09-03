package fr.diginamic.offi.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.offi.entity.Additif;
import fr.diginamic.offi.entity.Allergene;
import fr.diginamic.offi.entity.Ingredient;
import fr.diginamic.offi.entity.Produit;

public class ProduitManager {

	/** LOGGER */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProduitManager.class);

	/** EntityManager Hibernate */
	private EntityManager em;
	/** categorieService */
	private CategorieService categorieService;
	/** marqueService */
	private MarqueService marqueService;
	/** produitService */
	private ProduitService produitService;

	/** additifService */
	private AdditifService additifService;
	/** allergeneService */
	private AllergeneService allergeneService;
	/** ingredientService */
	private IngredientService ingredientService;

	/**
	 * Constructeur
	 * 
	 */
	public ProduitManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("openfoodfacts");
		em = entityManagerFactory.createEntityManager();

		categorieService = new CategorieService(em);
		marqueService = new MarqueService(em);
		produitService = new ProduitService(em);

		additifService = new AdditifService(em);
		allergeneService = new AllergeneService(em);
		ingredientService = new IngredientService(em);
	}

	/**
	 * Traite un produit: gère la totalité de la persistance du produit et de toutes
	 * ses données associées
	 * 
	 * @param produit produit à insérer en base de données.
	 */
	public void traiteProduit(Produit produit) {

		LOGGER.debug("Produit" + produit.getNom());

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		categorieService.insertionEntite(produit.getCategorie());
		marqueService.insertionEntite(produit.getMarque());

		for (Additif additif : produit.getAdditifs()) {
			additifService.insertionEntite(additif);
		}

		for (Allergene allergene : produit.getAllergenes()) {
			allergeneService.insertionEntite(allergene);
		}

		for (Ingredient ingredient : produit.getIngredients()) {
			ingredientService.insertionEntite(ingredient);
		}

		produitService.insertionEntite(produit);

		transaction.commit();
	}

	/**
	 * Fermeture des ressources ouvertes par la classe
	 */
	public void close() {
		em.close();
	}
}
