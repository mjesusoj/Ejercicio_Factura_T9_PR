package es.studium.ejerciciofk;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class VistaAltaFactura extends Frame{
	
	private static final long serialVersionUID = 1L;

	Label lblFechaFactura = new Label("Fecha Factura:");
	TextField txtFFactura = new TextField();
	Label lblCliente = new Label("Cliente");
	Choice chcCliente = new Choice();
	Button btnSiguiente = new Button("Siguiente");
	Button btnCancelar = new Button("Cancelar");
	
	Panel pnlSuperior = new Panel();
	Panel pnlInferior = new Panel();
	Panel pnlCentral = new Panel();
	
	VistaAltaFactura()
	{
		setTitle("Alta Factura");
		setSize(370,200);
		pnlSuperior.add(lblFechaFactura);
		pnlSuperior.add(txtFFactura);
		pnlCentral.add(lblCliente);
		pnlCentral.add(chcCliente);
		pnlInferior.add(btnSiguiente);
		pnlInferior.add(btnCancelar);
		add(pnlSuperior,"North");
		add(pnlCentral,"Center");
		add(pnlInferior,"South");
		setLocationRelativeTo(null);
		setVisible(true);
	}
}