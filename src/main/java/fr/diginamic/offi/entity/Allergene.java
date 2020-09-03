package fr.diginamic.offi.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "ALLERGENE")
public class Allergene extends Entite {

	/**
	 * Constructeur (utilisé par Hibernate)
	 * 
	 */
	public Allergene() {

	}

	/**
	 * Constructeur
	 * 
	 * @param nom nom de l'allergène
	 */
	public Allergene(String nom) {
		super(nom);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.nom).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Allergene)) {
			return false;
		}
		Allergene autre = (Allergene) obj;
		return new EqualsBuilder().append(this.nom, autre.getNom()).isEquals();
	}
}
