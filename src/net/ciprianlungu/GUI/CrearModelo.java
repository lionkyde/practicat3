package net.ciprianlungu.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class CrearModelo extends JPanel {
	private JTextField tfModelo;
	private JTextField tfConsumo;
	private JTextField tfEmisiones;

	/**
	 * Create the panel.
	 */
	public CrearModelo() {
		setLayout(null);
		
		JLabel lblCrearCoches = new JLabel("Insertar modelo\r\n");
		lblCrearCoches.setBounds(306, 5, 188, 28);
		lblCrearCoches.setFont(new Font("Tahoma", Font.BOLD, 23));
		add(lblCrearCoches);
		
		JLabel lblNewLabel = new JLabel("Marca:");
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel.setBounds(63, 92, 63, 33);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Modelo:");
		lblNewLabel_1.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_1.setBounds(56, 137, 70, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Consumo:");
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_2.setBounds(52, 173, 90, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Emisiones:");
		lblNewLabel_3.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_3.setBounds(32, 203, 110, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Calificacion Energetica:");
		lblNewLabel_4.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_4.setBounds(29, 246, 259, 14);
		add(lblNewLabel_4);
		
		JComboBox comboBoxMarca = new JComboBox();
		comboBoxMarca.setBounds(136, 100, 127, 20);
		add(comboBoxMarca);
		
		tfModelo = new JTextField();
		tfModelo.setBounds(136, 136, 259, 20);
		add(tfModelo);
		tfModelo.setColumns(10);
		
		tfConsumo = new JTextField();
		tfConsumo.setBounds(136, 172, 42, 20);
		add(tfConsumo);
		tfConsumo.setColumns(10);
		
		tfEmisiones = new JTextField();
		tfEmisiones.setBounds(136, 202, 42, 20);
		add(tfEmisiones);
		tfEmisiones.setColumns(10);
		
		JComboBox comboBoxCEnergetica = new JComboBox();
		comboBoxCEnergetica.setBounds(276, 245, 119, 20);
		add(comboBoxCEnergetica);

	}

}
