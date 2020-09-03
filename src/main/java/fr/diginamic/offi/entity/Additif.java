package fr.diginamic.offi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "ADDITIF")
public class Additif extends Entite {

	/** additifs */
	@ManyToMany
	@JoinTable(name = "composition_add", joinColumns = @JoinColumn(name = "ID_ADD", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_PRD", referencedColumnName = "ID"))
	private List<Produit> produits = new ArrayList<Produit>();

	/**
	 * Constructeur (utilisé par Hibernate)
	 * 
	 */
	public Additif() {

	}

	/**
	 * Constructeur
	 * 
	 * @param nom nom de l'additif
	 */
	public Additif(String nom) {
		super(nom);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.nom).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Additif)) {
			return false;
		}
		Additif autre = (Additif) obj;
		return new EqualsBuilder().append(this.nom, autre.getNom()).isEquals();
	}

	/**
	 * Getter
	 * 
	 * @return the produits
	 */
	public List<Produit> getProduits() {
		return produits;
	}

	/**
	 * Setter
	 * 
	 * @param produits the produits to set
	 */
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
}
