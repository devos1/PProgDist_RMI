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
		registry.bind("Server", server);
		
		System.out.println("Serveur RMI UP");

	}
	
	private static final long serialVersionUID = 1L;
	private ArrayList<IUtilisateur> utilisateurs;
	
	protected Server() throws RemoteException {
		super();
		
		utilisateurs = new ArrayList<IUtilisateur>();
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
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see IServer#rendre(Station, Vehicule)
	 */
	@Override
	public boolean rendre(Station station, Vehicule vehicule) {
		// TODO Auto-generated method stub
		return false;
	}

}
