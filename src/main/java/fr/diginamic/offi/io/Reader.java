package fr.diginamic.offi.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.apache.commons.io.FileUtils;

import fr.diginamic.offi.config.Constantes;
import fr.diginamic.offi.entity.Additif;
import fr.diginamic.offi.entity.Allergene;
import fr.diginamic.offi.entity.Categorie;
import fr.diginamic.offi.entity.Ingredient;
import fr.diginamic.offi.entity.Marque;
import fr.diginamic.offi.entity.Produit;
import fr.diginamic.offi.exception.ExceptionTech;
import fr.diginamic.offi.utils.Convertisseur;
import fr.diginamic.offi.utils.StringUtils;

public class Reader {

	/**
	 * Retourne la liste des produits stockées dans le fichier CSV
	 * 
	 * @return
	 */
	public List<Produit> getProduits() {

		// Lecture du fichier CSV
		List<String> lignes = null;
		try {
			lignes = FileUtils.readLines(new File(Constantes.CONF.getFileUrl()), "UTF-8");
		} catch (IOException e) {
			throw new ExceptionTech("Fichier " + Constantes.CONF.getFileUrl() + " introuvable.");
		}

		// On supprime la ligne d'entête
		lignes.remove(0);

		// On traite toutes les lignes 1 par 1
		final ArrayList<Produit> produits = new ArrayList<Produit>();
		lignes.forEach(new Consumer<String>() {
			public void accept(String ligne) {
				produits.add(tranformeLigneEnProduit(ligne));
			}
		});
		return produits;
	}

	/**
	 * Transforme une ligne du fichier en un Produit
	 * 
	 * @param ligne ligne
	 * @return Produit
	 */
	private Produit tranformeLigneEnProduit(String ligne) {
		String[] morceaux = ligne.split("\\|", -1);

		// System.out.println(nbMorceaux);

		String nomCategorie = morceaux[0];
		String nomMarque = morceaux[1];
		String nomProduit = morceaux[2];
		String nutritionGradeFr = morceaux[3];

		String ingredientsStr = morceaux[4];

		Double energie100g = Convertisseur.toDouble(morceaux[5]);
		Double graisse100g = Convertisseur.toDouble(morceaux[6]);
		Double sucres100g = Convertisseur.toDouble(morceaux[7]);
		Double fibres100g = Convertisseur.toDouble(morceaux[8]);
		Double proteines100g = Convertisseur.toDouble(morceaux[9]);
		Double sel100g = Convertisseur.toDouble(morceaux[10]);
		Double vitA100g = Convertisseur.toDouble(morceaux[11]);
		Double vitD100g = Convertisseur.toDouble(morceaux[12]);
		Double vitE100g = Convertisseur.toDouble(morceaux[13]);
		Double vitK100g = Convertisseur.toDouble(morceaux[14]);
		Double vitC100g = Convertisseur.toDouble(morceaux[15]);
		Double vitB1100g = Convertisseur.toDouble(morceaux[16]);
		Double vitB2100g = Convertisseur.toDouble(morceaux[17]);
		Double vitPP100g = Convertisseur.toDouble(morceaux[18]);
		Double vitB6100g = Convertisseur.toDouble(morceaux[19]);
		Double vitB9100g = Convertisseur.toDouble(morceaux[20]);
		Double vitB12100g = Convertisseur.toDouble(morceaux[21]);
		Double calcium100g = Convertisseur.toDouble(morceaux[22]);
		Double magnesium100g = Convertisseur.toDouble(morceaux[23]);
		Double iron100g = Convertisseur.toDouble(morceaux[24]);
		Double fer100g = Convertisseur.toDouble(morceaux[25]);
		Double betaCarotene100g = Convertisseur.toDouble(morceaux[26]);
		String presenceHuilePalme = morceaux[27];
		String allergenesStr = morceaux[28];
		String additifStr = morceaux[29];

		Categorie categorie = new Categorie(nomCategorie);
		Marque marque = new Marque(nomMarque);

		Produit produit = new Produit(nomProduit);
		produit.setCategorie(categorie);
		produit.setMarque(marque);

		produit.setGrade(nutritionGradeFr);
		produit.setIngredients(tranformeChaineEnIngredients(ingredientsStr));
		produit.setAdditifs(tranformeChaineEnAdditifs(additifStr));
		produit.setAllergenes(transformeChaineEnAllergenes(allergenesStr));

		produit.setBetaCarotene100g(betaCarotene100g);
		produit.setCalcium100g(calcium100g);
		produit.setEnergie100g(energie100g);
		produit.setFer100g(fer100g);
		produit.setFibres100g(fibres100g);
		produit.setGraisse100g(graisse100g);
		produit.setIron100g(iron100g);
		produit.setMagnesium100g(magnesium100g);
		produit.setPresenceHuilePalme(presenceHuilePalme);
		produit.setProteines100g(proteines100g);
		produit.setSel100g(sel100g);
		produit.setSucres100g(sucres100g);
		produit.setVitA100g(vitA100g);
		produit.setVitB1100g(vitB1100g);
		produit.setVitB12100g(vitB12100g);
		produit.setVitB2100g(vitB2100g);
		produit.setVitB6100g(vitB6100g);
		produit.setVitB9100g(vitB9100g);
		produit.setVitC100g(vitC100g);
		produit.setVitD100g(vitD100g);
		produit.setVitE100g(vitE100g);
		produit.setVitK100g(vitK100g);
		produit.setVitPP100g(vitPP100g);

		return produit;
	}

	/**
	 * Transforme une chaine de caractères contenant tous les ingrédients en liste
	 * d'ingrédients. Cette méthode applique avant le découpage un ensemble de
	 * traitements afin de supprimer de la chaine les données indésirables.
	 * 
	 * @param chaine chaine contenant la liste d'ingrédients.
	 * @return List de Ingredient
	 */
	private Set<Ingredient> tranformeChaineEnIngredients(String chaine) {

		List<String> morceaux = StringUtils.splitChaine(chaine);
		final Set<Ingredient> ingredients = new HashSet<Ingredient>();
		morceaux.forEach(new Consumer<String>() {
			public void accept(String nom) {
				ingredients.add(new Ingredient(nom));
			}
		});
		return ingredients;
	}

	/**
	 * Transforme une chaine de caractères contenant tous les allergènes en liste
	 * d'allergènes. Cette méthode applique avant le découpage un ensemble de
	 * traitements afin de supprimer de la chaine les données indésirables.
	 * 
	 * @param chaine chaine contenant la liste d'allergènes.
	 * @return List de Allergene
	 */
	private Set<Allergene> transformeChaineEnAllergenes(String chaine) {

		List<String> morceaux = StringUtils.splitChaine(chaine);
		final Set<Allergene> allergenes = new HashSet<Allergene>();
		morceaux.forEach(new Consumer<String>() {
			public void accept(String nom) {
				allergenes.add(new Allergene(nom.toUpperCase().substring(0, 1) + nom.toLowerCase().substring(1)));
			}
		});
		return allergenes;
	}

	/**
	 * Transforme une chaine de caractères contenant tous les additifs en liste
	 * d'additifs. Cette méthode applique avant le découpage un ensemble de
	 * traitements afin de supprimer de la chaine les données indésirables.
	 * 
	 * @param chaine chaine contenant la liste d'additifs.
	 * @return List de Additif
	 */
	private Set<Additif> tranformeChaineEnAdditifs(String chaine) {

		List<String> morceaux = StringUtils.splitChaine(chaine);
		final Set<Additif> additifs = new HashSet<Additif>();
		morceaux.forEach(new Consumer<String>() {
			public void accept(String nom) {
				additifs.add(new Additif(nom));
			}
		});
		return additifs;
	}
}
