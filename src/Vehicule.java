import java.io.Serializable;
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
	
	public Vehicule (Place place){
		this.place = place;
		this.typeVehicule = place.getType();
		
	}
	
	public Vehicule (Place place, CatPrix catPrix, MarqueVehicule marque, ModeleVehicule modele, String couleur){
		this.place = place;
		this.typeVehicule = place.getType();
		this.couleur = couleur;
		this.marque = marque;
		this.modele = modele;
		this.catPrix = catPrix;
		
	}

}
