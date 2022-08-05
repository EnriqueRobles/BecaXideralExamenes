package com.interfaz;

public class Triangulo implements Figura{
	//variables
	double base;
	double altura;
	
	//constructor
	public Triangulo(double base, double altura) {
		this.base=base;
		this.altura=altura;
	}

	//metodos sobreescritos
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return (base*altura)/2;
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return base*3;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Triangulo "+
				"[base: " + base + ", altura: " + altura + "]";
	}

}
