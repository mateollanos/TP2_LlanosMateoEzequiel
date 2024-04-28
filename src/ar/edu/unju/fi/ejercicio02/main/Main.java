package ar.edu.unju.fi.ejercicio02.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		List<Efemeride> lista = new ArrayList<>();
		boolean band;
		int op;
		do {
			System.out.println("\n--MENU--");
			System.out.println("1 - Crear efeméride");
            System.out.println("2 - Mostrar efemérides");
            System.out.println("3 - Eliminar efeméride");
            System.out.println("4 - Modificar efeméride");
            System.out.println("5 - Salir");
            System.out.print("Ingrese una opción: ");
            op=scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                	System.out.println("\n--Crear Efeméride--");
                    System.out.print("Ingrese código: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Ingrese el mes [1,12]: ");
                    int nMes = scanner.nextInt();
                    while (nMes<1||nMes>12) {
                        System.out.print("Ingrese un número válido de mes [1,12]: ");
                        nMes = scanner.nextInt();
                        scanner.nextLine();
                    }
                    Mes mes = Mes.values()[nMes - 1];
                    System.out.print("Ingrese día: ");
                    band=false;
                    int dia = 0;
                    do {
						try {
							dia = scanner.nextInt();
							band=true;
						} catch (Exception e) {
							System.out.println("Error. Vuelva a intentarlo");
							scanner.nextLine();
						}
					} while(!band);
                    scanner.nextLine();
                    System.out.print("Ingrese detalle: ");
                    String detalle=scanner.nextLine();
                    
                    Efemeride efemeride = new Efemeride(codigo, mes, dia, detalle);
                    lista.add(efemeride);
                    System.out.println("Efeméride creada exitosamente!");
                    break;
                case 2:
                	if (lista.isEmpty()) {
                		System.out.println("Error. Al parecer no hay ninguna efeméride registrada");
                	} else {
                		int num=1;
                        System.out.println("\n--Mostrar Efemérides--");
                        System.out.println();
                        for (Efemeride elemento : lista) {
                        	System.out.println("Efemeride N "+num);
                            elemento.MostrarDatos();
                            num++;
                        }
                	}      	             	
                    break;
                case 3:
                	if (lista.isEmpty()) {
                		System.out.println("Error. Al parecer no hay ninguna efeméride registrada");
                	} else {
                		band=false;
                        System.out.println("\n--Eliminar efeméride--");
                        System.out.print("Ingrese el código de la efeméride a eliminar: ");
                        String cod=scanner.next();
                        for (Efemeride elemento:lista) {
                        	if (cod.equals(elemento.getCodigo())) {
                        		lista.remove(elemento);
                        		band=true;
                        		break;
                        	}
                        }
                        if (band) System.out.println("La efeméride se elimino correctamente!");
                        else System.out.println("No se encontraron coincidencias");
                	}       	
                    break;
                case 4:
                	if (lista.isEmpty()) {
                		System.out.println("Error. Al parecer no hay ninguna efeméride registrada");
                	} else {
                		band=false;
                        System.out.println("\n--Modificar efeméride--");
                        System.out.print("Ingrese el código de la efeméride a modificar: ");
                        String cod=scanner.next();
                        for (Efemeride elemento:lista) {
                        	if (cod.equals(elemento.getCodigo())) {
                        		modificar(elemento);
                        		band=true;
                        	}
                        }
                        if (!band) {
                        	System.out.println("No se encontraron coincidencias");
                        } else {
                        	System.out.println("Efeméride modificada correctamente!");
                        }
                	}
                    break;
                case 5:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opción incorrecta. Vuelva a intentarlo");
                    break;
            }
		}while (op!=5);
		scanner.close();
	}
	public static void modificar(Efemeride ef) {
		Scanner scan = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("1 - Modificar código");
			System.out.println("2 - Modificar mes");
			System.out.println("3 - Modificar dia");
			System.out.println("4 - Modificar detalle");
			System.out.println("5 - Cancelar");
			System.out.print("Elija lo que quiere modificar: ");
			System.out.println();
			opcion=scan.nextInt();
			scan.nextLine();
			switch(opcion) {
			case 1:
				System.out.print("Ingrese el nuevo codigo: ");
				String codigo = scan.nextLine();
				ef.setCodigo(codigo);
				break;
			case 2: 
				System.out.print("Ingrese el nuevo mes [1,12]: ");
				int nMes = scan.nextInt();
	            while (nMes<1||nMes>12) {
	                System.out.print("Ingrese un número válido de mes [1,12]: ");
	                nMes = scan.nextInt();
	                scan.nextLine();
	            }
	            Mes mes = Mes.values()[nMes - 1];
	            ef.setMes(mes);
				break;
			case 3:
				System.out.print("Ingrese el nuevo dia: ");
				boolean band=false;
	            int dia=0;
	            do {
						try {
							dia = scan.nextInt();
							band=true;
						} catch (Exception e) {
							System.out.println("Error. Vuelva a intentarlo");
							scan.nextLine();
						}
				 } while(!band);
	             ef.setDia(dia);
	             scan.nextLine();
				break;
			case 4:
				System.out.print("Ingrese el nuevo detalle: ");
				String detalle=scan.nextLine();
				ef.setDetalle(detalle);
				break;
			case 5: 
				System.out.println("Operación cancelada");
				break;
			default: 
				System.out.println("Valor no valido");
				break;
			}	
		} while (opcion!=5);
		
	}
}
