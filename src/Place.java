public class Place {

	private Enum type;

	private Vehicule vehicule;

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
	
	public boolean isDisponible(){
		
		return vehicule != null;
	}

}
