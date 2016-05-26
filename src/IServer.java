import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
	Vehicule louer(Station station, TypeVehicule typeVehicule) throws RemoteException;
	boolean rendre(Station station, Vehicule vehicule) throws RemoteException;
	
}
