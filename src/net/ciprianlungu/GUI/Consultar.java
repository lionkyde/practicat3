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

import net.ciprianlungu.modelo.Coche;
import net.ciprianlungu.modelo.GestorCoches;
import net.ciprianlungu.modelo.Marca;
import net.ciprianlungu.modelo.Modelo;
import net.ciprianlungu.modelo.TableModelModelos;
import net.ciprianlungu.persistencia.GestorBBDDCoche;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Consultar extends JPanel {
	private JTable JtModelos;
	private JTable table;
	JSlider sliderConsumo = new JSlider();
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
		
		//CREACION DE PANEL
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//BOTON DE CONSULTAR
		JButton btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//gc.setConsumo();

				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 48, 450, 187);
				panel.add(scrollPane);
				table = new JTable();
				scrollPane.setViewportView(table);
				
				table.setBackground(Color.YELLOW);
				table.setBounds(10, 73, 780, 457);
				
				float consumoParseado= (float)sliderConsumo.getValue();
				
				ArrayList<Coche> coches = gc.consultaMarcaConsumoCoches(consumoParseado);
				//TODO FALTA PASAR PARAMETRO DE MARCAS PARA CONSULTA
				
				TableModelModelos tmm = new TableModelModelos(coches);
				table.setModel(new TableModelModelos(coches));
			}
		});
		toolBar.add(btnConsultar);
		btnConsultar.setIcon(new ImageIcon(Consultar.class.getResource("/assets/Search.jpg")));
		
		

		
		
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
		
		sliderConsumo.setMajorTickSpacing(2);
		sliderConsumo.setToolTipText("");
		sliderConsumo.setPaintLabels(true);
		sliderConsumo.setPaintTicks(true);
		sliderConsumo.setValue(0);
		sliderConsumo.setMinorTickSpacing(2);
		sliderConsumo.setMaximum(30);
		sliderConsumo.setBounds(451, 11, 316, 41);
		
		panel.add(sliderConsumo);
		
		//SCROLLPANE CON JTABLE

		
		
	}
}
