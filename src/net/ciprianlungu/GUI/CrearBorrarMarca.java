package net.ciprianlungu.GUI;

import java.awt.BorderLayout;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Color;

public class CrearBorrarMarca extends JPanel {

	/**
	 * Create the panel.
	 */
	public CrearBorrarMarca() {
		setBackground(SystemColor.info);
		setLayout(new BorderLayout(0,0));
		
		//TOOLBAR NORTE
		JToolBar toolbar = new JToolBar();
		toolbar.setBackground(Color.WHITE);
		add(toolbar,BorderLayout.NORTH);
		
		//GUARDAR
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setIcon(new ImageIcon(CrearModelo.class.getResource("/assets/guardar.png")));
		toolbar.add(btnGuardar);
		
		//LIMPIAR
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(Color.WHITE);
		btnLimpiar.setIcon(new ImageIcon(CrearModelo.class.getResource("/assets/limpiar.png")));
		toolbar.add(btnLimpiar);
		
		//BUSCAR
		JButton btnBuscar = new JButton("Buscar\r\n");
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setIcon(new ImageIcon(CrearModelo.class.getResource("/assets/buscar.png")));
		toolbar.add(btnBuscar);
		
		//RECARGAR
		JButton btnRecargar = new JButton("Recargar");
		btnRecargar.setBackground(Color.WHITE);
		btnRecargar.setIcon(new ImageIcon(CrearModelo.class.getResource("/assets/recargar.png")));
		toolbar.add(btnRecargar);
		
		//BORRAR
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(Color.WHITE);
		btnBorrar.setIcon(new ImageIcon(Consultar.class.getResource("/assets/borrar1.png")));
		toolbar.add(btnBorrar);
		
		//CREACION DEL PANEL.
		JPanel panel = new JPanel();
		panel.setBackground(new java.awt.Color(0, 204, 204));
		panel.setForeground(new java.awt.Color(51, 204, 204));
		panel.setBounds(0, 0, 800, 600);
		add(panel,BorderLayout.CENTER);
		panel.setLayout(null);
	}
}
