package com.abstracta;

public class Rectangulo extends Figura{

	public Rectangulo(double base, double altura) {
		super(base, altura);
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return base*altura;
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return (base*2)+(altura*2);
	}

}
