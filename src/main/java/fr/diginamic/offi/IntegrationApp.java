package fr.diginamic.offi;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.offi.entity.Produit;
import fr.diginamic.offi.io.Reader;
import fr.diginamic.offi.manager.ProduitManager;

public class IntegrationApp {

	/** LOGGER */
	private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationApp.class);

	/**
	 * Point d'entrée
	 * 
	 * @param args non utilisés ici
	 */
	public static void main(String[] args) {

		// Lecture du fichier
		Reader reader = new Reader();
		List<Produit> produits = reader.getProduits();

		// Traitement des produits
		ProduitManager produitManager = new ProduitManager();

		long a = System.currentTimeMillis();
		for (int i = 0; i < produits.size(); i++) {

			// Traitement d'un produit de la liste
			produitManager.traiteProduit(produits.get(i));

			// Tous les 100 produits on affiche le temps de traitement
			if (i % 100 == 0) {
				long b = System.currentTimeMillis();
				LOGGER.info("Nombre d'éléments traités=" + i + " - Temps de traitement=" + (b - a) + " ms");
			}
		}

		// Affichage du temps final de traitement
		long b = System.currentTimeMillis();
		LOGGER.info("Nombre d'éléments traités=" + produits.size() + " - Temps de traitement=" + (b - a) + " ms");

		// Fermeture des ressources (connexion)
		produitManager.close();
	}

}
