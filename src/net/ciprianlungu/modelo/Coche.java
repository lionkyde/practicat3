package net.ciprianlungu.modelo;

public class Coche {
	private String marca;
	private String modelo;
	private float consumo;
	private float emisiones;
	
	
	public Coche(String marca, String modelo, float consumo, float emisiones) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.consumo = consumo;
		this.emisiones = emisiones;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
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
	public float getEmisiones() {
		return emisiones;
	}
	public void setEmisiones(float emisiones) {
		this.emisiones = emisiones;
	}
}
