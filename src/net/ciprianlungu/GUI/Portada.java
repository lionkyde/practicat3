package net.ciprianlungu.GUI;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Portada extends JPanel {
	Mainframe topFrame;
	/**
	 * Create the panel.
	 */
	public Portada() {
		setLayout(null);
		
		//PANEL
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 800, 600);
		add(panel);
		panel.setLayout(null);
		
		//LABEL TEXTO GESTOR COCHES
		JLabel lblNewLabel = new JLabel("GESTOR DE COCHES");
		lblNewLabel.setFont(new Font("Javanese Text", Font.BOLD, 38));
		lblNewLabel.setBounds(219, 0, 515, 61);
		panel.add(lblNewLabel);
		
		//BOTON DE CONSULTAR MARCAS
		JButton btnConsultaMarcas = new JButton("Consulta/Crear/Borrar Marcas");
		btnConsultaMarcas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarConsultaMarca();
			}
		});
		btnConsultaMarcas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultaMarcas.setBounds(345, 189, 221, 23);
		panel.add(btnConsultaMarcas);
		
		//BOTON DE CONSULTAR MODELO
		JButton btnConsultaModelo = new JButton("Consultar/Borrar Modelos");
		btnConsultaModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarConsultaModelo();
			}
		});
		btnConsultaModelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultaModelo.setBounds(345, 228, 221, 23);
		panel.add(btnConsultaModelo);
		
		//BOTON DE CREAR MODELO
		JButton btnCrearModelo = new JButton("Crear modelo");
		btnCrearModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCrearModelo();
			}
		});
		btnCrearModelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrearModelo.setBounds(345, 266, 221, 23);
		panel.add(btnCrearModelo);
		
		//LABEL DE FOTO BACKGROUND
		JLabel lblFoto = new JLabel("");
		lblFoto.setBounds(0, -56, 800, 656);
		lblFoto.setIcon(new ImageIcon(Portada.class.getResource("/assets/logo.gif")));
		panel.add(lblFoto);
		
		
	}
	/**
	 * Mostrador de panel consulta de marca
	 */
	private void mostrarConsultaMarca(){
		topFrame = (Mainframe)SwingUtilities.getWindowAncestor(this);
		topFrame.mostrarConsultaMarca();
		
	}
	/**
	 * Mostrador de panel consulta de modelo
	 */
	private void mostrarConsultaModelo(){
		topFrame = (Mainframe)SwingUtilities.getWindowAncestor(this);
		topFrame.mostrarConsultaModelo();
		
	}
	/**
	 * Mostrador de panel de crear modelo
	 */
	private void  mostrarCrearModelo(){
		topFrame = (Mainframe)SwingUtilities.getWindowAncestor(this);
		topFrame.mostrarCrearModelo();
	}
}
