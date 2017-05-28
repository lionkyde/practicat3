package net.ciprianlungu.modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JSlider;

import net.ciprianlungu.persistencia.GestorBBDDCoche;

public class GestorCoches {
	GestorBBDDCoche gc;
	private int resultado;
	
	/**
	 * Metodo para recoger las eficiencias de la base de datos
	 * @return devuelve arraylist de todas las clasificaciones de las eficiencias de los coches
	 * @throws ClassNotFoundException 
	 * @throws SQLException
	 */
	public ArrayList<Eficiencia> getEficiencias() throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		ArrayList<Eficiencia> eficiencias = gc.getEficiencias();
		return eficiencias;
	}
	/**
	 * Metodo para recoger todos los modelos de los coches
	 * @return devuelve el arraylist de modelos
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<Modelo> getModelos() throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		ArrayList<Modelo> modelos = gc.getModelos();
		return modelos;
	}
	/**
	 * Metodo que recoge los datos de todas las marcas de coches
	 * @return devuelve un arraylist de marcas 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<Marca> getMarcas() throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		ArrayList<Marca> marcas = gc.getMarcas();
		return marcas;
	}
	/**
	 * Metodo para recoger la consulta de por Consumo y Marca
	 * @param marca parametro para pasar la marca del coche para utilizacion de la consulta
	 * @param consumo parametro para pasar el consumo maximo del jslider del panel de Consulta para utilizacion de la consulta
	 * @return devuelve un arraylist de todos los coches de la consulta dada del SQL
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<Coche> consultaMarcaConsumoCoches(String marca,Float consumo) throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		ArrayList<Coche> coches = gc.getCoches(marca,consumo);
		return coches;
	}
	/**
	 * Metodo para anadir a la base de datos el modelo pedido por el usuario
	 * @param id_marca parametro para pasar el id de marca para creacion de marca(no te deja crear sin el id de marca)
	 * @param modelo parametro que recoge del textfield modelo del panel de consulta
	 * @param consumo parametro que recoge del jslider consumo del panel de consulta
	 * @param emisiones parametro que recoge del textfield emisiones del panel de consulta
	 * @param clasificacion parametro que recoge del jslider clasificacion del panel de consulta
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void addModelos(int id_marca,String modelo,float consumo,int emisiones,String clasificacion) throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		gc.addModelo(id_marca, modelo, consumo, emisiones, clasificacion);
	}
	/**
	 * Metodo para anadir la marca requerida por el usuario
	 * @param marca parametro que recoge del textfield del panel de crear marca
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void addMarcas(String marca) throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		gc.addMarcas(marca);
	}
	/**
	 * Metodo para consulta especialmente la id de marca de la base de datos
	 * @param marca parametro que recoge del combo de marcas para utilizar en la consulta
	 * @return devuelve un numero entero que es el id de marca
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int consultaIdMarca(String marca) throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		int resultado = gc.consultaIdMarca(marca);
		return resultado;
	}
	/**
	 * Metodo para consulta de base de datos de todas las marcas, dependiendo del consumo que haya metido el usuario
	 * @param consumo parametro parametro recogida del jslider del panel consulta para utilizacion de consulta de base de datos
	 * @return devuelve un arraylist de todos los coches consultada por la bbdd
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<Coche> consultaTodasMarcas(Float consumo) throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		ArrayList<Coche> coches = gc.consultaTodasMarcas(consumo);
		return coches;
	}
	/**
	 * Metodo para consultar el consumo maximo que tiene toda la base de datos de modelos
	 * @return devuelve un numero entero del consumo maximo de todos los modelos
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int consultaConsumoMaximo() throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		int resultado = gc.consultaConsumoMaximo();
		return resultado;
	}
	/**
	 * Modelo para borrar los modelos requerido por el usuario.Se borrara los datos de la base de datos
	 * @param modelo pasamos el parametro de modelo para utilizacion de un modelo en concreto para borrar de la bbdd
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void borrarModelo(String modelo) throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		gc.borrarModelo(modelo);
	}
	/**
	 * Modelo para borrar las marcas requerido por el usuario. Se borrará la marca de la base de datos
	 * @param marca parametro del textfield del panel de consultar marcas, para decidir que marca borrar de la bbdd
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void borrarMarca(String marca) throws ClassNotFoundException, SQLException{
		gc = new GestorBBDDCoche("root","","localhost","bbdd_gestmotor");
		gc.borrarMarca(marca);
	}
}
