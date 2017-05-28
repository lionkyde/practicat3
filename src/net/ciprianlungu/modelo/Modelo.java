package net.ciprianlungu.modelo;

public class Modelo {
	private int id_marca;
	private String modelo;
	private float consumo;
	private int emisiones;
	private String clasificacion;
	
	/**
	 * Constructor de modelo de coche
	 * @param id_marca id de marca
	 * @param modelo nombre de modelo del coche
	 * @param consumo consumo maximo del coche
	 * @param emisiones emisiones expresada en gramos
	 * @param clasificacion clasificacion de eficiencia
	 */
	public Modelo(int id_marca, String modelo, float consumo, int emisiones, String clasificacion) {
		super();
		this.id_marca = id_marca;
		this.modelo = modelo;
		this.consumo = consumo;
		this.emisiones = emisiones;
		this.clasificacion = clasificacion;
	}
	
	public int getId_marca() {
		return id_marca;
	}
	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public float getConsumo() {
		return consumo;
	}
	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}
	public int getEmisiones() {
		return emisiones;
	}
	public void setEmisiones(int emisiones) {
		this.emisiones = emisiones;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	
}
