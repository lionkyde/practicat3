package net.ciprianlungu.GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;

public class Mainframe extends JFrame {

	private JPanel contentPane;
	JMenuBar menuBar = new JMenuBar();
	Autenticacion autenticacion;
	CrearModelo crearModelo;
	Consultar consulta;
	CrearBorrarMarca crearMarca;
	Portada portada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe frame = new Mainframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mainframe() {
		//Imagen icono del software
		setIconImage(new ImageIcon(Portada.class.getResource("/assets/icon.png")).getImage());
		//JFRAME
		setResizable(false);
		setBackground(Color.GREEN);
		getContentPane().setLayout(new CardLayout(0, 0));
		setTitle("Gestion coches");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 800, 600);
		
		//CAMBIO DE LOOK&FEEL A WINDOWS
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Windows".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		//Bara menu
		menuBar.setBackground(SystemColor.menu);
		menuBar.setVisible(false);
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		//JMENU SALIR
		JMenuItem mntmExit = new JMenuItem("Salir");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		//JMENU PANEL
		JMenu mnPanel = new JMenu("Panel");
		menuBar.add(mnPanel);

		//JMENU CONSULTAR
		JMenuItem mntmPanel_1 = new JMenuItem("Consultar");
		mntmPanel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)contentPane.getLayout();
				cl.show(contentPane, "Consultar");
			}
		});
		mnPanel.add(mntmPanel_1);
		
		//JMENU CREAR MODELOS
		JMenuItem mntmPanel_2 = new JMenuItem("Crear Modelos");
		mntmPanel_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout cl = (CardLayout)contentPane.getLayout();
				cl.show(contentPane, "CrearModelo");
			}
		});
		mnPanel.add(mntmPanel_2);
		
		//JMENU CREAR/BORRAR MARCAS
		JMenuItem mntmPanel_3 = new JMenuItem("Crear/Borrar Marcas");
		mntmPanel_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout cl = (CardLayout)contentPane.getLayout();
				cl.show(contentPane,"CrearBorrarMarca");
			}
		});
		mnPanel.add(mntmPanel_3);
		
		
		//JMENU AYUDA
		JMenu mnHelp = new JMenu("Ayuda");
		menuBar.add(mnHelp);
		
		//JMENU ITEM SOBRE..DE AYUDA
		JMenuItem mntmAbout = new JMenuItem("Sobre..");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Mainframe.this,
					    "Proyecto hecho por Ciprian George Lungu",
					    "Mayo 2017",
					    JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmAbout);
		
		//PANEL
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		autenticacion = new Autenticacion();
		crearModelo = new CrearModelo();
		consulta = new Consultar();
		crearMarca = new CrearBorrarMarca();
		portada = new Portada();
		
		contentPane.add(autenticacion,"Principal");
		contentPane.add(crearModelo,"CrearModelo");
		contentPane.add(consulta,"Consultar");
		contentPane.add(crearMarca,"CrearBorrarMarca");
		contentPane.add(portada,"Portada");
	}
	/**
	 * Hacer visible el menuBar, por defecto viene escondido.
	 * Se utiliza para aparecer despues de autentificarse
	 */
	public void setMenuBarVisible(){
		menuBar.setVisible(true);
		invalidate();
		validate();
		repaint();
	}
	/**
	 * Mostrador de portada
	 */
	public void mostrarPortada(){
		//TODO AQUI CREAREMOS PARA IR A PORTADA
		CardLayout cl = (CardLayout)contentPane.getLayout();
		cl.show(contentPane,"Portada");
	}
	/**
	 * Mostrador de consulta Marca
	 */
	public void mostrarConsultaMarca(){
		CardLayout c2 = (CardLayout)contentPane.getLayout();
		c2.show(contentPane,"CrearBorrarMarca");
	}
	/**
	 * Mostrador de consulta de modelo
	 */
	public void mostrarConsultaModelo(){
		CardLayout c3 = (CardLayout)contentPane.getLayout();
		c3.show(contentPane,"Consultar");
	}
	/**
	 * Mostrador de crear modelo
	 */
	public void mostrarCrearModelo(){
		CardLayout c4 = (CardLayout)contentPane.getLayout();
		c4.show(contentPane,"CrearModelo");
	}
}
