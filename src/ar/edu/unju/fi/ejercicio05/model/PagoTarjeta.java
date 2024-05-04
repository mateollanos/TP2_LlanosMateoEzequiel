package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoTarjeta implements Pago{
	public static final double r=0.15;
	private String Num_de_tarjeta; 
	private LocalDate Fecha_de_pago;
	private double Monto_pagado;
	
	@Override
	public void realizarPago(double monto) {
		double recarga=monto*r;
		monto = monto+recarga;
		setMonto_pagado(monto);
	}
	@Override
	public void imprimirRecibo() {
		System.out.println("Número de tarjeta: "+Num_de_tarjeta);
		System.out.println("Fecha de pago: "+Fecha_de_pago);
		System.out.println("Monto pagado con recarga del 15%: "+Monto_pagado);
		
	}
	
	public PagoTarjeta(String num_de_tarjeta, LocalDate fecha_de_pago, double monto_pagado) {
		super();
		Num_de_tarjeta = num_de_tarjeta;
		Fecha_de_pago = fecha_de_pago;
		Monto_pagado = monto_pagado;
	}
	public String getNum_de_tarjeta() {
		return Num_de_tarjeta;
	}
	public void setNum_de_tarjeta(String num_de_tarjeta) {
		Num_de_tarjeta = num_de_tarjeta;
	}
	public LocalDate getFecha_de_pago() {
		return Fecha_de_pago;
	}
	public void setFecha_de_pago(LocalDate fecha_de_pago) {
		Fecha_de_pago = fecha_de_pago;
	}
	public double getMonto_pagado() {
		return Monto_pagado;
	}
	public void setMonto_pagado(double monto_pagado) {
		Monto_pagado = monto_pagado;
	}

	
}
