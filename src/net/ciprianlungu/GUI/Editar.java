package net.ciprianlungu.GUI;

import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;

import net.ciprianlungu.modelo.GestorCoches;
import net.ciprianlungu.modelo.Marca;
import net.ciprianlungu.modelo.Modelo;
import net.ciprianlungu.persistencia.GestorBBDDCoche;

public class Editar extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public Editar() {
		GestorCoches gc = new GestorCoches();
		ArrayList<Modelo> modelos = gc.getModelos();
		ArrayList<Marca> marcas = gc.getMarcas();
		
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(104, 63, 201, 20);
		for(Marca marcaa : marcas){
			comboBox.addItem(marcaa.getMarca());
		}
		add(comboBox);
		
		//PRUEBA
			
		//PRUEBA
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblMarca.setBounds(40, 64, 75, 14);
		add(lblMarca);

	}
}
