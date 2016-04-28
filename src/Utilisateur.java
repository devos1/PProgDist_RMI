import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Utilisateur extends UnicastRemoteObject implements IUtilisateur{

	private String nom;

	private String prenom;

	private Vehicule vehicule;
	
	public static void main(String[] args) {
		new AppFrame();
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

}
