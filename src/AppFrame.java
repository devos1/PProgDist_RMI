import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AppFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	// VARIABLES
	JLabel lblNbLocation; 
	JLabel lblUser;
	StationPanel panelStationA, panelStationB, panelStationC, panelStationD;
	JPanel panelStations;
	GridLayout stationsMainLayout = new GridLayout(2, 2);
	javax.swing.border.Border blackBorder;
	
	public AppFrame(){
		super("Location de véhicules dans toute la Suisse");
		blackBorder = BorderFactory.createLineBorder(Color.black, 2, true);
		javax.swing.border.Border paneEdge = BorderFactory.createEmptyBorder(10,10,10,10);
		
		setLayout(new BorderLayout());
		
		// Create instances
		lblNbLocation = new JLabel("Nombre de locations : 0 véhicules");
		lblUser = new JLabel("Utilisateur : John Doe");
		panelStationA = new StationPanel();
		panelStationB = new StationPanel();
		panelStationC = new StationPanel();
		panelStationD = new StationPanel();
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
}
