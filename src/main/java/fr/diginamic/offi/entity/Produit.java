package fr.diginamic.offi.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "Produit")
public class Produit extends Entite {

	/** categorie */
	@ManyToOne
	@JoinColumn(name = "ID_CAT")
	private Categorie categorie;

	/** marque */
	@ManyToOne
	@JoinColumn(name = "ID_MRQ")
	private Marque marque;

	/** ingredients */
	@ManyToMany
	@JoinTable(name = "composition_ing", joinColumns = @JoinColumn(name = "ID_PRD", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_ING", referencedColumnName = "ID"))
	private Set<Ingredient> ingredients = new HashSet<Ingredient>();

	/** additifs */
	@ManyToMany
	@JoinTable(name = "composition_add", joinColumns = @JoinColumn(name = "ID_PRD", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_ADD", referencedColumnName = "ID"))
	private Set<Additif> additifs = new HashSet<Additif>();

	/** allergenes */
	@ManyToMany
	@JoinTable(name = "composition_all", joinColumns = @JoinColumn(name = "ID_PRD", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_ALL", referencedColumnName = "ID"))
	private Set<Allergene> allergenes = new HashSet<Allergene>();

	/** grade */
	private String grade;
	/** energie100g */
	private Double energie100g;
	/** graisse100g */
	private Double graisse100g;
	/** sucres100g */
	private Double sucres100g;
	/** fibres100g */
	private Double fibres100g;
	/** proteines100g */
	private Double proteines100g;
	/** sel100g */
	private Double sel100g;
	/** vitA100g */
	private Double vitA100g;
	/** vitD100g */
	private Double vitD100g;
	/** vitE100g */
	private Double vitE100g;
	/** vitK100g */
	private Double vitK100g;
	/** vitC100g */
	private Double vitC100g;
	/** vitB1100g */
	private Double vitB1100g;
	/** vitB2100g */
	private Double vitB2100g;
	/** vitPP100g */
	private Double vitPP100g;
	/** vitB6100g */
	private Double vitB6100g;
	/** vitB9100g */
	private Double vitB9100g;
	/** vitB12100g */
	private Double vitB12100g;
	/** calcium100g */
	private Double calcium100g;
	/** magnesium100g */
	private Double magnesium100g;
	/** iron100g */
	private Double iron100g;
	/** fer100g */
	private Double fer100g;
	/** betaCarotene100g */
	private Double betaCarotene100g;
	/** presenceHuilePalme */
	private String presenceHuilePalme;

	/**
	 * Constructeur (utilisé par Hibernate)
	 * 
	 */
	public Produit() {

	}

	/**
	 * Constructeur
	 * 
	 * @param nom nom du produit
	 */
	public Produit(String nom) {
		super(nom);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.nom).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Produit)) {
			return false;
		}
		Produit autre = (Produit) obj;
		return new EqualsBuilder().append(this.nom, autre.getNom()).isEquals();
	}

	@Override
	public String toString() {
		return id + " " + nom + " - Categorie:" + categorie.getId() + " - Marque:" + marque.getId();
	}

	/**
	 * Getter
	 * 
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * Setter
	 * 
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/**
	 * Getter
	 * 
	 * @return the marque
	 */
	public Marque getMarque() {
		return marque;
	}

	/**
	 * Setter
	 * 
	 * @param marque the marque to set
	 */
	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	/**
	 * Getter
	 * 
	 * @return the ingredients
	 */
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * Setter
	 * 
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * Getter
	 * 
	 * @return the additifs
	 */
	public Set<Additif> getAdditifs() {
		return additifs;
	}

	/**
	 * Setter
	 * 
	 * @param additifs the additifs to set
	 */
	public void setAdditifs(Set<Additif> additifs) {
		this.additifs = additifs;
	}

	/**
	 * Getter
	 * 
	 * @return the allergenes
	 */
	public Set<Allergene> getAllergenes() {
		return allergenes;
	}

	/**
	 * Setter
	 * 
	 * @param allergenes the allergenes to set
	 */
	public void setAllergenes(Set<Allergene> allergenes) {
		this.allergenes = allergenes;
	}

	/**
	 * Getter
	 * 
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * Setter
	 * 
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * Getter
	 * 
	 * @return the energie100g
	 */
	public Double getEnergie100g() {
		return energie100g;
	}

	/**
	 * Setter
	 * 
	 * @param energie100g the energie100g to set
	 */
	public void setEnergie100g(Double energie100g) {
		this.energie100g = energie100g;
	}

	/**
	 * Getter
	 * 
	 * @return the graisse100g
	 */
	public Double getGraisse100g() {
		return graisse100g;
	}

	/**
	 * Setter
	 * 
	 * @param graisse100g the graisse100g to set
	 */
	public void setGraisse100g(Double graisse100g) {
		this.graisse100g = graisse100g;
	}

	/**
	 * Getter
	 * 
	 * @return the sucres100g
	 */
	public Double getSucres100g() {
		return sucres100g;
	}

	/**
	 * Setter
	 * 
	 * @param sucres100g the sucres100g to set
	 */
	public void setSucres100g(Double sucres100g) {
		this.sucres100g = sucres100g;
	}

	/**
	 * Getter
	 * 
	 * @return the fibres100g
	 */
	public Double getFibres100g() {
		return fibres100g;
	}

	/**
	 * Setter
	 * 
	 * @param fibres100g the fibres100g to set
	 */
	public void setFibres100g(Double fibres100g) {
		this.fibres100g = fibres100g;
	}

	/**
	 * Getter
	 * 
	 * @return the proteines100g
	 */
	public Double getProteines100g() {
		return proteines100g;
	}

	/**
	 * Setter
	 * 
	 * @param proteines100g the proteines100g to set
	 */
	public void setProteines100g(Double proteines100g) {
		this.proteines100g = proteines100g;
	}

	/**
	 * Getter
	 * 
	 * @return the sel100g
	 */
	public Double getSel100g() {
		return sel100g;
	}

	/**
	 * Setter
	 * 
	 * @param sel100g the sel100g to set
	 */
	public void setSel100g(Double sel100g) {
		this.sel100g = sel100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitA100g
	 */
	public Double getVitA100g() {
		return vitA100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitA100g the vitA100g to set
	 */
	public void setVitA100g(Double vitA100g) {
		this.vitA100g = vitA100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitD100g
	 */
	public Double getVitD100g() {
		return vitD100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitD100g the vitD100g to set
	 */
	public void setVitD100g(Double vitD100g) {
		this.vitD100g = vitD100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitE100g
	 */
	public Double getVitE100g() {
		return vitE100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitE100g the vitE100g to set
	 */
	public void setVitE100g(Double vitE100g) {
		this.vitE100g = vitE100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitK100g
	 */
	public Double getVitK100g() {
		return vitK100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitK100g the vitK100g to set
	 */
	public void setVitK100g(Double vitK100g) {
		this.vitK100g = vitK100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitC100g
	 */
	public Double getVitC100g() {
		return vitC100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitC100g the vitC100g to set
	 */
	public void setVitC100g(Double vitC100g) {
		this.vitC100g = vitC100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitB1100g
	 */
	public Double getVitB1100g() {
		return vitB1100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitB1100g the vitB1100g to set
	 */
	public void setVitB1100g(Double vitB1100g) {
		this.vitB1100g = vitB1100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitB2100g
	 */
	public Double getVitB2100g() {
		return vitB2100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitB2100g the vitB2100g to set
	 */
	public void setVitB2100g(Double vitB2100g) {
		this.vitB2100g = vitB2100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitPP100g
	 */
	public Double getVitPP100g() {
		return vitPP100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitPP100g the vitPP100g to set
	 */
	public void setVitPP100g(Double vitPP100g) {
		this.vitPP100g = vitPP100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitB6100g
	 */
	public Double getVitB6100g() {
		return vitB6100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitB6100g the vitB6100g to set
	 */
	public void setVitB6100g(Double vitB6100g) {
		this.vitB6100g = vitB6100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitB9100g
	 */
	public Double getVitB9100g() {
		return vitB9100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitB9100g the vitB9100g to set
	 */
	public void setVitB9100g(Double vitB9100g) {
		this.vitB9100g = vitB9100g;
	}

	/**
	 * Getter
	 * 
	 * @return the vitB12100g
	 */
	public Double getVitB12100g() {
		return vitB12100g;
	}

	/**
	 * Setter
	 * 
	 * @param vitB12100g the vitB12100g to set
	 */
	public void setVitB12100g(Double vitB12100g) {
		this.vitB12100g = vitB12100g;
	}

	/**
	 * Getter
	 * 
	 * @return the calcium100g
	 */
	public Double getCalcium100g() {
		return calcium100g;
	}

	/**
	 * Setter
	 * 
	 * @param calcium100g the calcium100g to set
	 */
	public void setCalcium100g(Double calcium100g) {
		this.calcium100g = calcium100g;
	}

	/**
	 * Getter
	 * 
	 * @return the magnesium100g
	 */
	public Double getMagnesium100g() {
		return magnesium100g;
	}

	/**
	 * Setter
	 * 
	 * @param magnesium100g the magnesium100g to set
	 */
	public void setMagnesium100g(Double magnesium100g) {
		this.magnesium100g = magnesium100g;
	}

	/**
	 * Getter
	 * 
	 * @return the iron100g
	 */
	public Double getIron100g() {
		return iron100g;
	}

	/**
	 * Setter
	 * 
	 * @param iron100g the iron100g to set
	 */
	public void setIron100g(Double iron100g) {
		this.iron100g = iron100g;
	}

	/**
	 * Getter
	 * 
	 * @return the fer100g
	 */
	public Double getFer100g() {
		return fer100g;
	}

	/**
	 * Setter
	 * 
	 * @param fer100g the fer100g to set
	 */
	public void setFer100g(Double fer100g) {
		this.fer100g = fer100g;
	}

	/**
	 * Getter
	 * 
	 * @return the betaCarotene100g
	 */
	public Double getBetaCarotene100g() {
		return betaCarotene100g;
	}

	/**
	 * Setter
	 * 
	 * @param betaCarotene100g the betaCarotene100g to set
	 */
	public void setBetaCarotene100g(Double betaCarotene100g) {
		this.betaCarotene100g = betaCarotene100g;
	}

	/**
	 * Getter
	 * 
	 * @return the presenceHuilePalme
	 */
	public String getPresenceHuilePalme() {
		return presenceHuilePalme;
	}

	/**
	 * Setter
	 * 
	 * @param presenceHuilePalme the presenceHuilePalme to set
	 */
	public void setPresenceHuilePalme(String presenceHuilePalme) {
		this.presenceHuilePalme = presenceHuilePalme;
	}
}
