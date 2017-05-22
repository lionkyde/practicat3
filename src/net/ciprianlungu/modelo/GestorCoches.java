package net.ciprianlungu.modelo;

import java.util.ArrayList;

import net.ciprianlungu.persistencia.GestorBBDDCoche;

public class GestorCoches {
	GestorBBDDCoche gc;
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
	public void addModelos(int id_marca,String modelo,float consumo,int emisiones,String clasificacion){
		GestorBBDDCoche gestor = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		gestor.addModelo(id_marca, modelo, consumo, emisiones, clasificacion);
	}
	public int consultaIdMarca(String modelo){
		GestorBBDDCoche gestor = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		int resultado = gestor.consultaIdMarca(modelo);
		return resultado;
	}
}
