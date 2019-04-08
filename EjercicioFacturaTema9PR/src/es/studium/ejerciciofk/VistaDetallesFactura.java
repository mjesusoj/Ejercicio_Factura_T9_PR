package es.studium.ejerciciofk;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class VistaDetallesFactura extends Frame{

	private static final long serialVersionUID = 1L;

	Label lblNºFactura = new Label();
	
	JPanel pnlSuperior = new JPanel();
	JPanel pnlFieldSet = new JPanel();
	
	// Componentes for fieldset Detalles
	Label lblArticulo = new Label("Artículo:");
	Choice chcArticulo = new Choice();
	Label lblCantidad = new Label("Cantidad:");
	TextField txtCantidad = new TextField(13);
	Button btnAgregar = new Button("Agregar");
	
	VistaDetallesFactura()
	{
		setTitle("Detalles Factura");
		//setLayout(new FlowLayout());
		pnlSuperior.add(lblNºFactura);
		pnlFieldSet.add(lblArticulo);
		pnlFieldSet.add(chcArticulo);
		pnlFieldSet.add(lblCantidad);
		pnlFieldSet.add(txtCantidad);
		pnlFieldSet.add(btnAgregar);
		add(pnlSuperior, "North");
		add(pnlFieldSet, FlowLayout.CENTER);
		Border bordejpanel = new TitledBorder(new EtchedBorder(), "Detalles");
		pnlFieldSet.setBorder(bordejpanel); 
		setSize(300,150);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}