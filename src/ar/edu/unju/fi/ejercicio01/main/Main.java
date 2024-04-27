package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;

public class Main {

	public static void main(String[] args) {
		ArrayList<Producto> productos = new ArrayList<>();
		int opcion;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("\n--MENU--");
			System.out.println("1. Crear Producto");
			System.out.println("2. Mostrar Productos");
			System.out.println("3. Modificar Productos (no puede modificar el codigo del producto)");
			System.out.println("4. Salir");
			System.out.print("Elija una opcion:");
			opcion = scanner.nextInt();
			switch(opcion) {
				case 1: 
					System.out.println("\n--Crear un Producto--");
					System.out.print("Ingrese el codigo: ");
					int codigo = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Ingrese la descripcion: ");
					String descripcion = scanner.nextLine();
					System.out.print("Ingrese un precio unitario: ");
					double	precio = scanner.nextDouble();
					Producto.OrigenFabricacion origen = Producto.OrigenFabricacion.ARGENTINA;
					int op=0;
					do {
						System.out.println("\n--Origen de Fabricacion--");
						System.out.println("1. ARGENTINA");
						System.out.println("2. CHINA");
						System.out.println("3. BRASIL");
						System.out.println("4. URUGUAY");
						System.out.print("Elija una opcion: ");
						op=scanner.nextInt();
					} while (op<1 && op>4);
					
					switch(op) {
						case 1: origen = Producto.OrigenFabricacion.ARGENTINA; 
							break;
						case 2: origen = Producto.OrigenFabricacion.CHINA; 
							break;
						case 3: origen = Producto.OrigenFabricacion.BRASIL; 
							break;
						case 4: origen = Producto.OrigenFabricacion.URUGUAY; 
							break;
					}
					
					op=0;
					Producto.Categoria categori= Producto.Categoria.TELEFONIA;;
					
					do {
						System.out.println("\n--Categoria--");
						System.out.println("1. TELEFONIA");
						System.out.println("2. INFORMATICA");
						System.out.println("3. ELECTRO HOGAR");
						System.out.println("4. HERRAMIENTAS");
						System.out.print("Elija una opcion: ");
						op = scanner.nextInt();
					} while (op<1 && op>4);
					switch(op) {
						case 1: categori = Producto.Categoria.TELEFONIA; 
							break;
						case 2: categori = Producto.Categoria.INFORMATICA; 
							break;
						case 3: categori = Producto.Categoria.ELECTRO_HOGAR; 
							break;
						case 4: categori = Producto.Categoria.HERRAMIENTAS; 
							break;
					}
					Producto producto = new Producto(codigo, descripcion, precio, origen, categori);
					
					productos.add(producto);
					
					System.out.println("Se agrego el producto correctamente!");
					break;
				case 2: System.out.println("\n--Mostrar Productos--");
					for (int i = 0; i < productos.size(); i++) {
						Producto elemento = productos.get(i);
						System.out.println();
						System.out.println("Elemento N°" +(i + 1));
						elemento.MostrarDatos();
					}
					break;
				case 3: System.out.println("\n--Cambiar Datos--");
					System.out.println("Ingrese el codigo del producto a modificar: ");
					int codigocambiar = scanner.nextInt();
					
					Iterator<Producto> iterat = productos.iterator();
					int numeroposicion=0;
					scanner.nextLine(); 
					while (iterat.hasNext()) {
						Producto aux = iterat.next();
						if (aux.getCodigo() == codigocambiar) {
							System.out.print("Ingrese una descripcion: ");
							String descripcionnueva = scanner.nextLine();
							int precionuevo=0;
							System.out.print("Ingrese un precio unitario (un numero entero positivo): ");
							precionuevo = scanner.nextInt();
							Producto.OrigenFabricacion origennuevo = Producto.OrigenFabricacion.ARGENTINA;
							op=0;
							do {
								System.out.println("\n--Origen de Fabricacion--");
								System.out.println("1. TELEFONIA");
								System.out.println("2. INFORMATICA");
								System.out.println("3. ELECTRO HOGAR");
								System.out.println("4. HERRAMIENTAS");
								System.out.print("Elija una opcion: ");
								op = scanner.nextInt();
							} while (op<0 && op>5);
							
							switch(op) {
								case 1: origennuevo = Producto.OrigenFabricacion.ARGENTINA; 
									break;
								case 2: origennuevo = Producto.OrigenFabricacion.CHINA; 
									break;
								case 3: origennuevo = Producto.OrigenFabricacion.BRASIL; 
									break;
								case 4: origennuevo = Producto.OrigenFabricacion.URUGUAY; 
									break;
							}
							op=0;
							Producto.Categoria categorianueva = Producto.Categoria.TELEFONIA;;	
							do {
								System.out.println("\n--Categoria--");
								System.out.println("1. TELEFONIA");
								System.out.println("2. INFORMATICA");
								System.out.println("3. ELECTRO HOGAR");
								System.out.println("4. HERRAMIENTAS");
								System.out.print("Elija una opcion: ");
								op = scanner.nextInt();
							} while (op<1 && op>4);
							
							switch(op) {
								case 1: categorianueva = Producto.Categoria.TELEFONIA; break;
								case 2: categorianueva = Producto.Categoria.INFORMATICA; break;
								case 3: categorianueva = Producto.Categoria.ELECTRO_HOGAR; break;
								case 4: categorianueva = Producto.Categoria.HERRAMIENTAS; break;
							}
							
							Producto productonuevo = new Producto(codigocambiar, descripcionnueva, precionuevo, origennuevo, categorianueva);
							
							productos.set(numeroposicion, productonuevo);
							
							break;
						}
						numeroposicion++;
					}
					break;
				case 4: System.out.println("Programa Finalizado."); 
					break;
				
				default : System.out.println("Opcion incorrecta. Vuelva a intenbtarlo");
					break;
			}
		} while (opcion!=4);
	scanner.close();
	}

}
