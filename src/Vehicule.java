﻿import java.util.Date;

public class Vehicule {

	private Date miseEnServiceDt;

	private String couleur;

	private Enum catPrix;

	private Enum marque;

	private Enum modele;

	private Utilisateur utilisateur;

	private Place place;
	
	private TypeVehicule typeVehicule;
	
	public Vehicule (Place place){
		this.place = place;
		this.typeVehicule = place.getType();
		
	}

}
