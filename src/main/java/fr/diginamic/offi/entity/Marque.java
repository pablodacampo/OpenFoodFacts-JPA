package fr.diginamic.offi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


@Entity
@Table(name = "MARQUE")
public class Marque extends Entite {

	/** produits */
	@OneToMany(mappedBy = "marque")
	private List<Produit> produits = new ArrayList<Produit>();

	/**
	 * Constructeur (utilisé par Hibernate)
	 * 
	 */
	public Marque() {

	}

	/**
	 * Constructeur
	 * 
	 * @param nom nom de la marque
	 */
	public Marque(String nom) {
		super(nom);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.nom).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Marque)) {
			return false;
		}
		Marque autre = (Marque) obj;
		return new EqualsBuilder().append(this.nom, autre.getNom()).isEquals();
	}
}
