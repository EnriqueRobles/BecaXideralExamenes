package com.interfaz;

public class Rectangulo implements Figura{
	//variables 
	double base;
	double altura;
	
	//constructor
	public Rectangulo(double base, double altura) {
		this.base=base;
		this.altura=altura;
	}
	
	//Metodos sobreescritos
	@Override
	public double area() {
		return base*altura;
	}

	@Override
	public double perimetro() {
		return (base*2)+(altura*2);
	}
	
	@Override
	public String toString() {
		return "Rectangulo "+
				"[base: " + base + ", altura: " + altura + "]";
	}

}
