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

public class J23App extends JFrame {

	private JPanel contentPane;
	JMenuBar menuBar = new JMenuBar();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					J23App frame = new J23App();
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
	public J23App() {
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
		menuBar.setBackground(SystemColor.menu);
		menuBar.setVisible(false);
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Salir");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnPanel = new JMenu("Panel");
		menuBar.add(mnPanel);
		
		JMenuItem mntmPanel_3 = new JMenuItem("Principal");
		mntmPanel_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)contentPane.getLayout();
				cl.show(contentPane, "Principal");
			}
		});
		mnPanel.add(mntmPanel_3);
		
		JMenuItem mntmPanel_1 = new JMenuItem("Consultar");
		mntmPanel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)contentPane.getLayout();
				cl.show(contentPane, "Consultar");
			}
		});
		mnPanel.add(mntmPanel_1);
		
		JMenuItem mntmPanel = new JMenuItem("Editar");
		mntmPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)contentPane.getLayout();
				cl.show(contentPane, "Editar");
			}
		});
		mnPanel.add(mntmPanel);
		
		JMenu mnHelp = new JMenu("Ayuda");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("Sobre..");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(J23App.this,
					    "Proyecto hecho por Ciprian George Lungu",
					    "Mayo 2017",
					    JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		Panel3 panel3 = new Panel3();
		contentPane.add(panel3,"Principal");
		contentPane.add(new Panel1(),"Consultar");
		contentPane.add(new Panel2(),"Editar");
	}
	
	public void setMenuBarVisible(){
		menuBar.setVisible(true);
		invalidate();
		validate();
		repaint();
	}
	
}
