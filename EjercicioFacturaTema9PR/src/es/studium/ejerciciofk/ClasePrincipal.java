package es.studium.ejerciciofk;

public class ClasePrincipal {
	public static void main(String[] args) {
		VistaMenuPrincipal vmp = new VistaMenuPrincipal();
		Modelo m = new Modelo();
		new Controlador(vmp, m);
	}
}