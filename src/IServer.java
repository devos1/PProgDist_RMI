import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IServer extends Remote {
	Vehicule louer(Station station, TypeVehicule typeVehicule) throws RemoteException;
	boolean rendre(Station station, Vehicule vehicule) throws RemoteException;
	void addUtilisateur(IUtilisateur utilisateur) throws RemoteException;
	
	ArrayList<Station> envoyerStation() throws RemoteException;
	
}
