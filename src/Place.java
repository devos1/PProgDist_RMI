import java.io.Serializable;

public class Place implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private TypeVehicule typeVehicule;
	private Vehicule vehicule;
	private Station station;

	/**
	 * Constructeur Place
	 * @param station
	 */
	public Place(Station station){
		this.station = station;
		creerVehicule(this);
	}
	
	/**
	 * Constructueur Place
	 * @param station		: station de la place
	 * @param typeVehicule	: Type de véhicule (Enum)
	 */
	public Place(Station station, TypeVehicule typeVehicule){
		this.station = station;
		this.typeVehicule = typeVehicule;

		creerVehicule(this);
	}
	
	/**
	 * Retourne si la place est libre
	 * @return
	 */
	public boolean isLibre() {
	
		return vehicule == null;
	}
	
	/**
	 * Retourne vrai si un véhicule sur la place
	 * @return
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
	
	/**
	 * Créer un véhicule
	 * @param place
	 */
	public void creerVehicule(Place place){
		place.vehicule = new Vehicule(place, CatPrix.B, MarqueVehicule.Audi, ModeleVehicule.A3, "Blanc" );
	}
	
	/**
	 * Retourne le véhicule qui peut être pris. 
	 * Null si pas possible
	 * @return
	 */
	public Vehicule prendreVehicule(){
		Vehicule vehiculeRet;
		vehiculeRet = this.vehicule;
		this.vehicule = null;
		return vehiculeRet; 
	} 

}
