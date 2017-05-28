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
	/**
	 * 
	 * @param usr usuario
 	 * @param pwd constrasenia
	 * @param ip ip del servidor
	 * @param bbddName nombre de la base de datos
	 */
	public GestorBBDDCoche(String usr, String pwd, String ip, String bbddName) {
		super(usr, pwd, ip, bbddName);
	}

	
	/**
	 * Metodo de consulta de la base de datos para obtener todos los modelos de coches
	 * @return devuelve un arraylist de coches consultados
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
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
	/**
	 * Metodo para consulta de la base de datos para obtener todas las marcas de coches
	 * @return devuelve un arraylist de marcas
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
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
	/**
	 * Metodo de consulta de la bbdd para obtener todas las eficiencias
	 * @return devuelve un arraylist de eficiencias
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
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
	/**
	 * Metodo de añadir los modelos de coches a la base de datos en forma de SQL
	 * @param id_marca id de la marca
	 * @param modelo modelos de coches
	 * @param consumo consumo maximo del coche
	 * @param emisiones emisiones del coche
	 * @param clasificacion eficiencia del coche
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
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
	/**
	 * Metodo de añadir marcas a la base de datos en forma de SQL
	 * @param marca marca de coche
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void addMarcas(String marca) throws ClassNotFoundException, SQLException{
		establecerConexion();
		String sql = 
				"INSERT INTO marcas(marca) values (?);";
		PreparedStatement ps = conexion.prepareStatement(sql);
		ps.setString(1,marca);
		ps.executeUpdate();
		
		cerrarConexion();
	}
	/**
	 * Metodo de consulta a la base de datos para obtener los datos de consulta de todas las
	 *  marcas con su consumo pedido por el usuario
	 * @param consumo consumo obtenido por usuario
	 * @return devuelve un arraylist de coches consultados
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
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
	/**
	 * Metodo para consulta de la base de datos para saber la id de marca obtenido por modelo insertado
	 * @param modelo modelo obtenido por usuario para su consulta
	 * @return devuelve el id de marca
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
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
	/**
	 * Metodo de consulta de la bbdd para obtener todos los coches 
	 * por su marca y consumo pedido por usuario
	 * @param marca marca de coche
	 * @param consumo consumo maximo del coche
	 * @return devuelve un arraylist de coche 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
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
	/**
	 * Metodo de consulta de bbdd para obtener el consumo maximo de la tabla modelos
	 * @return devuelve un entero del consumo maximo
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
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
	/**
	 * Metodo para borrar de la base de datos de modelos
	 * @param modelo modelo de coche
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void borrarModelo(String modelo) throws SQLException, ClassNotFoundException{

			establecerConexion();
			String sql ="DELETE FROM modelos where lower(modelo) like \'"+modelo+"\';";
			Statement st = conexion.createStatement();
			st.executeUpdate(sql);

		cerrarConexion();
	}
	/**
	 * Metodo para borrar la marca de la base de datos
	 * @param marca marca de coches
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void borrarMarca(String marca) throws ClassNotFoundException, SQLException{
		establecerConexion();
		String sql = "DELETE FROM marcas where lower(marca) like \'"+marca+"\';";
		Statement st = conexion.createStatement();
		st.executeUpdate(sql);
		
		cerrarConexion();
	}
}
