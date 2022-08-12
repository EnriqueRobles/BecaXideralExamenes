package com.test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.composite.*;


class Pruebas {


	@Test
	void getNombre() {
		String nombre= "Jamón Ibérico";
		assertEquals(nombre, "Jamón Ibérico");
	}
	
	@Test
	void getPrecio() {
		double precioUnidad= 10.0;
		assertEquals(precioUnidad, 10.0);
	}
	
	@Test
	void getMarca() {
		String marca= "Embutidos";
		assertEquals(marca, "Embutidos");
	}
	
	@Test
	void getNombre2() {
		ProductoCompuesto cestaDeNavidad = new ProductoCompuesto();
		ProductoPeso lomo = new ProductoPeso(0.8, 5.0, "Lomo Ibérico", "Embutidos");
		cestaDeNavidad.addProducto(lomo);
		assertEquals(lomo.getNombre(), "Lomo Ibérico");
	}
	
	@Test
	void getPrecio2() {
		ProductoCompuesto cestaDeNavidad = new ProductoCompuesto();
		ProductoPeso lomo = new ProductoPeso(0.8, 5.0, "Lomo Ibérico", "Embutidos");
		cestaDeNavidad.addProducto(lomo);
		assertEquals(lomo.getPrecioPorPeso(), 5.0);
	}
	
	@Test
	void insertarProducto() {
		ProductoCompuesto cestaDeNavidad = new ProductoCompuesto();
		ProductoPeso lomo = new ProductoPeso(0.8, 5.0, "Lomo Ibérico", "Embutidos");
		cestaDeNavidad.addProducto(lomo);
		assertEquals(lomo, cestaDeNavidad.getListaProductos().get(0));
	}
	
	@Test
	void insertarPedido() {
		Pedido pedido = new Pedido("SEAS - Estudios Abiertos");
		ProductoPeso lomo = new ProductoPeso(0.8, 5.0, "Lomo Ibérico", "Embutidos");
		ProductoCompuesto cestaDeNavidad = new ProductoCompuesto();
		cestaDeNavidad.addProducto(lomo);
		pedido.addProducto(cestaDeNavidad);
		assertEquals(cestaDeNavidad, pedido.getListaProductos().get(0));
	}
	
	@Test
	void getCliente() {
		String cliente= "SEAS - Estudios Abiertos";
		assertEquals(cliente, "SEAS - Estudios Abiertos");
	}
	

}
