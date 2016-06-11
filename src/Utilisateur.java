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
	
	protected Utilisateur(IServer server) throws RemoteException {
		super();
		this.server = server;
    	
		Random rand = new Random();
		this.setNom("User" +  rand.nextInt(1000));		
		server.addUtilisateur(this);
		stations = server.envoyerStation();
	}

	public int login() {
		return 0;
	}

	public int logout() {
		return 0;
	}
	
	/*
	 * 
	 */
	public void setUserInterface(IUserInterface userInterface) {
		this.userInterface = userInterface;
	}

	/*
	 * (non-Javadoc)
	 * @see IUtilisateur#majPlaces(Place, int)
	 * Envoie une place avec un changement d'état (vehicule en plus ou en mois)
	 */
	@Override
	public void majPlaces(Place place, int nbPlaceLoue) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	/*
	 * (non-Javadoc)
	 * @see IUtilisateur#majStations(java.util.ArrayList)
	 * Envoi l'ensemble des stations du système
	 * Utiliser l'initialisation d'un client
	 */
	@Override
	public void majStations(ArrayList<Station> stations) {
		this.stations = stations;
		
	}

	//GETTER - SETTER
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Station getStation(int index){
		return this.stations.get(index);
	}

	/*
	 * (non-Javadoc)
	 * @see IUtilisateur#display()
	 */
	
	@Override
	public void display() throws RemoteException {
		userInterface.setNbLocation(this.getNbVehicule());
		userInterface.setUser(this.nom);
		
	}
	
	/*
	 * 
	 */
	private int getNbVehicule(){
		int nb;
		if (this.vehicule == null)
			nb = 0;
		else
			nb = 1;
		
		return nb;
	}

	@Override
	public boolean louer(int indexStation, TypeVehicule typeVehicule) throws RemoteException {
		boolean isLoue = false;
		if (this.vehicule == null){
			vehicule = getStation(indexStation).louer(typeVehicule);
			isLoue = true;
			display();
		}else{
			//Déjà une location en cours
		}
		
		return isLoue;
	}

	@Override
	public boolean rendre(int indexStation, Vehicule vehicule) throws RemoteException {
		boolean isRendu = false;
		if (this.vehicule != null){
			isRendu = getStation(indexStation).rendre(vehicule);
			if (isRendu){
				this.vehicule = null;
			}
			display();
		}else{
			// Rien n'a rendre
		}
		return isRendu;
	}
	
	

}
