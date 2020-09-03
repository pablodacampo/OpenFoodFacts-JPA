package fr.diginamic.offi.manager;

import javax.persistence.EntityManager;

import fr.diginamic.offi.dao.IngredientDao;
import fr.diginamic.offi.entity.Ingredient;

public class IngredientService extends EntiteService<Ingredient> {

	/**
	 * Constructeur
	 * 
	 * @param em {@link EntityManager}
	 */
	public IngredientService(EntityManager em) {
		super(Ingredient.class, new IngredientDao(em));
	}

}
