package ar.edu.unju.fi.ejercicio05.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio05.model.Producto;


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        List <Producto> lista = new ArrayList<>();
        boolean band=false;
        int op = 0;
        
        precarga(lista);
        
        try {
        	do {
        		do {
        			band=false;
        			try {
    					Menu();
        	      		op=scanner.nextInt();
        	      		scanner.nextLine();
        	      		band=true;
        			} catch (Exception e) {
        				System.out.println("Error");
        				scanner.nextLine();
        			}

        		} while(!band);
    			    			
    			switch (op) {
     	         	case 1:
     	         		System.out.println("\n--PRODUCTOS--");
     	         		for (Producto elemento : lista) {
     	         			elemento.MostrarDatos();
     	         		}
     	                break;
     	         	case 2:
     	         		List<Producto> listcompras = new ArrayList<>();
     	         		System.out.println("\n--REALIZAR COMPRA--");
     	         		compras (scanner,listcompras,lista);
 	         			System.out.println("\n--CARRITO DE COMPRAS--");
 	         			for (Producto p : listcompras) {
 	         				p.MostrarDatos();
 	         			}
 	         			int p=formaPago(scanner); 
 	         			scanner.nextLine();
 	         			pago(scanner,p,listcompras);	
     	         		break;
     	         	case 3:
     	         		System.out.println("Programa terminado");
     	         		break;
     	         	default: 
     	         		System.out.println("Opcion incorrecta. Vuelva a intentarlo");
     	         		break;
     	        }
    	     } while (op!=3);
		} finally {
			scanner.close();
		}
	}

	public static void Menu () {
		System.out.println("\n--MENU--");
        System.out.println("1 - Mostrar productos");
        System.out.println("2 - Realizar compra");
        System.out.println("3 - Salir");
        System.out.print("Ingrese una opción: ");
	}
	
	public static void precarga (List <Producto> lista) {
		Producto producto1 = new Producto(2000, "Monitor Samsung 24''", 200000, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true);
		Producto producto2 = new Producto(2001, "Mouse logitech g203", 12000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false);
		Producto producto3 = new Producto(2002, "Teclado hyperx alloy origins core", 56000, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, true);
		Producto producto4 = new Producto(2003, "Placa madre gigabyte B450M DS3H", 25000, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, false);
		Producto producto5 = new Producto(2004, "Procesador amd ryzen 5 3600", 72000, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true);
		Producto producto6 = new Producto(2005, "Placa de video Zotac gtx1660 super", 500000, OrigenFabricacion.CHINA, Categoria.ELECTRO_HOGAR, false);
		Producto producto7 = new Producto(2006, "Disco HDD Barracuda 2tb", 21000, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
		Producto producto8 = new Producto(2007, "Disco SSD WDgreen 240gb", 14000, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, false);
		Producto producto9 = new Producto(2008, "Fuente Aerocool Cylon 600w 80 plus bronze", 28000, OrigenFabricacion.ARGENTINA, Categoria.ELECTRO_HOGAR, true);
		Producto producto10 = new Producto(2009, "Memoria ram Corsair 2x8gb 3200mhz", 32000, OrigenFabricacion.URUGUAY, Categoria.HERRAMIENTAS, false);
		Producto producto11 = new Producto(2010, "Auriculares Redragon Icon H520", 20000, OrigenFabricacion.BRASIL, Categoria.TELEFONIA, true);
		Producto producto12 = new Producto(2011, "Gabinete Sentey Z20", 29000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false);
		Producto producto13 = new Producto(2012, "Parlantes Genius", 10000, OrigenFabricacion.CHINA, Categoria.ELECTRO_HOGAR, true);
		Producto producto14 = new Producto(2013, "Impresora", 100000, OrigenFabricacion.URUGUAY, Categoria.INFORMATICA, false);
		Producto producto15 = new Producto(2014, "Celular Motorola", 198000, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, true);
		lista.add(producto1);
		lista.add(producto2);
		lista.add(producto3);
		lista.add(producto4);
		lista.add(producto5);
		lista.add(producto6);
		lista.add(producto7);
		lista.add(producto8);
		lista.add(producto9);
		lista.add(producto10);
		lista.add(producto11);
		lista.add(producto12);
		lista.add(producto13);
		lista.add(producto14);
		lista.add(producto15);
	}
	public static void compras (Scanner scanner, List<Producto> listcompras, List<Producto> lista) {
		System.out.println("--PRODUCTOS DISPONIBLES--");
		for (Producto elemento : lista) {
			if (elemento.isEstado()==true) {
				elemento.MostrarDatos();
			}
		}
		String resp;
		do {
			boolean band=false;
			int cod=0;
			do {
				try {
					System.out.print("Ingrese el codigo del producto que quiere comprar: ");
					cod=scanner.nextInt();
					scanner.nextLine();
					band=true;
				} catch (Exception e) {
					System.out.println("Error. Vuelva a intentarlo");
				}
			} while(!band);
			
			boolean existe=false;
			for (Producto elemento : lista) {
				if (cod==elemento.getCodigo()) {
					listcompras.add(elemento);
					existe=true;
					break;
				}
			}
			if (existe) {
				System.out.println("Producto agregado al carrito correctamente!");
			} else {
				System.out.println("No se encontraron coincidencias");
			}
			do {
				System.out.println("Desea seguir agregando productos al carrito? si/no");
				resp = scanner.next().toLowerCase();
				scanner.nextLine();
				if (!resp.equals("si") && !resp.equals("no")) {
					System.out.println("Incorrecto. Vuelva a intentarlo");
				}
			} while (!resp.equals("si") && !resp.equals("no"));	
		} while(resp.equals("si"));
	}
	public static int formaPago (Scanner scanner) {
		int opcion=0;
		do {
			System.out.println("1 - PAGO EN EFECTIVO");
			System.out.println("2 - PAGO CON TARJETA");
			System.out.print("Seleccione una forma de pago: ");
			try {
				opcion=scanner.nextInt();
				if (opcion<1 || opcion>2) {
					System.out.println("Opcion incorrecta. Vuelva a intentarlo");
				}
			} catch (Exception e) {
				System.out.println("Error. Vuelva a intentarlo");
			}
		} while (opcion<1 || opcion>2);
		return opcion;
	}
	public static void pago (Scanner scanner, int p, List<Producto> listcompras) {
		double totalPagar=montoTotal(listcompras);
		totalPagar=montoTotal(listcompras);
		LocalDate fecha=LocalDate.now();
		switch (p) {
		case 1:
			System.out.println("\n--PAGO EN EFECTIVO--");
			PagoEfectivo efectivo = new PagoEfectivo(totalPagar,fecha);
			efectivo.realizarPago(totalPagar);
			efectivo.imprimirRecibo();
			break;
		case 2:
			System.out.println("\n--PAGO CON TARJETA--");
			System.out.print("Ingrese el numero de tarjeta: ");
			String numTarjeta=scanner.nextLine();
			System.out.println();
			PagoTarjeta tarjeta = new PagoTarjeta(numTarjeta,fecha,totalPagar);
			tarjeta.realizarPago(totalPagar);
			tarjeta.imprimirRecibo();
			break;
		}
	}
	public static double montoTotal (List<Producto> listcompras) {
		double suma=0;
		for (Producto producto : listcompras) {
			suma+=producto.getPrecioUnitario();
		}
		return suma;
	}
}
