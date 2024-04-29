package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        List <Jugador> lista = new ArrayList<>();
        boolean band=false;
        int op = 0;
        try {
        	do {
    			try {
    				Menu();
    	      		op=scanner.nextInt();
    	      		scanner.nextLine();
    			} catch (Exception e) {
    				System.out.println("Error");
    				scanner.nextInt();
    			}
    			switch (op) {
     	         	case 1:
     	         		do {
     	         			try {
     	         				DateTimeFormatter formateo = DateTimeFormatter.ofPattern("dd-MM-yyyy");
     	 		                band=false;
     	 		                System.out.println("\n--- Alta de Jugador ---");
     	 		                System.out.print("Ingrese el nombre: ");
     	 		                String nombre = scanner.nextLine();                 
     	 		                System.out.print("Ingrese el apellido: ");
     	 		                String apellido = scanner.nextLine();
     	 		                System.out.print("Ingrese la fecha de nacimiento (dd-mm-yyyy): ");
     	 		                String fecha = scanner.nextLine();
     	 		                LocalDate fechaNacimiento = LocalDate.parse(fecha,formateo);    
     	 		                System.out.print("Ingrese la nacionalidad: ");
     	 		                String nacionalidad = scanner.nextLine();
     	 		                System.out.print("Ingrese la estatura cm: ");
     	 		                float estatura = scanner.nextFloat();
     	 		                System.out.print("Ingrese el peso kg: ");
     	 		                float peso = scanner.nextFloat();     
     	 		                scanner.nextLine();
     	 		                int opcion;
     	 		                        do {
     	 		                        	System.out.println("Ingrese la posición: ");
     	 		                        	System.out.println("1 - DELANTERO");
     	 		                        	System.out.println("2 - MEDIO");
     	 		                        	System.out.println("3 - DEFENSA");
     	 		                        	System.out.println("4 - ARQUERO");
     	 		                        	System.out.print("Ingrese una opcion:");
     	 		                        	opcion=scanner.nextInt();
     	 		                        } while (opcion<1 || opcion>4);
     	 		                        Posicion posicion = Posicion.values()[opcion - 1];
     	 		                        Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);                    		
     	 		                        lista.add(jugador);
     	 		                        System.out.println("\nJugador agregado correctamente.");
     	 		                        band=true;
     	 							} catch (Exception e) {
     	 								System.out.println("Error. Vuelva a intentarlo");
     	 							}
     	                 	}while(!band);
     	                     break;
     	         	case 2:
     	         		if (lista.isEmpty()) {
     	         			System.out.println("No hay jugadores registrados");
     	                } else {
     	                 	int cont=1;
     	                    System.out.println("\n--Mostrar todos los jugadores--");
     	                    for (Jugador elemento : lista) {
     	                    	System.out.println("--Jugador N° "+cont+"--");
     	                     	elemento.MostrarDatos();
     	                     	System.out.println("Edad: "+elemento.CalcularEdad()+" años");
     	                     	cont++;
     	                    }
     	                 }
     	                 break;
     	            case 3:
     	            	if (lista.isEmpty()) {
     	                 	System.out.println("No hay jugadores registrados");
     	                } else {
     	                 		System.out.println("\n--Modificar la posicion de un Jugador--");
     	                         System.out.print("Ingrese el nombre del jugador: ");
     	                         String nombreab = scanner.nextLine();
     	                         System.out.print("Ingrese el apellido del jugador: ");
     	                         String apellidoab = scanner.nextLine();
     	                         for (Jugador elemento: lista) {
     	                         	if (elemento.getNombre().equals(nombreab) && elemento.getApellido().equals(apellidoab)) {
     	                         		Modificar(elemento);
     	                         		break;
     	                         	}
     	                     	}
     	                 	}
     	                 	break;
     	             case 4:
     	             	 if (lista.isEmpty()){
     	                    	System.out.println("No hay ningun jugador registrado");
     	                    } else {
     	                    	band=false;
     	                    	System.out.print("Ingrese el nombre del jugador a eliminar: ");
     	                    	String nombre = scanner.next();
     	                    	System.out.print("Ingrese el apellido del jugador a eliminar: ");
     	                    	String apellido = scanner.next();
     	                    	Iterator<Jugador> iterator = lista.iterator();
     	                		while(iterator.hasNext()) {
     	                			Jugador jugador = iterator.next();
     	                			if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
     	                				iterator.remove();
     	                				band=true;
     	                			}
     	                		}
     	                		if (!band) {
     	                			System.out.println("No se encontraron coincidencias");
     	                		}
     	                		else {
     	                			System.out.println("Jugador eliminado correctamente!");
     	                		}
     	                    }
     	             	break;
     	             case 5:
     	             	System.out.println("Programa finalizado");
     	             	break;
     	             default:
     	             	System.out.println("Opcion incorrecta. Vuelva a intentarlo");
     	             	break;
     	             }
          		
    	       
    	     } while (op!=5);
		} finally {
			scanner.close();
		}
		 
		
	}
	public static void Modificar(Jugador jug) {
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		try {
			do {
	         	System.out.println("Ingrese la nueva posición: ");
	         	System.out.println("1 - DELANTERO");
	         	System.out.println("2 - MEDIO");
	         	System.out.println("3 - DEFENSA");
	         	System.out.println("4 - ARQUERO");
	         	System.out.print("Ingrese una opcion:");
	         	opcion=scanner.nextInt();
	         } while (opcion<1 || opcion>4);
		} finally {
			 Posicion posicion = Posicion.values()[opcion - 1];
	         jug.setPosicion(posicion);
		} 
	}
	public static void Menu () {
		System.out.println("\n--- Menú de Opciones ---");
        System.out.println("1 - Alta de jugador");
        System.out.println("2 - Mostrar todos los jugadores");
        System.out.println("3 - Modificar la posición de un jugador");
        System.out.println("4 - Eliminar un jugador");
        System.out.println("5 - Salir");
        System.out.print("Ingrese una opción: ");
	}
}
