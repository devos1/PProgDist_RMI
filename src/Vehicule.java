﻿import java.io.Serializable;
import java.util.Date;

public class Vehicule implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date miseEnServiceDt;
	private String couleur;
	private CatPrix catPrix;
	private MarqueVehicule marque;
	private ModeleVehicule modele;
	private Utilisateur utilisateur;
	private Place place;	
	private TypeVehicule typeVehicule;
	
	/**
	 * Constructueur Vehicule
	 * @param place
	 */
	public Vehicule (Place place){
		this.place = place;
		this.setTypeVehicule(place.getType());
		
	}
	
	/**
	 * Constructueur Vehicule
	 * @param place
	 * @param catPrix
	 * @param marque
	 * @param modele
	 * @param couleur
	 */
	public Vehicule (Place place, CatPrix catPrix, MarqueVehicule marque, ModeleVehicule modele, String couleur){
		this.place = place;
		this.setTypeVehicule(place.getType());
		this.couleur = couleur;
		this.marque = marque;
		this.modele = modele;
		this.catPrix = catPrix;
		
	}
	
	/*===============
	 * GETTER / SETTER
	 ===============*/

	public TypeVehicule getTypeVehicule() {
		return typeVehicule;
	}

	public void setTypeVehicule(TypeVehicule typeVehicule) {
		this.typeVehicule = typeVehicule;
	}

}
