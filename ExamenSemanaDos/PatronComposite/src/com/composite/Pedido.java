package com.composite;

//es una especialización de la clase ProductoCompuesto que añadirá una serie de propiedades 
//nombre del cliente y unas funcionalidades añadidas.
public class Pedido extends ProductoCompuesto {

	private String cliente;

	public Pedido(String cliente) {
		super();
		this.cliente = cliente;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	// añadir un prodcuto
	@Override
	public void addProducto(Precio producto) {
		super.addProducto(producto);
	}

	// elimina prodcutos
	public void removeProducto(Precio producto) {
		super.removeProducto(producto);
	}
	
	//nos sirve para fijar el numero de unidades de un ProdcutoUnitario del pedido
	public void establecerCantidad(Precio producto, int cantidadFinal) {
		if (producto instanceof ProductoUnitario) {
			((ProductoUnitario)super.getListaProductos().
					get(super.getListaProductos().indexOf(producto))).setCantidad(cantidadFinal);
		}
	}
	
	//nos sirve para establecer el peso final de un ProductoPeso
	public void establecerPeso(Precio producto, double pesoFinal) {
		if (producto instanceof ProductoPeso) {
			((ProductoPeso)super.getListaProductos().
					get(super.getListaProductos().indexOf(producto))).setPeso(pesoFinal);
		}
	}
}
