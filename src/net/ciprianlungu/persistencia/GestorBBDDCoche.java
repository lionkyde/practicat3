package net.ciprianlungu.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import net.ciprianlungu.modelo.Marca;
import net.ciprianlungu.modelo.Modelo;

public class GestorBBDDCoche extends GestorBBDD {

	public GestorBBDDCoche(String usr, String pwd, String ip, String bbddName) {
		super(usr, pwd, ip, bbddName);
	}
	
	//ARRAYLIST PARA OBTENER TODOS LOS MODELOS
	public ArrayList<Modelo> getModelos(){
		ArrayList<Modelo> modelos = new ArrayList();
		try {
			establecerConexion();
			String sql = "SELECT * FROM modelos";
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				modelos.add(new Modelo(
						rs.getInt("id_marca"),
						rs.getString("modelo"),
						rs.getFloat("consumo"),
						rs.getInt("emisiones"),
						rs.getString("c_energetica"))
						);
			}
			cerrarConexion();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return modelos;
	}
	
	public ArrayList<Marca> getMarcas(){
		ArrayList<Marca> marcas = new ArrayList();
		try {
			establecerConexion();
			String sql = "SELECT * FROM marcas";
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				marcas.add(new Marca(
						rs.getInt("id"),
						rs.getString("marca"))
						);
			}
			cerrarConexion();
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marcas;
	}
}
