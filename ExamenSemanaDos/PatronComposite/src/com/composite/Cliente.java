package com.composite;

public class Cliente {
	public static void main(String[] args) {
		// Creamos un nuevo pedido
		Pedido pedido = new Pedido("SEAS - Estudios Abiertos");
		
		// Producto que se vende a peso y a un precio por kilogramo.
		//cantidad,precio por pe 	so, nombre, categoria
		ProductoPeso jamon = new ProductoPeso(5.0, 10.0, "Jamón Ibérico", "Embutidos");
		ProductoPeso lomo = new ProductoPeso(0.8, 5.0, "Lomo Ibérico", "Embutidos");
		
		// Producto que se vende a un precio por unidad y por un numero de
		// unidades determinadas.
		//cantidad,precio por unidad, nombre, categoria
		ProductoUnitario paqueteDeEspaguetis = new ProductoUnitario(3, 1.50, "Paquete de espaguetis", "Pasta");
		ProductoUnitario vino = new ProductoUnitario(6, 2.25, "Botella de vino", "Vinos");
		
		// Producto compuesto de varios productos.
		ProductoCompuesto cestaDeNavidad = new ProductoCompuesto();
		
		// Añadimos los productos individuales al producto compuesto.
		cestaDeNavidad.addProducto(vino);
		cestaDeNavidad.addProducto(lomo);
		
		// Añadimos los productos al pedido.
		pedido.addProducto(jamon);
		pedido.addProducto(paqueteDeEspaguetis);
		
		// Mostramos quien pidio el pedido y el importe por unidad.
		System.out.println(pedido.getCliente());
		System.out.println("El importe por unidad es : " +  pedido.getListaProductos().toString());
		
		//precio total del pedido
		pedido.addProducto(cestaDeNavidad);
		System.out.println("El importe total del Pedido es : " + pedido.getImporteTotal());

	}

}
