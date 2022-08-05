package com.abstracta;

public class Triangulo extends Figura{
	//constructor que llama al constructor padre
	public Triangulo(double base, double altura) {
		super(base, altura);
	}

	//implementacion de los metodos abstractos
	@Override
	public double area() {
		return (base*altura)/2;
	}

	@Override
	public double perimetro() {
		return base*3;
	}

}
