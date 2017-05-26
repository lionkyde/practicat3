package net.ciprianlungu.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JSlider;

import net.ciprianlungu.GUI.Consultar;
import net.ciprianlungu.modelo.Coche;
import net.ciprianlungu.modelo.Eficiencia;
import net.ciprianlungu.modelo.GestorCoches;
import net.ciprianlungu.modelo.Marca;
import net.ciprianlungu.modelo.Modelo;

public class GestorBBDDCoche extends GestorBBDD {
	
	private String marca;
	ArrayList<Coche> coches;
	GestorCoches gestorcars = new GestorCoches();
	public GestorBBDDCoche(String usr, String pwd, String ip, String bbddName) {
		super(usr, pwd, ip, bbddName);
	}

	
	
	//ARRAYLIST PARA OBTENER TODOS LOS MODELOS
	public ArrayList<Modelo> getModelos() throws SQLException, ClassNotFoundException{
		ArrayList<Modelo> modelos = new ArrayList();

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

		
		return modelos;
	}
	
	public ArrayList<Marca> getMarcas() throws SQLException, ClassNotFoundException{
		ArrayList<Marca> marcas = new ArrayList();

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
			
			
			

		return marcas;
	}
	public ArrayList<Eficiencia> getEficiencias() throws SQLException, ClassNotFoundException{
		ArrayList<Eficiencia> eficiencias = new ArrayList();
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
		return eficiencias;
	}
	
	public void addModelo(int id_marca,String modelo,float consumo,int emisiones,String clasificacion) throws SQLException, ClassNotFoundException{

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
			
	}
	public ArrayList<Coche> consultaTodasMarcas(Float consumo) throws SQLException, ClassNotFoundException{
		 coches = new ArrayList();

			establecerConexion();
			String sql = "SELECT mar.marca,mo.modelo,mo.consumo,mo.emisiones "+
						 "from marcas mar,modelos mo "+
						 "where mar.id=mo.id_marca and "+
						 "mo.consumo<="+consumo+";";
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				coches.add(new Coche(
						rs.getString("marca"),
						rs.getString("modelo"),
						rs.getFloat("consumo"),
						rs.getFloat("emisiones"))
						);
			}
			
		cerrarConexion();

		
		return coches;
	}
	
	public int consultaIdMarca(String modelo) throws SQLException, ClassNotFoundException{
		int id = 0;

			establecerConexion();
			String sql = "SELECT id from marcas where lower(marca) like \""+modelo+"\"";
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				id = rs.getInt("id");
			}
			cerrarConexion();
			
		return id;
	}
	 public ArrayList<Coche> getCoches(String marca,Float consumo) throws SQLException, ClassNotFoundException{
		coches = new ArrayList();
		

			establecerConexion();
			String sql = 
					"SELECT ma.marca,mo.modelo,mo.consumo,mo.emisiones "+
					"from marcas ma,modelos mo "+
					"where ma.id=mo.id_marca and "+
					"lower(ma.marca)like \'"+marca+"\' and mo.consumo<="+consumo+";";
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				coches.add(new Coche(
						rs.getString("marca"),
						rs.getString("modelo"),
						rs.getFloat("consumo"),
						rs.getFloat("emisiones"))		
						);
			}
			
			
			cerrarConexion();

		return coches;
	}



	public int consultaConsumoMaximo() throws SQLException, ClassNotFoundException {
		int consumoMaximo = 0;

			establecerConexion();
			String sql="SELECT MAX(consumo) FROM modelos;";
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				consumoMaximo = rs.getInt("max(consumo)");
			}
			cerrarConexion();


		
		
		return consumoMaximo;
	}
	public void borrarModelo(String modelo) throws SQLException, ClassNotFoundException{

			establecerConexion();
			String sql ="DELETE FROM modelos where lower(modelo) like \'"+modelo+"\';";
			Statement st = conexion.createStatement();
			st.executeUpdate(sql);

		cerrarConexion();
	}
}
