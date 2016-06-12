import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IServer extends Remote {
	Vehicule louer(int idStation, TypeVehicule typeVehicule) throws RemoteException;
	boolean rendre(int idStation, Vehicule vehicule) throws RemoteException;
	void addUtilisateur(IUtilisateur utilisateur) throws RemoteException;
	
	ArrayList<Station> envoyerStation() throws RemoteException;
	
}
