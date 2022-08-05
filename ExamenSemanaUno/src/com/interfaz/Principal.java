package com.interfaz;

import java.util.*;

public class Principal {
	public static void main(String[] args) {
		//Lista de figuras 
		Figura [] fig= {new Rectangulo(7, 9),new Triangulo(8, 12),new Rectangulo(6, 10),new Triangulo(12, 8)};
		obtenerFigura(fig);
		
		
	}
	
	//metodo estatico para obtener figura y calcular sus respectivas areas y perimetros
	private static Figura obtenerFigura(Figura [] fig) {
		int i= new Random().nextInt(fig.length);
		Figura figRes= fig[i];
		System.out.println(figRes);
		System.out.println("El Area es "+figRes.area());
		System.out.println("El Perimetro es "+figRes.perimetro());
		return figRes;
	}
}
