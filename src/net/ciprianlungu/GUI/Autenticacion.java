package net.ciprianlungu.GUI;

import javax.swing.JOptionPane;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import net.ciprianlungu.persistencia.GestorBBDD;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Autenticacion extends JPanel {
	private JTextField tfUsuario;
	private JPasswordField passwordField;
	/**
	 * Create the panel.
	 */
	public Autenticacion() {
		setBackground(SystemColor.inactiveCaption);
		setLayout(null);
		
		//LABEL USUARIO
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(242, 133, 78, 21);
		add(lblUsuario);
		
		//LABEL PASSWORD
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setBounds(242, 165, 87, 14);
		add(lblPassword);
		
		//LABEL TITULO
		JLabel lblGestionMotor = new JLabel("GESTION MOTOR");
		lblGestionMotor.setFont(new Font("Tahoma", Font.BOLD, 41));
		lblGestionMotor.setBounds(242, 11, 370, 53);
		add(lblGestionMotor);
		
		//CAMPO DE RELLENO USUARIO
		tfUsuario = new JTextField();
		tfUsuario.setBounds(351, 133, 128, 20);
		add(tfUsuario);
		tfUsuario.setColumns(10);
		
		//BOTON DE ENTRAR
		//RECOGIDA DE DATOS DE USUARIO Y CONTRASEÑA Y VALIDARLO.
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setMenuBarVisible();
				String usuario = tfUsuario.getText();
				String password = String.valueOf(passwordField.getPassword());
				GestorBBDD gestor = new GestorBBDD(usuario,password,"localhost","bbdd_gestmotor");
				try {
					gestor.establecerConexion();
					gestor.cerrarConexion();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"Error de carga de driver");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"Error a la base de datos1");
					e.printStackTrace();
				}
				
				
				removeAll();
				JOptionPane.showMessageDialog(null,"Has entrado con éxito","Éxito",JOptionPane.WARNING_MESSAGE);

			}
		});
		
		
		//TAMANO DE BOTON
		btnEntrar.setBounds(359, 281, 91, 23);
		add(btnEntrar);
		
		
		//CONTRASENIA
		passwordField = new JPasswordField();
		passwordField.setBounds(351, 162, 128, 20);
		add(passwordField);
		
		
	}
	private void setMenuBarVisible(){
		Mainframe topFrame = (Mainframe)SwingUtilities.getWindowAncestor(this);
		topFrame.setMenuBarVisible();
	}
}
