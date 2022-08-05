package com.abstracta;

public abstract class Figura {
	//variables
	double base;
	double altura;
	
	//constructor
	public Figura(double base, double altura) {
		this.base=base;
		this.altura=altura;
	}
	
	//metodos abstractos
	public abstract double area();
	
	public abstract double perimetro();
	
	//Metodo toSring sobreescrito
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName()+
				"[base: " + base + ", altura: " + altura + "]";
	}
}
