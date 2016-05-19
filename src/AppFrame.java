import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppFrame extends JFrame {
	
	// VARIABLES
	StationPanel panelA;
	HeaderPanel panelHeader;
	
	public AppFrame(){
		super("Location de véhicules dans toute la Suisse");	
		//panelHeader =  new HeaderPanel();
		panelA = new StationPanel();
		
		//add(panelHeader, BorderLayout.NORTH);
		add(panelA, BorderLayout.NORTH);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setSize(600, 400);
		setVisible(true);
	}
}
