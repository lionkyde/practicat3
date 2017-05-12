package net.ciprianlungu.GUI;


import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Panel1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel1() {
		setBackground(SystemColor.info);
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Panel1.class.getResource("/assets/CD.jpg")));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(Panel1.class.getResource("/assets/Android Smartphone.jpg")));
		toolBar.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Panel1.class.getResource("/assets/Microphone 1.jpg")));
		toolBar.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		add(panel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);

	}
}
