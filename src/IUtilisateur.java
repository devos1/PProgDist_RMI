import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IUtilisateur extends Remote{
	void majPlaces(Place place, int nbPlaceLoue) throws RemoteException;
	void majStations(ArrayList<Station> stations) throws RemoteException;
	boolean louer(int indexStation, TypeVehicule typeVehicule) throws RemoteException;
	boolean rendre(int indexStation, TypeVehicule typeVehicule) throws RemoteException;
	
	void display() throws RemoteException;

}
