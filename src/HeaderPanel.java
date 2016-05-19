import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class HeaderPanel extends JPanel {
	JTextPane txtHeader;

	/**
	 * Create the panel.
	 */
	public HeaderPanel() {
		txtHeader = new JTextPane();
		txtHeader.setText("gdfgf");
		add(txtHeader);
	}
}
