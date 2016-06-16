import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

public class Utilisateur extends UnicastRemoteObject implements IUtilisateur{

	private static final long serialVersionUID = 1L;
	private IServer server;
	private IUserInterface userInterface;
	
	private String nom;
	private String prenom;
	private Vehicule vehicule;
	private ArrayList<Station> stations;
	
	/**
	 * MAIN
	 * @param args
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost");
		try {
			IServer server = (IServer) registry.lookup("ServerStation");
			Utilisateur utilisateur = new Utilisateur(server);
			new AppFrame(utilisateur);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Constructeur Utilisateur
	 * @param server
	 * @throws RemoteException
	 */
	protected Utilisateur(IServer server) throws RemoteException {
		super();
		this.server = server;
    	
		Random rand = new Random();
		this.setNom("User" +  rand.nextInt(1000));		
		server.addUtilisateur(this);
		stations = server.envoyerStation();
	}

	/**
	 * Configure l'interface utilisateur
	 * @param userInterface
	 */
	public void setUserInterface(IUserInterface userInterface) {
		this.userInterface = userInterface;
	}

	/**
	 * Envoie une place avec un changement d'état (vehicule en plus ou en mois)
	 * @see IUtilisateur#majPlaces(Place, int)
	 */
	@Override
	public void majPlaces(Place place, int nbPlaceLoue) throws RemoteException {
		
	}

	/**
	 * Envoi l'ensemble des stations du système
	 * Utiliser l'initialisation d'un client
	 * @see IUtilisateur#majStations(java.util.ArrayList)
	 */
	@Override
	public void majStations(ArrayList<Station> stations) {
		this.stations = stations;
		System.out.println("Utilisateur:" + getNom() + " - maj stations ");
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
	
	/**
	 * Retourne une station selon son identifiant
	 * @param idStation
	 * @return
	 */
	public Station getStation(int idStation){
		Station stationRet = null;
		
		for (Station stationTmp : this.stations) {
			if(stationTmp.getID() == idStation){
				stationRet = stationTmp;
				break;
			}
		}
		
		return stationRet;
	}

	/**
	 * Déclanche le rafraichissement des données de l'interface utilisateur
	 * @see IUtilisateur#display()
	 */
	@Override
	public void display() throws RemoteException {
		userInterface.setNbLocation(this.getNbVehicule());
		userInterface.setUser(this.nom);	
		userInterface.setTexteLabel();
	}
	
	/**
	 * Retourne le nombre de véhicule en cours de location
	 * @return
	 */
	private int getNbVehicule(){
		int nb;
		if (this.vehicule == null)
			nb = 0;
		else
			nb = 1;
		
		return nb;
	}

	/**
	 * Louer un véhicule dans une stations
	 * Vrai = loué
	 * Faux = non loué
	 */
	@Override
	public boolean louer(int indexStation, TypeVehicule typeVehicule) throws RemoteException {
		boolean isLoue = false;
		if (this.vehicule == null){
			vehicule = server.louer(indexStation, typeVehicule); 
			isLoue = vehicule != null;	// loué
			display();
		}else{
			//Déjà une location en cours
		}
		
		return isLoue;
	}

	/**
	 * Rendre un véhicule à une station 
	 * Vrai = rendu
	 * Faux = pas rendu
	 */
	@Override
	public boolean rendre(int indexStation, TypeVehicule typeVehicule) throws RemoteException {
		boolean isRendu = false;
		if (this.vehicule != null){
			if(this.vehicule.getTypeVehicule() == typeVehicule){
				isRendu = server.rendre(indexStation, this.vehicule);
				if (isRendu){
					this.vehicule = null;
				}
				display();
			}else{
				// Pas le bon type
			}
		}else{
			// Rien n'a rendre
		}
		return isRendu;
	}
}
