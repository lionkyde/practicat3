package net.ciprianlungu.GUI;

import javax.swing.JPanel;

import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JToolBar;

import net.ciprianlungu.modelo.Coche;
import net.ciprianlungu.modelo.GestorCoches;
import net.ciprianlungu.modelo.Marca;
import net.ciprianlungu.modelo.Modelo;
import net.ciprianlungu.modelo.TableModelMarcas;
import net.ciprianlungu.modelo.TableModelModelos;
import net.ciprianlungu.persistencia.GestorBBDDCoche;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.sun.glass.events.MouseEvent;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class CrearBorrarMarca extends JPanel {
	private JTable table;
	ArrayList<Marca> marcas;
	private JTextField tfMarca;
	/**
	 * Create the panel.
	 */
	public CrearBorrarMarca() {
		GestorCoches gc = new GestorCoches();
		
		setBackground(SystemColor.info);
		setLayout(new BorderLayout(0,0));
		
		//CREACION DEL PANEL.
		JPanel panel = new JPanel();
		panel.setBackground(new java.awt.Color(0, 204, 204));
		panel.setForeground(new java.awt.Color(51, 204, 204));
		panel.setBounds(0, 0, 800, 600);
		add(panel,BorderLayout.CENTER);
		panel.setLayout(null);
		
		//TOOLBAR NORTE
		JToolBar toolbar = new JToolBar();
		toolbar.setBackground(Color.WHITE);
		add(toolbar,BorderLayout.NORTH);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(Color.YELLOW);
		
		
		//GUARDAR
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResultado = JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres guardar en la base de datos?",
						"Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(dialogResultado == JOptionPane.YES_OPTION){
					System.out.println("Ejecutado guardar boton");
					String marca = tfMarca.getText();
					
					gc.addMarcas(marca);
				}
			}
		});
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setIcon(new ImageIcon(CrearModelo.class.getResource("/assets/guardar.png")));
		toolbar.add(btnGuardar);
		
		//LIMPIAR
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfMarca.setText("");
			}
		});
		btnLimpiar.setBackground(Color.WHITE);
		btnLimpiar.setIcon(new ImageIcon(CrearModelo.class.getResource("/assets/limpiar.png")));
		
		toolbar.add(btnLimpiar);
		
		//BUSCAR
		JButton btnBuscar = new JButton("Buscar\r\n");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcas = gc.getMarcas();
				
				TableModelMarcas tmm = new TableModelMarcas(marcas);
				table.setModel(new TableModelMarcas(marcas));
			}
		});
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setIcon(new ImageIcon(CrearModelo.class.getResource("/assets/buscar.png")));
		toolbar.add(btnBuscar);
		
		//RECARGAR
		JButton btnRecargar = new JButton("Recargar");
		btnRecargar.setBackground(Color.WHITE);
		btnRecargar.setIcon(new ImageIcon(CrearModelo.class.getResource("/assets/recargar.png")));
		btnRecargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcas = gc.getMarcas();
				
				TableModelMarcas tmm = new TableModelMarcas(marcas);
				table.setModel(new TableModelMarcas(marcas));
			}
		});
		toolbar.add(btnRecargar);
		
		//BORRAR
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(Color.WHITE);
		btnBorrar.setIcon(new ImageIcon(Consultar.class.getResource("/assets/borrar1.png")));
		toolbar.add(btnBorrar);
		

		
		JLabel lblAddMarca = new JLabel("A\u00F1adir marca");
		lblAddMarca.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
		lblAddMarca.setBounds(117, 82, 145, 38);
		panel.add(lblAddMarca);
		
		JLabel lblConsultarMarcas = new JLabel("Todas las marcas");
		lblConsultarMarcas.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
		lblConsultarMarcas.setBounds(530, 12, 164, 14);
		panel.add(lblConsultarMarcas);
		
		//LABEL NOMBRE MARCA
		JLabel lblNombreMarca = new JLabel("Marca:");
		lblNombreMarca.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
		lblNombreMarca.setBounds(10, 155, 79, 14);
		panel.add(lblNombreMarca);
		
		//SCROLLPANE
		JScrollPane scrollPane  = new JScrollPane();
		scrollPane.setBackground(Color.CYAN);
		scrollPane.setLocation(463, 37);
		scrollPane.setSize(310, 433);
		panel.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//TEXTFIELD DE MARCA
		tfMarca = new JTextField();
		tfMarca.setBounds(87, 149, 175, 20);
		panel.add(tfMarca);
		tfMarca.setColumns(10);

		
	}
}
