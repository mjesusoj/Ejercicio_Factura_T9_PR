package es.studium.ejerciciofk;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

public class VistaDetallesFactura extends Frame{

	private static final long serialVersionUID = 1L;

	Label lblN�Factura = new Label("");
	
	VistaDetallesFactura()
	{
		setTitle("Detalles Factura");
		setLayout(new FlowLayout());
		add(lblN�Factura);
		setSize(300,150);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}