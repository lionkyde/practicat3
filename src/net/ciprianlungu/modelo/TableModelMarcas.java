package net.ciprianlungu.modelo;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TableModelMarcas implements TableModel {
	
	ArrayList<Marca> marcas;
	public TableModelMarcas(ArrayList<Marca> marcas){
		this.marcas=marcas;
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
		default:
			return String.class;
		}
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex){
		case 0:
			return "Marca";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		return marcas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Marca mark = marcas.get(rowIndex);
		switch(columnIndex){
		case 0:
			return mark.getMarca();
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
