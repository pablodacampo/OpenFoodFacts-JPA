package fr.diginamic.offi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "CATEGORIE")
public class Categorie extends Entite {

	/** produits */
	@OneToMany(mappedBy = "categorie")
	private List<Produit> produits = new ArrayList<Produit>();

	/**
	 * Constructeur (utilisé par Hibernate)
	 * 
	 */
	public Categorie() {

	}

	/**
	 * Constructeur
	 * 
	 * @param nom nom de la catégorie
	 */
	public Categorie(String nom) {
		super(nom);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.nom).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Categorie)) {
			return false;
		}
		Categorie autre = (Categorie) obj;
		return new EqualsBuilder().append(this.nom, autre.getNom()).isEquals();
	}
}
