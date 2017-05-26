package net.ciprianlungu.GUI;


import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.sun.glass.events.MouseEvent;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Consultar extends JPanel {
	private JTable table;
	JSlider sliderConsumo = new JSlider();
	JComboBox comboBoxMarca = new JComboBox();
	JButton btnBorrar = new JButton("");
	ArrayList<Coche> coches;
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
		
		//COMBOBOX DE MARCAS
		ArrayList<Marca> marcas;
		String todasMarcas="Todas las marcas";
		try {
			marcas = gc.getMarcas();
			
			comboBoxMarca.setBounds(74, 23, 201, 20);
			comboBoxMarca.addItem(todasMarcas);
			for(Marca marcaa : marcas){
				comboBoxMarca.addItem(marcaa.getMarca());
			}	
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null,"Error del driver");
			e1.printStackTrace();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null,"Error en la base de datos 2");
			e1.printStackTrace();
		}
		panel.add(comboBoxMarca);
		
		//BOTON DE CONSULTAR
		
		
		JButton btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String marca=(String)comboBoxMarca.getSelectedItem(); //el item de comboMarca seleccionado
				float consumoParseado= (float)sliderConsumo.getValue(); //valor del slider pasamos al float
				if(todasMarcas.equals(marca)){
					try {
						coches = gc.consultaTodasMarcas(consumoParseado);
					} catch (ClassNotFoundException e) {
						JOptionPane.showMessageDialog(null,"Error del driver");
						e.printStackTrace();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null,"Error de base de datos 3");
						e.printStackTrace();
					}
					System.out.println("IMPRIMIENDO TODAS LAS MARCAS");
				}else{
					System.out.println("Imprimiendo por marca");
					
					try {
						coches = gc.consultaMarcaConsumoCoches(marca,consumoParseado);
					} catch (ClassNotFoundException e) {
						JOptionPane.showMessageDialog(null,"Error del driver");
						e.printStackTrace();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null,"Error de la base de datos 4");
						e.printStackTrace();
					}

				}
				TableModelModelos tmm = new TableModelModelos(coches);
				table.setModel(new TableModelModelos(coches));
			}
		});
		toolBar.add(btnConsultar);
		btnConsultar.setIcon(new ImageIcon(Consultar.class.getResource("/assets/Search.jpg")));
		
		//BOTON DE RECARGAR
		JButton btnRecargar = new JButton("");
		btnRecargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String marca=(String)comboBoxMarca.getSelectedItem(); //el item de comboMarca seleccionado
				float consumoParseado= (float)sliderConsumo.getValue(); //valor del slider pasamos al float
				if(todasMarcas.equals(marca)){
					try {
						coches = gc.consultaTodasMarcas(consumoParseado);
					} catch (ClassNotFoundException e1) {
						JOptionPane.showMessageDialog(null,"Error del driver");
						e1.printStackTrace();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,"Error de la base de datos 5");
						e1.printStackTrace();
					}
					System.out.println("IMPRIMIENDO TODAS LAS MARCAS");
				}else{
					System.out.println("Imprimiendo por marca");
					
					try {
						coches = gc.consultaMarcaConsumoCoches(marca,consumoParseado);
					} catch (ClassNotFoundException e1) {
						JOptionPane.showMessageDialog(null,"Error del driver");
						e1.printStackTrace();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,"Error de la base de datos 6");
						e1.printStackTrace();
					}
					
				}
				TableModelModelos tmm = new TableModelModelos(coches);
				table.setModel(new TableModelModelos(coches));
			}
		});
		toolBar.add(btnRecargar);
		btnRecargar.setIcon(new ImageIcon(Consultar.class.getResource("/assets/Power - Restart.jpg")));
		
		//LABEL DE MARCA
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Verdana", Font.BOLD, 15));
		lblMarca.setBounds(10, 24, 56, 14);
		panel.add(lblMarca);
		
		
		//LABEL DE CONSUMO MAXIMO
		JLabel lblNewLabel = new JLabel("Consumo m\u00E1ximo:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel.setBounds(431, 0, 160, 14);
		panel.add(lblNewLabel);
		

		
		JLabel lblMostradoConsumo = new JLabel();
		lblMostradoConsumo.setBounds(588, 0, 36, 20);
		panel.add(lblMostradoConsumo);
		
		JLabel lblConsumoMin = new JLabel("0");
		lblConsumoMin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConsumoMin.setBounds(371, 24, 11, 22);
		panel.add(lblConsumoMin);
		
		JLabel lblConsumoMaximo = new JLabel();

		lblConsumoMaximo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConsumoMaximo.setBounds(718, 23, 59, 29);
		panel.add(lblConsumoMaximo);
		sliderConsumo.setMaximum(1000);
		//CADA VEZ QUE EL ESTADO DE SLIDER CAMBIA, CAMBIA EL TEXTO DE JLABEL.
		sliderConsumo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblMostradoConsumo.setText(Integer.toString(sliderConsumo.getValue()));
				try {
					lblConsumoMaximo.setText(Float.toString(gc.consultaConsumoMaximo()));
					sliderConsumo.setMaximum(gc.consultaConsumoMaximo());
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null,"Error del driver");
					e.printStackTrace();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"Error de la base de datos 7");
					e.printStackTrace();
				}
				
			}
		});
		
		//SLIDER DE CONSUMO MAXIMO
		
		sliderConsumo.setMajorTickSpacing(2);
		sliderConsumo.setToolTipText("");	
		sliderConsumo.setMinorTickSpacing(2);
		try {
			sliderConsumo.setValue(gc.consultaConsumoMaximo());
			System.out.println(gc.consultaConsumoMaximo());
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null,"Error de driver");
			e1.printStackTrace();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null,"Error de la base de datos 8");
			e1.printStackTrace();
		}
		

		sliderConsumo.setBounds(392, 23, 316, 41);
		
		panel.add(sliderConsumo);
		
		//SCROLLPANE CON JTABLE
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 72, 777, 410);
		panel.add(scrollPane);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent lse) {
				if(lse.getValueIsAdjusting()){ //sin este metodo, el ListSelectionEvent invoca dos veces los metodos de abajo
				


				}
				toolBar.add(btnBorrar);
				btnBorrar.setIcon(new ImageIcon(Consultar.class.getResource("/assets/delete.png")));	
			}
		});
		System.out.println("Entrando");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogResultado = JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres borrar?",
						"Confirmacion de borrado",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(dialogResultado == JOptionPane.YES_OPTION){
					int row = table.getSelectedRow();
					String modeloSeleccionado=(String)table.getValueAt(row,1); //FILA Y COLUMNA(AMBOS CUENTAN DESDE 0,1,2,3..)
					System.out.println(modeloSeleccionado);
					try {
						gc.borrarModelo(modeloSeleccionado);
					} catch (ClassNotFoundException e) {
						JOptionPane.showMessageDialog(null,"Error de la carga de driver");
						e.printStackTrace();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null,"Error de la base de datos 9");
						e.printStackTrace();
					}
					System.out.println("BORRADO CON EXITO");
				}else{
					System.out.println("He salido");
				}
			}
		});
		
		
		table.setBackground(Color.YELLOW);
		table.setBounds(10, 73, 780, 457);
		
		
	}
}
