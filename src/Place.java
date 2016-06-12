﻿import java.io.Serializable;

public class Place implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private TypeVehicule typeVehicule;
	private Vehicule vehicule;
	private Station station;

	/*
	 * Constructeur
	 */
	public Place(){
		creerVehicule(this);
	}
	
	public Place(TypeVehicule typeVehicule){
		this.typeVehicule = typeVehicule;

		creerVehicule(this);
	}
	
	/*
	 * Retourne si la place est libre
	 */
	public boolean isLibre() {
	
		return vehicule == null;
	}
	
	/*
	 * Retourne vrai si un véhicule sur la place
	 */
	public boolean isDisponible(){
		
		return this.vehicule != null;
	}
	
	/*===============
	 * GETTER / SETTER
	 ===============*/
	
	public Vehicule getVehicule() {
		return vehicule;
	}
	
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public TypeVehicule getType() {
		return typeVehicule;
	}

	public void setType(TypeVehicule typeVehicule) {
		this.typeVehicule = typeVehicule;
	}
	
	/*===============
	 * ACTION
	 ===============*/
	
	public void creerVehicule(Place place){
		place.vehicule = new Vehicule(place, CatPrix.B, MarqueVehicule.Audi, ModeleVehicule.A3, "Blanc" );
	}
	
	public Vehicule prendreVehicule(){
		Vehicule vehiculeRet;
		vehiculeRet = this.vehicule;
		this.vehicule = null;
		return vehiculeRet; 
	} 

}
