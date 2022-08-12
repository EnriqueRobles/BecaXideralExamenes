package com.composite;

//representará productos cuya venta depende del peso del mismo
public class ProductoPeso implements Precio{
	
	private double peso;
	private double precioPorPeso;
	private String nombre;
	private String categoria;
	
	public ProductoPeso(double peso, double precioPorPeso, String nombre, String categoria) {
		this.peso = peso;
		this.precioPorPeso = precioPorPeso;
		this.nombre = nombre;
		this.categoria = categoria;
	}

	//set y get
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPrecioPorPeso() {
		return precioPorPeso;
	}

	public void setPrecioPorPeso(double precioPorPeso) {
		this.precioPorPeso = precioPorPeso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public double getImporteTotal() {
		return getPrecioPorPeso()*getPeso();
	}
	
	@Override
	public String toString() {
		return "["+ "El precio de " + getNombre()+" es: "+ getPrecioPorPeso() +"]";
	}
	
	
	
	

}
