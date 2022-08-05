package com.abstracta;

public class Rectangulo extends Figura{
	
	//constructor que llama al constructor padre
	public Rectangulo(double base, double altura) {
		super(base, altura);
	}
	
	//implementacion de los metodos abstractos
	@Override
	public double area() {
		return base*altura;
	}

	@Override
	public double perimetro() {
		return (base*2)+(altura*2);
	}

}
