import javax.swing.JComboBox;

public class JComboBoxLocation extends JComboBox<String> {
	private static final long serialVersionUID = 1L;
	
	private TypeActionLocation typeAction;
	private String[] vehicule;
	
	public JComboBoxLocation(String[] vehicules, TypeActionLocation typeaction) {
		super(vehicules);
		
		this.vehicule = vehicules;
		this.typeAction = typeaction;
		
	}

	public TypeActionLocation getTypeAction() {
		return typeAction;
	}

}
