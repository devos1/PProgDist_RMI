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
	private int idStation;
	JLabel lblLouer, lblRendre;
	JComboBox<String> comboLouer;
	JComboBox<String> comboRendre;
	JPanel panelLouer, panelRendre;
	
	/**
	 * CONSTRUCTEUR
	 * @param user
	 * @param idStation
	 * @throws RemoteException
	 */
	public StationFooterPanel(Utilisateur user, int idStation) throws RemoteException {
		this.user = user;
		this.idStation = idStation;
		setLayout(new GridLayout(0, 2));
		
		String[] vehicules = { "voiture", "vélo" };	
		
		// Create instances
		lblLouer = new JLabel(" Louer");
		lblRendre = new JLabel(" Rendre");
		comboLouer = new JComboBoxLocation(vehicules, TypeActionLocation.Louer); 
		comboRendre = new JComboBoxLocation(vehicules, TypeActionLocation.Rendre);
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

	/**
	 * Evénement du chois dans les listebox
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			@SuppressWarnings("unchecked")
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
	
	
	/**
	 * Louer un véhicule
	 * Appeler les méthodes de la classe utilisateur
	 * @param typeVehiculeStr
	 * @throws RemoteException
	 */
	private void louer(String typeVehiculeStr) throws RemoteException{
		//Choix action
		
		boolean isLouer = false;
		
		// Quel véhicule
		for (TypeVehicule typeVehicule : TypeVehicule.values()) {
			if(typeVehicule.toString().equalsIgnoreCase(typeVehiculeStr)){  
				isLouer = user.louer(idStation, typeVehicule);
				break;
			}
		}		
		
		if (isLouer){
			javax.swing.JOptionPane.showMessageDialog(null,"Tu as loué " + typeVehiculeStr); 
		}else{
			javax.swing.JOptionPane.showMessageDialog(null,"Impossible de louer " + typeVehiculeStr); 
		}
	}
	
	
	/**
	 * Rendre un véhicule en cours de location
	 * @param typeVehiculeStr
	 * @throws RemoteException
	 */
	private void rendre(String typeVehiculeStr) throws RemoteException{
		boolean isRendu = false;
		
		// Quel véhicule
		for (TypeVehicule typeVehicule : TypeVehicule.values()) {
			if(typeVehicule.toString().equalsIgnoreCase(typeVehiculeStr)){ 
				isRendu = user.rendre(idStation, typeVehicule);
				break;
			}
		}
		
		if (isRendu){
			javax.swing.JOptionPane.showMessageDialog(null,"Tu as rendu " + typeVehiculeStr); 
		}else{
			javax.swing.JOptionPane.showMessageDialog(null,"Impossible de rendre " + typeVehiculeStr); 
		}
	}
}


