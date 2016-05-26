import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	 */
	public StationPanel(Utilisateur user) {
		this.user = user;
		setLayout(new BorderLayout());

		// Create instances
		lblTitle = new JLabel(" STATION ...");
		sfPanel = new StationFooterPanel(this.user);
		panelDetails = new JPanel();
		lblVelosDetails = new JLabel(" VELOS : x places libres, y vélos disponibles");
		lblVoituresDetails = new JLabel(" VOITURES : x places libres, y voitures disponibles");

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

}
