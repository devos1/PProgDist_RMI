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


	@Override
	public void addUtilisateur(IUtilisateur utilisateur) throws RemoteException {
		utilisateurs.add(utilisateur);
		
	}

}
