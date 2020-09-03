package fr.diginamic.offi.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "INGREDIENT")
public class Ingredient extends Entite {

	/**
	 * Constructeur (utilisé par Hibernate)
	 * 
	 */
	public Ingredient() {

	}

	/**
	 * Constructeur
	 * 
	 * @param nom nom de l'ingrédient
	 */
	public Ingredient(String nom) {
		super(nom);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.nom).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Ingredient)) {
			return false;
		}
		Ingredient autre = (Ingredient) obj;
		return new EqualsBuilder().append(this.nom, autre.getNom()).isEquals();
	}

}
