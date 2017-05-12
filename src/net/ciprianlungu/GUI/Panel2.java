package net.ciprianlungu.GUI;


import javax.swing.JPanel;


import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel2() {
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		JLabel lblPanel = new JLabel("PANEL 2");
		lblPanel.setBounds(205, 5, 40, 14);
		add(lblPanel);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
			}
		});
		btnBuscar.setBounds(205, 49, 91, 23);
		add(btnBuscar);

	}
}
