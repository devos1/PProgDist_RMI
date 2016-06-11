import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StationFooterPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Utilisateur user;
	private int indexStation;
	JLabel lblLouer, lblRendre;
	JComboBox<String> comboLouer;
	JComboBox<String> comboRendre;
	JPanel panelLouer, panelRendre;
	
	// CONSTRUCTEUR
	public StationFooterPanel(Utilisateur user, int indexStation) throws RemoteException {
		this.user = user;
		this.indexStation = indexStation;
		setLayout(new GridLayout(0, 2));
		
		String[] vehicules = { "voiture", "vélo" };	
		
		// Create instances
		lblLouer = new JLabel(" Louer");
		lblRendre = new JLabel(" Rendre");
		comboLouer = new JComboBoxLocation(vehicules, TypeActionLocation.Louer); //JComboBox<String>(vehicules);
		comboRendre = new JComboBoxLocation(vehicules, TypeActionLocation.Rendre);//JComboBox<String>(vehicules);
		panelLouer = new JPanel();
		panelRendre = new JPanel();
		
		// Add listeners
		comboLouer.addActionListener(this);
		comboRendre.addActionListener(this);
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
		
		user.display();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			@SuppressWarnings("unchecked")
			//JComboBox<String> cbTypeV = (JComboBox<String>)e.getSource();
			JComboBoxLocation cbTypeV = (JComboBoxLocation)e.getSource();
			String typeVehiculeStr = (String)cbTypeV.getSelectedItem();
			
			//Choix action
			if(cbTypeV.getTypeAction() == TypeActionLocation.Louer){
				louer(typeVehiculeStr);
			}
			else if(cbTypeV.getTypeAction() == TypeActionLocation.Rendre){
				rendre(typeVehiculeStr);
			}
			else{
				//Erreur
			}
			
			
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/*
	 * 
	 */
	private void louer(String typeVehiculeStr) throws RemoteException{
		//Choix action
		
		boolean isLouer = false;
		
		// Quel véhicule
		for (TypeVehicule typeVehicule : TypeVehicule.values()) {
			if(typeVehicule.toString().equalsIgnoreCase(typeVehiculeStr)){  //toUpperCase() == typeVehiculeStr.toUpperCase()){
				//isLouer = user.louer(1, typeVehicule);
				isLouer = user.louer(indexStation, typeVehicule);
				break;
			}
		}		
		
		if (isLouer){
			javax.swing.JOptionPane.showMessageDialog(null,"Tu as loué " + typeVehiculeStr); 
		}else{
			javax.swing.JOptionPane.showMessageDialog(null,"Impossible de louer " + typeVehiculeStr); 
		}
	}
	
	/*
	 * 
	 */
	private void rendre(String typeVehiculeStr) throws RemoteException{
		boolean isRendu = false;
		
		isRendu = user.rendre(indexStation);
		
		if (isRendu){
			javax.swing.JOptionPane.showMessageDialog(null,"Tu as rendu " + typeVehiculeStr); 
		}else{
			javax.swing.JOptionPane.showMessageDialog(null,"Impossible de rendre " + typeVehiculeStr); 
		}
	}
}


