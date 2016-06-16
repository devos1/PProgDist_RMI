import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Station implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Place> places;
	private int posX;
	private int posY;
	private String nom;
	private String pays;
	private String ville;
	private int ID;
	
	/**
	 * Constructeur
	 * @param nom
	 * @param id
	 */
	public Station(String nom, int id){
		this.nom = nom;
		this.setID(id);
		
		//Lecture des places
		creerPlaces(this);
	}


	/**
	 * Retourne le nombre de places libres pour un type de véhicule
	 * @param typeVehicule
	 * @return
	 */
	public int cptPlacesLibres(TypeVehicule typeVehicule) {
		int nbPlaceLibres = 0;
		
		for (Place place : places) {
			if (place.getType() == typeVehicule && place.isLibre() == true){
				nbPlaceLibres++;
			}
				
		}
		
		return nbPlaceLibres;
	}

	/**
	 * Retourne le nombre de véhicule dispnonible à la location
	 * @param typeVehicule
	 * @return
	 */
	public int cptVehiculesDisponible(TypeVehicule typeVehicule) {
		int nbVehiculeDispo = 0;
		
		for (Place place : places) {
			if (place.getType() == typeVehicule && place.isDisponible() == true){
				nbVehiculeDispo++;
			}
				
		}
		
		return nbVehiculeDispo;
	}

	/**
	 * Retourne un véhicule disponible
	 * Null si pas de disponible
	 * @return
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
	
	/**
	 * Retourne une place libre
	 * @param typeVehicule
	 * @return
	 */
	public Place getPlaceDisponible(TypeVehicule typeVehicule){
		Place placeRetour = null;
		
		for (Place placeTmp : places) {
			if (placeTmp.isLibre() && placeTmp.getType() == typeVehicule){
				placeRetour = placeTmp;
				break;
			}
			
		}
		
		return placeRetour;
	}

	/*===============
	 * GETTER / SETTER
	 ===============*/
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	/*===============
	 * ACTION
	 ===============*/
	
	/**
	 * Prend un véhicule
	 * Retourne le véhicule 
	 * @param typeVehicule
	 * @return
	 */
	public Vehicule louer(TypeVehicule typeVehicule) {
		Vehicule vehicule = null;
		
		for (Place place : places) {
			if (place.isDisponible() && place.getType() == typeVehicule){
				vehicule = place.prendreVehicule();
				break;
			}
		}
		
		return vehicule;
	}

	/**
	 * Rend un véhicule
	 * Si pas possible retourne faux
	 * @param vehicule
	 * @return
	 */
	public boolean rendre(Vehicule vehicule) {
		boolean retour = false;
		Place placeTmp = null;
		
		placeTmp = getPlaceDisponible(vehicule.getTypeVehicule());
		
		if (placeTmp != null){
			placeTmp.setVehicule(vehicule);
			retour = true;		
		}
		
		return retour;
	}
	
	
	/**
	 * Creer un jeu d'essai
	 * @param station
	 */
	public void creerPlaces(Station station){
		station.places = new ArrayList<Place>();
		
		places.add(new Place(this, TypeVehicule.Voiture));
		places.add(new Place(this, TypeVehicule.Voiture));
		places.add(new Place(this, TypeVehicule.Velo));
		places.add(new Place(this, TypeVehicule.Velo));
	}
}
