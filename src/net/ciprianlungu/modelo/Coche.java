package net.ciprianlungu.modelo;

public class Coche {
	private String marca;
	private String modelo;
	private float consumo;
	private float emisiones;
	
	/**
	 * 
	 * @param marca marca de coche
	 * @param modelo modelo de coche
	 * @param consumo consumo del coche
	 * @param emisiones emisiones del coche
	 */
	public Coche(String marca, String modelo, float consumo, float emisiones) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.consumo = consumo;
		this.emisiones = emisiones;
	}
	/**
	 * 
	 * @return devuelve la marca de coche
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * 
	 * @param marca pasar la marca de coche
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * 
	 * @return devuelve el modelo de coche
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * 
	 * @param modelo pasa al variable de modelo del coche
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * 
	 * @return devuelve el consumo maximo del coche
	 */
	public float getConsumo() {
		return consumo;
	}
	/**
	 * 
	 * @param consumo pasa al variable de consumo maximo del coche
	 */
	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}
	/**
	 * 
	 * @return devuelve emisiones del coche
	 */
	public float getEmisiones() {
		return emisiones;
	}
	/**
	 * 
	 * @param emisiones pasa al variable de emisiones del coche
	 */
	public void setEmisiones(float emisiones) {
		this.emisiones = emisiones;
	}
}
