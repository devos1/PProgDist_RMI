import javax.swing.JComboBox;

public class JComboBoxLocation extends JComboBox<String> {
	private static final long serialVersionUID = 1L;
	
	private TypeActionLocation typeAction;
	private String[] vehicule;
	
	/**
	 * Constructeur
	 * @param vehicules
	 * @param typeaction
	 */
	public JComboBoxLocation(String[] vehicules, TypeActionLocation typeaction) {
		super(vehicules);
		
		this.setVehicule(vehicules);
		this.typeAction = typeaction;
		
	}

	/**
	 * REtourne le type d'action de location (louer ou rendre)
	 * @return
	 */
	public TypeActionLocation getTypeAction() {
		return typeAction;
	}

	/**
	 * Retourne le véhicule
	 * @return
	 */
	public String[] getVehicule() {
		return vehicule;
	}

	/**
	 * Change le véhicule
	 * @param vehicule
	 */
	public void setVehicule(String[] vehicule) {
		this.vehicule = vehicule;
	}

}
