package net.ciprianlungu.modelo;

import java.util.ArrayList;

import net.ciprianlungu.persistencia.GestorBBDDCoche;

public class GestorCoches {
	GestorBBDDCoche gc;
	
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
}
