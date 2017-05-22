package net.ciprianlungu.GUI;


import javax.swing.JPanel;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import net.ciprianlungu.modelo.GestorCoches;
import net.ciprianlungu.modelo.Marca;
import net.ciprianlungu.modelo.Modelo;
import net.ciprianlungu.modelo.TableModelModelos;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

public class Consultar extends JPanel {
	private JTable JtModelos;
	/**
	 * Create the panel.
	 */
	public Consultar() {
		GestorCoches gc = new GestorCoches();
		
		
		setBackground(SystemColor.info);
		setLayout(new BorderLayout(0, 0));
		
		//TOOLBAR
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		//BOTON DE CONSULTAR
		JButton btnConsultar = new JButton("");
		toolBar.add(btnConsultar);
		btnConsultar.setIcon(new ImageIcon(Consultar.class.getResource("/assets/Search.jpg")));
		
		
		//CREACION DE PANEL
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		//LABEL DE MARCA
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Verdana", Font.BOLD, 15));
		lblMarca.setBounds(10, 24, 56, 14);
		panel.add(lblMarca);
		
		
		//LABEL DE CONSUMO MAXIMO
		JLabel lblNewLabel = new JLabel("Consumo m\u00E1ximo:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel.setBounds(298, 24, 187, 14);
		panel.add(lblNewLabel);
		
		//COMBOBOX DE MARCAS
		ArrayList<Marca> marcas = gc.getMarcas();
		JComboBox comboBoxMarca = new JComboBox();
		comboBoxMarca.setBounds(74, 23, 201, 20);
		for(Marca marcaa : marcas){
			comboBoxMarca.addItem(marcaa.getMarca());
		}
		panel.add(comboBoxMarca);
		
		//SLIDER DE CONSUMO MAXIMO
		JSlider sliderConsumo = new JSlider();
		sliderConsumo.setMajorTickSpacing(2);
		sliderConsumo.setToolTipText("");
		sliderConsumo.setPaintLabels(true);
		sliderConsumo.setPaintTicks(true);
		sliderConsumo.setValue(0);
		sliderConsumo.setMinorTickSpacing(2);
		sliderConsumo.setMaximum(30);
		sliderConsumo.setBounds(451, 11, 316, 41);
		panel.add(sliderConsumo);
		
		//JTABLE DE MODELOS
		JtModelos = new JTable();
		JtModelos.setBackground(SystemColor.activeCaption);
		JtModelos.setBounds(10, 73, 780, 457);
		panel.add(JtModelos);
		//TODO HACER SCROLL PARA LA TABLA Y UN ARRAYLIST DE CONSULTA ESPECIFICA
		
		ArrayList<Modelo> modelos = gc.getModelos();
		
		TableModelModelos tmm = new TableModelModelos(modelos,marcas);
		JtModelos.setModel(new TableModelModelos(modelos,marcas));
	}
}
