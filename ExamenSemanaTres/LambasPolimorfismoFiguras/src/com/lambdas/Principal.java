package com.lambdas;

import java.text.DecimalFormat;
import java.util.*;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

public class Principal {

	public static void main(String[] args) {
		
		//Lambda para perimetro triangulo isoseles
		DoubleBinaryOperator trianguloPerimetro2 = (lado, base) -> (lado+lado)+base;
		
		//Lambda para area triangulo equilatero
		DoubleBinaryOperator trianguloArea = (altura, base) -> (base*altura)/2;
		
		//Lambda para perimetro rectangulo
		DoubleBinaryOperator rectanguloPerimetro = (ancho, altura) -> (ancho+ancho)+(altura + altura);
		
		//Lambda para area rectangulo
		DoubleBinaryOperator rectanguloArea = (base, altura) -> (base*altura);
		
		//Agregando a una lista 
		List<DoubleBinaryOperator> listFiguras = new ArrayList<>();
		listFiguras.add(trianguloPerimetro2);
		listFiguras.add(trianguloArea);
		listFiguras.add(rectanguloPerimetro);
		listFiguras.add(rectanguloArea);
		
		formulasFiguras(listFiguras);

	}
	
	//Aplicando Polimorfismo
	private static void formulasFiguras(List<DoubleBinaryOperator> listFiguras) {
		DecimalFormat df= new DecimalFormat("0.00");
		//numero random del 1 al 10
		double rand =Math.random()*10+1;
		double rand2 =Math.random()*10+1;

		for (DoubleBinaryOperator liFig : listFiguras) {
			System.out.println("Numero Uno: "+df.format(rand) + " Numero dos: "+ df.format(rand2));
			double res=liFig.applyAsDouble(rand, rand2);
			System.out.println(df.format(res));
			System.out.println("-------------------------------------------");
		}	
	}

}
