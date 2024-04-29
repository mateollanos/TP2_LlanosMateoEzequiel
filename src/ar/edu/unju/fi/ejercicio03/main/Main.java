package ar.edu.unju.fi.ejercicio03.main;

import ar.edu.unju.fi.ejercicio03.constantes.Provincia;

public class Main {

	public static void main(String[] args) {

		Provincia[] lista = Provincia.values();
		
		for (Provincia elemento : lista) {
			 System.out.println("--Provincia de "+elemento+"--");
	         System.out.println("Cantidad de población: "+elemento.getCantPoblacion());
	         System.out.println("Superficie: " + elemento.getSuperficie());
	         System.out.println("Densidad poblacional: " + elemento.DensidadPoblacional());
	         System.out.println();
		}

	}

}
