﻿import java.io.Console;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements IServer{

	/**
	 * MAIN
	 * @param args
	 * @throws RemoteException
	 * @throws AlreadyBoundException
	 */
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		IServer server = new Server();
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.bind("ServerStation", server);
		
		System.out.println("Serveur RMI UP");

	}
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Station> stations;
	private ArrayList<Vehicule> vehiculeLoue;  
	private ArrayList<IUtilisateur> utilisateurs;
	
	/**
	 * Constructueur
	 * @throws RemoteException
	 */
	protected Server() throws RemoteException {
		super();
		
		utilisateurs = new ArrayList<IUtilisateur>();
		creerStations();
	}
	
	/**
	 * Mise à jours de stations
	 * @throws RemoteException 
	 * 
	 */
	public void MajStations() throws RemoteException{
		for (IUtilisateur user : utilisateurs) {
			user.majStations(stations);
			user.display();
		}
	}

	/**
	 * Louer un véhicule, si possible le retourne
	 * Sinon null
	 * @throws RemoteException 
	 * @see IServer#louer(Station, TypeVehicule)
	 */
	@Override
	public Vehicule louer(int idStation, TypeVehicule typeVehicule) throws RemoteException {
		Vehicule vehiculeRetour = null;
		
		for (Station stationTmp : stations) {
			if (vehiculeRetour == null){
				if (idStation == stationTmp.getID()){
					// Boucle pour trouver une place de libre
					vehiculeRetour = stationTmp.louer(typeVehicule); //getVehiculeDisponible();
				}
			}
			else{
				// Véhicule trouvé
				break;
			}
		}
		
		MajStations();
		
		if (vehiculeRetour != null)
			System.out.println("Location: OK station:" + String.valueOf(idStation) + " - Type véhicule: " + String.valueOf(vehiculeRetour.getTypeVehicule()));
		else
			System.out.println("Location: KO dans la station "+ String.valueOf(idStation));
		
		return vehiculeRetour;
	}

	/**
	 * Rendre un véhicule
	 * Vrai = possible
	 * Faux = pas possible
	 * @throws RemoteException 
	 * @see IServer#rendre(Station, Vehicule)
	 */
	@Override
	public boolean rendre(int idStation, Vehicule vehicule) throws RemoteException {
		boolean retourPossible = false;
		
		for (Station stationTmp : stations) {
			if (!retourPossible){
				if (idStation == stationTmp.getID()){
					retourPossible = stationTmp.rendre(vehicule);
				}
			}
			else{
				// Rendu
				break;
			}
		}
		
		MajStations();
		
		if (retourPossible)
			System.out.println("Rendre: OK station:" + String.valueOf(idStation) + " - Type véhicule: " + String.valueOf(vehicule.getTypeVehicule()));
		else
			System.out.println("Rendre: KO dans la station " + String.valueOf(idStation));
		
		return retourPossible;
	}

	/**
	 * Ajouter un utilisateur dans la liste du serveur
	 */
	@Override
	public void addUtilisateur(IUtilisateur utilisateur) throws RemoteException {
		System.out.println("Utilisateurs  ajoutés");
		this.utilisateurs.add(utilisateur);
	}

	/**
	 * Retourne l'ensemble des stations du serveur
	 */
	@Override
	public ArrayList<Station> envoyerStation() {
		return this.stations;
	}
	
	/**
	 * Créer une stations
	 */
	private void creerStations(){
		this.stations = new ArrayList<>();
		
		int idStation = 0;
		
		this.stations.add(new Station("Yverdon",idStation));
		idStation++;
		this.stations.add(new Station("Neuchatel",idStation));
		idStation++;
		this.stations.add(new Station("Lausanne",idStation));
		idStation++;
		this.stations.add(new Station("Nyon",idStation));
	}

}
