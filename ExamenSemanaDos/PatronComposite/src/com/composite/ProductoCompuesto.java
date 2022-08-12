package com.composite;

import java.util.ArrayList;
import java.util.Iterator;

//representará un grupo de productos cuya venta se realiza de forma conjunta
public class ProductoCompuesto implements Precio{
	
	private ArrayList<Precio> listaProductos ;

	public ProductoCompuesto() {
		this.listaProductos =new ArrayList<Precio>();
	}
	
	//añade productos
	public void addProducto(Precio precio) {
		listaProductos.add(precio);	
	}
	
	//elimina prodcutos
	public void removeProducto(Precio precio) {
		listaProductos.remove(precio);	
	}
	
	//devuelve el array de productos
	public ArrayList<Precio> getListaProductos() {
		return listaProductos;
	}

	//calcula el importe total de todos los prodcutos y sus componentes 
	@Override
	public double getImporteTotal() {
		double importeTotal=0;
		for (Iterator<Precio> it = listaProductos.iterator(); it.hasNext();) {
			Precio precio = it.next();
			importeTotal+= precio.getImporteTotal();
		}
		return importeTotal;
	}
	

	

}
