package net.ciprianlungu.modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JSlider;

import net.ciprianlungu.persistencia.GestorBBDDCoche;

public class GestorCoches {
	GestorBBDDCoche gc;
	private int resultado;
	
	public ArrayList<Eficiencia> getEficiencias() throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		ArrayList<Eficiencia> eficiencias = gc.getEficiencias();
		return eficiencias;
	}
	
	public ArrayList<Modelo> getModelos() throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		ArrayList<Modelo> modelos = gc.getModelos();
		return modelos;
	}
	public ArrayList<Marca> getMarcas() throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		ArrayList<Marca> marcas = gc.getMarcas();
		return marcas;
	}
	public ArrayList<Coche> consultaMarcaConsumoCoches(String marca,Float consumo) throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		ArrayList<Coche> coches = gc.getCoches(marca,consumo);
		return coches;
	}
	public void addModelos(int id_marca,String modelo,float consumo,int emisiones,String clasificacion) throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		gc.addModelo(id_marca, modelo, consumo, emisiones, clasificacion);
	}
	//TODO FALTA CREAR EL METODO PARA AÑADIR LAS MARCAS
	public int consultaIdMarca(String modelo) throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		int resultado = gc.consultaIdMarca(modelo);
		return resultado;
	}
	public ArrayList<Coche> consultaTodasMarcas(Float consumo) throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		ArrayList<Coche> coches = gc.consultaTodasMarcas(consumo);
		return coches;
	}
	public int consultaConsumoMaximo() throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		int resultado = gc.consultaConsumoMaximo();
		return resultado;
	}
	public void borrarModelo(String modelo) throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		gc.borrarModelo(modelo);
	}
}
