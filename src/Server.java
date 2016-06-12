import java.io.Console;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements IServer{

	// MAIN
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		IServer server = new Server();
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.bind("ServerStation", server);
		
		System.out.println("Serveur RMI UP");

	}
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Station> stations;
	private ArrayList<Vehicule> vehiculeLoue;  
	private ArrayList<IUtilisateur> utilisateurs;
	
	protected Server() throws RemoteException {
		super();
		
		utilisateurs = new ArrayList<IUtilisateur>();
		creerStations();
	}
	
	public void send(String texte) {
		for (IUtilisateur user : utilisateurs) {
			//user.display(texte);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see IServer#MajPlaces(Place, int)
	 */
	public void MajPlaces(Place place, int nbPlaceLoue){
	
	}

	/*
	 * (non-Javadoc)
	 * @see IServer#louer(Station, TypeVehicule)
	 */
	@Override
	public Vehicule louer(Station station, TypeVehicule typeVehicule) {
		Vehicule vehiculeRetour = null;
		
		for (Station stationTmp : stations) {
			if (station == stationTmp){
				// Boucle pour trouver une place de libre
				vehiculeRetour = station.getVehiculeDisponible();
			}
		}
		
		return vehiculeRetour;
	}

	/*
	 * (non-Javadoc)
	 * @see IServer#rendre(Station, Vehicule)
	 */
	@Override
	public boolean rendre(Station station, Vehicule vehicule) {
		boolean retourPossible = false;
		
		retourPossible = station.rendre(vehicule);
		
		return retourPossible;
	}

	@Override
	public void addUtilisateur(IUtilisateur utilisateur) throws RemoteException {
		//System.out.println("Utilisateurs %s ajoutés", utilisateur.getNom());
		this.utilisateurs.add(utilisateur);
	}

	@Override
	public ArrayList<Station> envoyerStation() {
		return this.stations;
	}
	
	private void creerStations(){
		this.stations = new ArrayList<>();
		
		int idStation = 0;
		
		this.stations.add(new Station("Yverdon",idStation));
		idStation++;
		this.stations.add(new Station("Neuchatel",idStation));
		idStation++;
		this.stations.add(new Station("Lausanne",idStation));
		idStation++;
		this.stations.add(new Station("Nyon",idStation));
	}

}
