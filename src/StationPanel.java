import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Utilisateur user;
	JLabel lblTitle;
	StationFooterPanel sfPanel;
	JPanel panelDetails;
	JLabel lblVelosDetails, lblVoituresDetails;

	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public StationPanel(Utilisateur user, int indexStation) throws RemoteException {
		this.user = user;
		setLayout(new BorderLayout());

		// Create instances
		Station station = user.getStation(indexStation);
		lblTitle = new JLabel(" STATION " + station.getNom());
		sfPanel = new StationFooterPanel(this.user, indexStation);
		panelDetails = new JPanel();
		
		lblVelosDetails = new JLabel("");//getTexteLabelVelo(station));
		lblVoituresDetails = new JLabel("");//getTexteLabelVoiture(station));

		// Custom panel details
		panelDetails.setLayout(new GridLayout(2, 1));

		// add components to panel details
		panelDetails.add(lblVelosDetails);
		panelDetails.add(lblVoituresDetails);

		// Custom
		lblTitle.setOpaque(isOpaque());
		lblTitle.setBackground(Color.GRAY);
		lblTitle.setForeground(Color.WHITE);

		// Add to panel
		add(lblTitle, BorderLayout.NORTH);
		add(sfPanel, BorderLayout.SOUTH);
		add(panelDetails, BorderLayout.CENTER);
	}
	
	public String getTexteLabelVelo(Station station){
		String nbPlacesLibres = String.valueOf(station.cptPlacesLibres(TypeVehicule.Velo));
		String nbVhcDispo = String.valueOf(station.cptVehiculesDisponible(TypeVehicule.Velo));
		
		return " VELOS : " + nbPlacesLibres + " places libres, y vélos " + nbVhcDispo + " disponibles";
	}
	
	public String getTexteLabelVoiture(Station station){
		String nbPlacesLibres = String.valueOf(station.cptPlacesLibres(TypeVehicule.Voiture));
		String nbVhcDispo = String.valueOf(station.cptVehiculesDisponible(TypeVehicule.Voiture));
		
		return " VOITURES : " + nbPlacesLibres + " places libres, " + nbVhcDispo + " voitures disponibles";
	}
	
	public void setTexteLabelVelo(Station station){
		lblVelosDetails.setText(getTexteLabelVelo(station));
	}
	
	public void setTexteLabelVoiture(Station station){
		lblVoituresDetails.setText(getTexteLabelVoiture(station));
	}

}
