package net.ciprianlungu.modelo;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TableModelModelos implements TableModel {

	ArrayList<Coche> coches;
	
	/**
	 * Constructor de table model de coches
	 * @param coches pasar el arraylist de coches
	 */
	public TableModelModelos(ArrayList<Coche> coches){
		this.coches=coches;
	}
	
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		switch(arg0){
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return Float.class;
		case 3:
			return Integer.class;
		default:
			return String.class;
		}
		
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex){
		case 0:
			return "Marca";
		case 1:
			return "Modelo";
		case 2:
			return "Consumo";
		case 3:
			return "Emisiones";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		return coches.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Coche car = coches.get(rowIndex);
		switch(columnIndex){
		case 0:
			return car.getMarca();
		case 1:
			return car.getModelo();
		case 2:
			return car.getConsumo();
		case 3:
			return car.getEmisiones();
		default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

}
