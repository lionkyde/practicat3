package net.ciprianlungu.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import net.ciprianlungu.modelo.Eficiencia;
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
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marcas;
	}
	public ArrayList<Eficiencia> getEficiencias(){
		ArrayList<Eficiencia> eficiencias = new ArrayList();
		try {
			establecerConexion();
			String sql = "SELECT c_energetica from eficiencias";
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				eficiencias.add(new Eficiencia(
						rs.getString("c_energetica"))
						);
			}
			cerrarConexion();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eficiencias;
	}
	
	public void addModelo(int id_marca,String modelo,float consumo,int emisiones,String clasificacion){
		try {
			establecerConexion();
			String sql =
					"INSERT INTO modelos(ID_MARCA,MODELO,CONSUMO,EMISIONES,C_ENERGETICA) VALUES"
					+ "(?,?,?,?,?);";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1,id_marca);
			ps.setString(2, modelo);
			ps.setFloat(3, consumo);
			ps.setInt(4, emisiones);
			ps.setString(5, clasificacion);
			ps.executeUpdate();
			
			cerrarConexion();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int consultaIdMarca(String modelo){
		int id = 0;
		try {
			establecerConexion();
			String sql = "SELECT id from marcas where lower(marca) like \""+modelo+"\"";
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				id = rs.getInt("id");
			}
			cerrarConexion();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
}
