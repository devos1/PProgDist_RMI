import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IUtilisateur {
	void majPlaces(Place place, int nbPlaceLoue) throws RemoteException;
	void majStations(ArrayList<Station> stations);

}
