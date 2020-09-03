package fr.diginamic.offi.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Entite {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	/** nom */
	protected String nom;

	/**
	 * Constructeur
	 * 
	 */
	public Entite() {

	}

	/**
	 * Constructeur
	 * 
	 * @param nom nom de l'entité
	 */
	public Entite(String nom) {
		super();
		this.nom = nom;
	}

	@Override
	public String toString() {
		return nom;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Getter
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Setter
	 * 
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
}
