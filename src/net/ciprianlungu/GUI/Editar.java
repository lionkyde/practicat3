package net.ciprianlungu.GUI;


import javax.swing.JPanel;


import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;

public class Editar extends JPanel {

	/**
	 * Create the panel.
	 */
	public Editar() {
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(104, 63, 201, 20);
		add(comboBox);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblMarca.setBounds(40, 64, 75, 14);
		add(lblMarca);

	}
}
