import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Station implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Place> places;

	private int posX;

	private int posY;

	private String nom;

	private String pays;

	private String ville;
	
	public Station(String nom){
		this.nom = nom;
		
		//Lecture des places
		creerPlaces(this);
	}

	public Vehicule louer(TypeVehicule typeVehicule) {
		return null;
	}

	/*
	 * Rend un véhicule
	 * Si pas possible retourne faux
	 */
	public boolean rendre(Vehicule vehicule) {
		boolean retour = false;
		Place placeTmp = null;
		
		placeTmp = getPlaceDisponible();
		
		if (placeTmp != null){
			placeTmp.setVehicule(vehicule);
			retour = true;		
		}
		
		return retour;
	}

	public int cptPlacesLibres(TypeVehicule typeVehicule) {
		int nbPlaceLibres = 0;
		
		for (Place place : places) {
			if (place.getType() == typeVehicule && place.isLibre() == true){
				nbPlaceLibres++;
			}
				
		}
		
		return nbPlaceLibres;
	}

	public int cptVehiculesDisponible(TypeVehicule typeVehicule) {
		int nbVehiculeDispo = 0;
		
		for (Place place : places) {
			if (place.getType() == typeVehicule && place.isDisponible() == true){
				nbVehiculeDispo++;
			}
				
		}
		
		return nbVehiculeDispo;
	}

	public int cptNbPlaces() {
		return 0;
	}

	/*
	 * Retourne un véhicule disponible
	 * Null si pas de disponible
	 */
	public Vehicule getVehiculeDisponible() {
		Vehicule vehiculeRetour = null;
		
		for (Place placeTmp : places) {
			if (placeTmp.isDisponible()){
				vehiculeRetour = placeTmp.getVehicule();
				break;
			}
		}

		return vehiculeRetour;
	}
	
	/*
	 * Retourne une place libre
	 */
	public Place getPlaceDisponible(){
		Place placeRetour = null;
		
		for (Place placeTmp : places) {
			if (placeTmp.isLibre()){
				placeRetour = placeTmp;
				break;
			}
			
		}
		
		return placeRetour;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void creerPlaces(Station station){
		station.places = new ArrayList<Place>();
		
		places.add(new Place());
		places.add(new Place());
		places.add(new Place());
		places.add(new Place());
	}

}
