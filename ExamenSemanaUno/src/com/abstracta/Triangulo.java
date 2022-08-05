package com.abstracta;

public class Triangulo extends Figura{

	public Triangulo(double base, double altura) {
		super(base, altura);
		// TODO Auto-generated constructor stub
	}

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

}
