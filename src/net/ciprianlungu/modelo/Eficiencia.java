package net.ciprianlungu.modelo;

public class Eficiencia {
	private String calificacion;
	/**
	 * 
	 * @param calificacion calificacion energetica del coche
	 */
	public Eficiencia(String calificacion) {
		super();
		this.calificacion = calificacion;
	}
	/**
	 * 
	 * @return devuelve la calificacion del coche
	 */
	public String getCalificacion() {
		return calificacion;
	}
	/**
	 * 
	 * @param calificacion pasa al variable calificacion del coche
	 */
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
}
