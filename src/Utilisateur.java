import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Utilisateur extends UnicastRemoteObject implements IUtilisateur{

	private static final long serialVersionUID = 1L;
	private IServer server;
	//private UserInterface userInterface;
	
	private String nom;
	private String prenom;
	private Vehicule vehicule;
	
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
    	server.addUtilisateur(this);
	}

	public int login() {
		return 0;
	}

	public int logout() {
		return 0;
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
	 * Utiliser à l'initialisation d'un client
	 */
	@Override
	public void majStations(ArrayList<Station> stations) {
		// TODO Auto-generated method stub
		
	}

}
