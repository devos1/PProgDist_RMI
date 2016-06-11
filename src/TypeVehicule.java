import java.io.Serializable;

/*
 * 
 */
public enum TypeVehicule implements Serializable{
	Voiture{
		public String toString() {
	        return "Voiture";
	    }
	},
	Velo{
		public String toString() {
	        return "Vélo";
	    }
	};
	
	private static final long serialVersionUID = 1L;
	   

}
