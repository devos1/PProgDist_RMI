import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
	void addUtilisateur(IUtilisateur utilisateur) throws RemoteException;

	//void send(Item chatItem) throws RemoteException;
	
}
