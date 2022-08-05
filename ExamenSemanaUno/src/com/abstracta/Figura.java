package com.abstracta;

public abstract class Figura {
	double base;
	double altura;
	
	public Figura(double base, double altura) {
		this.base=base;
		this.altura=altura;
	}
	
	public abstract double area();
	
	public abstract double perimetro();
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName()+
				"[base: " + base + ", altura: " + altura + "]";
	}
}
