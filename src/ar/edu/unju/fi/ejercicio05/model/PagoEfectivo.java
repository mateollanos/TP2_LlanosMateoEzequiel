package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoEfectivo implements Pago {
	public static final double d=0.1;
	private double Monto_pagado;
	private LocalDate Fecha_de_pago;
	
	@Override
	public void realizarPago(double monto) {
		double descuento=monto*d;
		monto=monto-descuento;
		setMonto_pagado(monto);
	}
	@Override
	public void imprimirRecibo() {
		System.out.println("Fecha de pago: "+Fecha_de_pago);
		System.out.println("Monto pagado con descuento del 10%: "+Monto_pagado);
	}
	
	public PagoEfectivo(double monto_pagado, LocalDate fecha_de_pago) {
		super();
		Monto_pagado = monto_pagado;
		Fecha_de_pago = fecha_de_pago;
	}
	public double getMonto_pagado() {
		return Monto_pagado;
	}
	public void setMonto_pagado(double monto_pagado) {
		Monto_pagado = monto_pagado;
	}
	public LocalDate getFecha_de_pago() {
		return Fecha_de_pago;
	}
	public void setFecha_de_pago(LocalDate fecha_de_pago) {
		Fecha_de_pago = fecha_de_pago;
	}
	
	
}
