﻿import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IUtilisateur extends Remote{
	void majPlaces(Place place, int nbPlaceLoue) throws RemoteException;
	void majStations(ArrayList<Station> stations) throws RemoteException;
	void louer(int indexStation, TypeVehicule typeVehicule) throws RemoteException;
	
	//String getNom();
	//void setNom(String nom);
	
	void display() throws RemoteException;

}
