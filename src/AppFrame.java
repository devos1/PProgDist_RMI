import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AppFrame extends JFrame implements IUserInterface{
	
	private static final long serialVersionUID = 1L;
	
	// VARIABLES
	Utilisateur user;
	JLabel lblNbLocation; 
	JLabel lblUser;
	StationPanel panelStationA, panelStationB, panelStationC, panelStationD;
	JPanel panelStations;
	GridLayout stationsMainLayout = new GridLayout(2, 2);
	javax.swing.border.Border blackBorder;
	
	public AppFrame(Utilisateur user) throws RemoteException{
		super("MobiOsLo: Location de vehicules dans toute la Suisse");
		this.user = user;
		user.setUserInterface(this);
				
		blackBorder = BorderFactory.createLineBorder(Color.black, 2, true);
		javax.swing.border.Border paneEdge = BorderFactory.createEmptyBorder(10,10,10,10);
		
		setLayout(new BorderLayout());
		
		// Create instances
		lblNbLocation = new JLabel("...");
		lblUser = new JLabel("...");
		panelStationA = new StationPanel(this.user, 0);
		panelStationB = new StationPanel(this.user, 1);
		panelStationC = new StationPanel(this.user, 2);
		panelStationD = new StationPanel(this.user, 3);
		panelStations = new JPanel();
		
		// Custom panel Stations and add stations
		panelStations.setBorder(paneEdge);
		panelStationA.setBorder(blackBorder);
		panelStationB.setBorder(blackBorder);
		panelStationC.setBorder(blackBorder);
		panelStationD.setBorder(blackBorder);
		panelStations.setLayout(stationsMainLayout);
		
		panelStations.add(panelStationA);
		panelStations.add(panelStationB);
		panelStations.add(panelStationC);
		panelStations.add(panelStationD);
		stationsMainLayout.setHgap(10);
		stationsMainLayout.setVgap(10);
		
		// Custom labels
		lblNbLocation.setOpaque(isOpaque());
		lblNbLocation.setBackground(Color.DARK_GRAY);
		lblNbLocation.setForeground(Color.WHITE);
		lblUser.setOpaque(isOpaque());
		lblUser.setBackground(Color.DARK_GRAY);
		lblUser.setForeground(Color.WHITE);
		
		
		// Add to pane
		add(lblNbLocation, BorderLayout.NORTH);
		add(panelStations, BorderLayout.CENTER);
		add(lblUser, BorderLayout.SOUTH);
		
		setSize(900, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}


	/**
	 * Affecte au libellé du nombre de véhicule en cours de location
	 */
	@Override
	public void setNbLocation(int nbLocation) {
		lblNbLocation.setText("Nombre de locations : " + nbLocation + " véhicules");
	}

	/**
	 * Affecte au libellé le nom de l'utilisateur en cours
	 */
	@Override
	public void setUser(String nomUser) {
		lblUser.setText("Utilisateur : " + nomUser);		
	}

	/**
	 * Affecte le nom des stations
	 */
	@Override
	public void setTexteLabel() {
		// Velo
		if (panelStationA != null)
			panelStationA.setTexteLabelVelo(user.getStation(0));
		if (panelStationB != null)
			panelStationB.setTexteLabelVelo(user.getStation(1));
		if (panelStationC != null)
			panelStationC.setTexteLabelVelo(user.getStation(2));
		if (panelStationD != null)
			panelStationD.setTexteLabelVelo(user.getStation(3));
		
		// Voiture
		if (panelStationA != null)
			panelStationA.setTexteLabelVoiture(user.getStation(0));
		if (panelStationB != null)
			panelStationB.setTexteLabelVoiture(user.getStation(1));
		if (panelStationC != null)
			panelStationC.setTexteLabelVoiture(user.getStation(2));
		if (panelStationD != null)
		panelStationD.setTexteLabelVoiture(user.getStation(3));	
	}
}
