import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Utilisateur extends UnicastRemoteObject implements IUtilisateur{

	private String nom;

	private String prenom;

	private Vehicule vehicule;
	
	public static void main(String[] args) {
		new AppFrame(null);
	}
	
	protected Utilisateur() throws RemoteException {
		super();
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
