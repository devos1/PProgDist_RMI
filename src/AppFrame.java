import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class AppFrame extends JFrame {
	
	// VARIABLES
	JLabel lblNbLocation; 
	JLabel lblUser;
	StationPanel panelA;
	HeaderPanel panelHeader;
	
	public AppFrame(){
		super("Location de véhicules dans toute la Suisse");	
		
		setLayout(new BorderLayout());
		
		// Create instances
		lblNbLocation = new JLabel("Nb de locations : 0 véhicules");
		lblUser = new JLabel("Utilisateur : John Doe");
		
		// Custom labels
		lblNbLocation.setOpaque(isOpaque());
		lblNbLocation.setBackground(Color.DARK_GRAY);
		lblNbLocation.setForeground(Color.WHITE);
		lblUser.setOpaque(isOpaque());
		lblUser.setBackground(Color.DARK_GRAY);
		lblUser.setForeground(Color.WHITE);
		
		
		// Add to pane
		add(lblNbLocation, BorderLayout.NORTH);
		add(lblUser, BorderLayout.SOUTH);
		
/*		panelHeader =  new HeaderPanel();
		panelA = new StationPanel();
		add(panelHeader, BorderLayout.NORTH);
		add(panelA, BorderLayout.CENTER);	*/
		
		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
