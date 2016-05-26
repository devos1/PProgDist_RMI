import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StationFooterPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	JLabel lblLouer, lblRendre;
	JComboBox<String> comboLouer;
	JComboBox<String> comboRendre;
	JPanel panelLouer, panelRendre;
	
	// CONSTRUCTEUR
	public StationFooterPanel() {
		
		setLayout(new GridLayout(0, 2));
		
		String[] vehicules = { "auto", "vélo" };
		
		// Create instances
		lblLouer = new JLabel(" Louer");
		lblRendre = new JLabel(" Rendre");
		comboLouer = new JComboBox<String>(vehicules);
		comboRendre = new JComboBox<String>(vehicules);
		panelLouer = new JPanel();
		panelRendre = new JPanel();
		
		// Custom labels
		lblLouer.setForeground(Color.BLUE);
		lblRendre.setForeground(Color.RED);
		
		// Custom Panels
		panelLouer.setLayout(new GridLayout(0, 1));
		panelRendre.setLayout(new GridLayout(0, 1));
		
		// Add components to panels Louer & Rendre
		panelLouer.add(lblLouer);
		panelLouer.add(comboLouer);
		panelRendre.add(lblRendre);
		panelRendre.add(comboRendre);
		
		// Add component to main panel
		add(panelLouer);
		add(panelRendre);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<String> cbTypeV = (JComboBox<String>)e.getSource();
		String typeVehicule = (String)cbTypeV.getSelectedItem();
		
	}
}