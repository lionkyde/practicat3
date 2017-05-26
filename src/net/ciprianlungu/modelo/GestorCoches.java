package net.ciprianlungu.modelo;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JSlider;

import net.ciprianlungu.persistencia.GestorBBDDCoche;

public class GestorCoches {
	GestorBBDDCoche gc;
	private int resultado;
	
	public ArrayList<Eficiencia> getEficiencias(){
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		ArrayList<Eficiencia> eficiencias = gc.getEficiencias();
		return eficiencias;
	}
	
	public ArrayList<Modelo> getModelos(){
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		ArrayList<Modelo> modelos = gc.getModelos();
		return modelos;
	}
	public ArrayList<Marca> getMarcas(){
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		ArrayList<Marca> marcas = gc.getMarcas();
		return marcas;
	}
	public ArrayList<Coche> consultaMarcaConsumoCoches(String marca,Float consumo){
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		ArrayList<Coche> coches = gc.getCoches(marca,consumo);
		return coches;
	}
	public void addModelos(int id_marca,String modelo,float consumo,int emisiones,String clasificacion){
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		gc.addModelo(id_marca, modelo, consumo, emisiones, clasificacion);
	}
	public int consultaIdMarca(String modelo){
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		int resultado = gc.consultaIdMarca(modelo);
		return resultado;
	}
	public ArrayList<Coche> consultaTodasMarcas(Float consumo){
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		ArrayList<Coche> coches = gc.consultaTodasMarcas(consumo);
		return coches;
	}
	public int consultaConsumoMaximo(){
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		int resultado = gc.consultaConsumoMaximo();
		return resultado;
	}
	public void borrarModelo(String modelo){
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		gc.borrarModelo(modelo);
	}
}
