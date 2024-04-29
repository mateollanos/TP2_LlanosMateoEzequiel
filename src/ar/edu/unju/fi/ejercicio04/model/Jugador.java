package ar.edu.unju.fi.ejercicio04.model;

import java.time.LocalDate;
import java.time.Period;
import ar.edu.unju.fi.ejercicio04.constantes.Posicion;

public class Jugador {
	private String Nombre;
	private String Apellido;
	private LocalDate FechaNac;
	private String Nacionalidad;
	private float Estatura;
	private float Peso;
	private Posicion Posicion;
	
	public Jugador() {
	}
	
	public Jugador(String nombre, String apellido, LocalDate fechaNac, String nacionalidad, 
			float estatura, float peso, Posicion posicion) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		FechaNac = fechaNac;
		Nacionalidad = nacionalidad;
		Estatura = estatura;
		Peso = peso;
		Posicion = posicion;
	}

	public int CalcularEdad() {
		LocalDate actual = LocalDate.now();
		Period periodo = Period.between(getFechaNac(),actual);
		int edad = periodo.getYears();
		if (actual.isBefore(getFechaNac().plusYears(edad))) {
			edad--;
		}
		return edad;
	}
	public void MostrarDatos() {
		System.out.println("Nombre: "+getNombre());
		System.out.println("Apellido: "+getApellido());
		System.out.println("Fecha de nacimiento: "+getFechaNac());
		System.out.println("Nacionalidad: "+getNacionalidad());
		System.out.println("Estatura: "+getEstatura());
		System.out.println("Peso: "+getPeso());
		System.out.println("Posicion: "+getPosicion());
	}
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public LocalDate getFechaNac() {
		return FechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		FechaNac = fechaNac;
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public float getEstatura() {
		return Estatura;
	}

	public void setEstatura(float estatura) {
		Estatura = estatura;
	}

	public float getPeso() {
		return Peso;
	}

	public void setPeso(float peso) {
		Peso = peso;
	}

	public Posicion getPosicion() {
		return Posicion;
	}

	public void setPosicion(Posicion posicion) {
		Posicion = posicion;
	}
	
	
	
}
