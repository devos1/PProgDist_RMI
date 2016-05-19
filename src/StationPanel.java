import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextPane;

import com.apple.dnssd.TXTRecord;

public class StationPanel extends JPanel {

	JTextPane txtTitle;

	/**
	 * Create the panel.
	 */
	public StationPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		txtTitle = new JTextPane();
		txtTitle.setText("STATION ...");
		txtTitle.setBackground(Color.darkGray);
		txtTitle.setForeground(Color.white);
		add(txtTitle, BorderLayout.NORTH);

	}

}
