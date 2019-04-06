package es.studium.ejerciciofk;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class VistaMenuPrincipal extends Frame{

	private static final long serialVersionUID = 1L;
	
	Button btnAlta = new Button("Alta Factura");
	
	VistaMenuPrincipal()
	{
		setTitle("Alta Factura");
		setLayout(new FlowLayout());
		setSize(370,200);
		add(btnAlta);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}