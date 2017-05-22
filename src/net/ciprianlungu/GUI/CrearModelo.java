package net.ciprianlungu.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.sun.prism.paint.Color;

import net.ciprianlungu.modelo.Eficiencia;
import net.ciprianlungu.modelo.GestorCoches;
import net.ciprianlungu.modelo.Marca;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearModelo extends JPanel {
	private JTextField tfModelo;
	private JTextField tfConsumo;
	private JTextField tfEmisiones;
	GestorCoches gc = new GestorCoches();
	/**
	 * Create the panel.
	 */
	public CrearModelo() {
		setBackground(SystemColor.info);	
		setLayout(new BorderLayout(0,0));
		
		//TOOLBAR NORTE
		JToolBar toolbar = new JToolBar();
		toolbar.setBackground(java.awt.Color.LIGHT_GRAY);
		add(toolbar,BorderLayout.NORTH);
		
		//CREACION DEL PANEL.
		JPanel panel = new JPanel();
		panel.setBackground(new java.awt.Color(0, 204, 204));
		panel.setForeground(new java.awt.Color(51, 204, 204));
		panel.setBounds(0, 0, 800, 600);
		add(panel,BorderLayout.CENTER);
		panel.setLayout(null);
		
		//COMBO DE MARCAS
		ArrayList<Marca> marcas = gc.getMarcas();
		JComboBox comboBoxMarca = new JComboBox();
		comboBoxMarca.setBounds(135, 71, 130, 20);
		for(Marca marcaa : marcas){
			comboBoxMarca.addItem(marcaa.getMarca());
		}
		panel.add(comboBoxMarca);
		
		//COMBO DE CALIFICACION ENERGETICA
		ArrayList<Eficiencia> eficiencias = gc.getEficiencias();
		JComboBox comboBoxCEnergetica = new JComboBox();
		comboBoxCEnergetica.setBounds(276, 292, 45, 20);
		for(Eficiencia eficienciaa : eficiencias){
			comboBoxCEnergetica.addItem(eficienciaa.getCalificacion());
		}
		panel.add(comboBoxCEnergetica);
		
		
		//TEXTFIELD DE MODELO
		tfModelo = new JTextField();
		tfModelo.setBounds(135, 122, 270, 20);
		panel.add(tfModelo);
		tfModelo.setColumns(10);
		
		//TEXTFIELD DE CONSUMO
		tfConsumo = new JTextField();
		tfConsumo.setBounds(135, 172, 45, 20);
		panel.add(tfConsumo);
		tfConsumo.setColumns(10);
		
		//TEXTFIELD DE EMISIONES
		tfEmisiones = new JTextField();
		tfEmisiones.setBounds(135, 232, 45, 20);
		panel.add(tfEmisiones);
		tfEmisiones.setColumns(10);
		
		
		//BOTON GUARDAR
		JButton JbGuardar = new JButton("");
		JbGuardar.setBackground(java.awt.Color.LIGHT_GRAY);
		toolbar.add(JbGuardar);
		JbGuardar.setIcon(new ImageIcon(CrearModelo.class.getResource("/assets/Save.jpg")));
		JbGuardar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int dialogResultado = JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres meter?",
						"Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if(dialogResultado == JOptionPane.YES_OPTION){
					System.out.println("Ejecutado consulta id_marca");
					GestorCoches gc = new GestorCoches();
					
					String marca = String.valueOf(comboBoxMarca.getSelectedItem()); //Combo seleccionado
					int idMarcaResultado = gc.consultaIdMarca(marca); //guardamos la idMarca del combo seleccionado
					
					String modeloResultado = tfModelo.getText();
					
					String consumoResultado = tfConsumo.getText();
					Float consumoParsed = Float.parseFloat(consumoResultado);
					
					String emisionesResultado = tfEmisiones.getText();
					int emisionesParsed = Integer.parseInt(emisionesResultado);
					
					String clasificacionResultado = String.valueOf(comboBoxCEnergetica.getSelectedItem());
					
					gc.addModelos(idMarcaResultado, modeloResultado, consumoParsed, emisionesParsed, clasificacionResultado);
					
					JOptionPane.showMessageDialog(null, "Añadido con éxito en la base de datos");
					
				}else{
					tfModelo.setText("");
					tfConsumo.setText("");
					tfEmisiones.setText("");
				}
			}
		});
		JbGuardar.setBounds(127, 291, 53, 54);
		

		
		
		//BOTON LIMPIAR
		JButton JbLimpiar = new JButton("");
		JbLimpiar.setBackground(java.awt.Color.LIGHT_GRAY);
		toolbar.add(JbLimpiar);
		JbLimpiar.setIcon(new ImageIcon(CrearModelo.class.getResource("/assets/Power - Restart.jpg")));
		JbLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfModelo.setText("");
				tfConsumo.setText("");
				tfEmisiones.setText("");
			}
		});
		JbLimpiar.setBounds(197, 291, 53, 54);
		
		
		//LABEL MARCA
		JLabel lblNewLabel = new JLabel("Marca:");
		lblNewLabel.setBounds(65, 70, 60, 20);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 17));
		
		
		//LABEL CONSUMO
		JLabel lblNewLabel_2 = new JLabel("Consumo:");
		lblNewLabel_2.setBounds(45, 170, 80, 20);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 17));
		
		
		//LABEL EMISIONES
		JLabel lblNewLabel_3 = new JLabel("Emisiones:");
		lblNewLabel_3.setBounds(25, 230, 100, 20);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("SimSun", Font.BOLD, 17));
		
		//LABEL INSERTAR MODELO
		JLabel lblCrearCoches = new JLabel("Insertar modelo\r\n");
		panel.add(lblCrearCoches);
		lblCrearCoches.setBounds(300, 0, 254, 46);
		lblCrearCoches.setFont(new Font("Lucida Console", Font.BOLD, 23));
		
		//LABEL MODELO
		JLabel lblNewLabel_1 = new JLabel("Modelo:");
		lblNewLabel_1.setBounds(55, 120, 70, 20);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("SimSun", Font.BOLD, 17));
		
		//LABEL CALIFICACION ENERGETICA
		JLabel lblNewLabel_4 = new JLabel("Calificacion Energetica:");
		lblNewLabel_4.setBounds(25, 290, 240, 20);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("SimSun", Font.BOLD, 17));
		

	}
}
/* 				
 */