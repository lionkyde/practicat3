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
	public ArrayList<Coche> consultaMarcaConsumoCoches(Float consumo){
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		ArrayList<Coche> coches = gc.getCoches(consumo);
		return coches;
	}
	public void addModelos(int id_marca,String modelo,float consumo,int emisiones,String clasificacion){
		GestorBBDDCoche gestor = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		gestor.addModelo(id_marca, modelo, consumo, emisiones, clasificacion);
	}
	public int consultaIdMarca(String modelo){
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		int resultado = gc.consultaIdMarca(modelo);
		return resultado;
	}
	

	public void setConsumo(int i){
		this.resultado = i;
	}
	public int getConsumo(){
		return resultado;
	}
}
