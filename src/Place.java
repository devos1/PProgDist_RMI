import java.io.Serializable;

public class Place implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private TypeVehicule typeVehicule;

	private Vehicule vehicule;

	/*
	 * Constructeur
	 */
	public Place(){
		creerVehicule(this);
	}
	
	public Place(TypeVehicule typeVehicule){
		creerVehicule(this);
		
		this.typeVehicule = typeVehicule;
	}
	
	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	private Station station;

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

	public TypeVehicule getType() {
		return typeVehicule;
	}

	public void setType(TypeVehicule typeVehicule) {
		this.typeVehicule = typeVehicule;
	}
	
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
