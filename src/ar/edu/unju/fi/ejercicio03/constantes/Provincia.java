package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {
	JUJUY(672260, 53219), 
    SALTA(1214441, 155488), 
    TUCUMAN(1698422, 22524), 
    CATAMARCA(367820, 102606), 
    LA_RIOJA(331847, 89680), 
    SANTIAGO_DEL_ESTERO(874006, 136351);
	private int cantPoblacion;
	private double superficie;
	
	private Provincia(int cantPoblacion, double superficie) {
		this.cantPoblacion = cantPoblacion;
		this.superficie = superficie;
	}

	public int getCantPoblacion() {
		return cantPoblacion;
	}

	public void setCantPoblacion(int cantPoblacion) {
		this.cantPoblacion = cantPoblacion;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	
	public double DensidadPoblacional () {
		return cantPoblacion/superficie;
	}
	
}
