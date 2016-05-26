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

	public Vehicule louer(Enum typeVehicule) {
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

	public int cptPlacesLibres(Enum typeVehicule) {
		return 0;
	}

	public int cptVehiculesLibres(Enum typeVehicule) {
		return 0;
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

}
