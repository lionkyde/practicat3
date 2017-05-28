package net.ciprianlungu.modelo;

public class Marca {
	private int id;
	private String marca;
	
	/**
	 * Constructor de marca
	 * @param id id de marca
	 * @param marca nombre de marca
	 */
	public Marca(int id, String marca) {
		super();
		this.id = id;
		this.marca = marca;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
}
