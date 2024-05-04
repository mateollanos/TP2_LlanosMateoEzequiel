package ar.edu.unju.fi.ejercicio05.model;

public class Producto extends ar.edu.unju.fi.ejercicio01.model.Producto {
	private boolean estado;

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Producto(int codigo, String descripcion, double precioUnitario, OrigenFabricacion origenFabricacion,
			Categoria categoria, boolean estado) {
		super(codigo, descripcion, precioUnitario, origenFabricacion, categoria);
		this.estado = estado;
	}
	
	public void MostrarDatos () {
		System.out.println("Codigo: "+ getCodigo()+" - Descripcion: "+ getDescripcion()+" - Precio: $"+
	getPrecioUnitario()+" - Origen de fabricación: "+getOrigenFabricacion()+" - Categoria: "+getCategoria()+
	" - Estado: "+estado);
	}

	
	
	
}
