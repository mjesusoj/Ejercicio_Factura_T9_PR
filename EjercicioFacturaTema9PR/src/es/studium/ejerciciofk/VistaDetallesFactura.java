package es.studium.ejerciciofk;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class VistaDetallesFactura extends Frame{

	private static final long serialVersionUID = 1L;

	Label lblNºFactura = new Label();
	
	JPanel pnlNumFactura = new JPanel();
	JPanel pnlFieldSetDetalles = new JPanel();
	JPanel pnlFieldSetLista = new JPanel();
	
	// Componentes for fieldset Detalles
	Label lblArticulo = new Label("Artículo:");
	Choice chcArticulo = new Choice();
	Label lblCantidad = new Label("Cantidad:");
	TextField txtCantidad = new TextField(13);
	Button btnAgregar = new Button("Agregar");
	
	// Componentes for fieldset lista
	TextArea txtLista = new TextArea();
	Label lblTotal = new Label("Total:");
	TextField txtTotal = new TextField();
	Button btnAceptar = new Button("Aceptar");
	Button btnCancelar = new Button("Cancelar");
	
	VistaDetallesFactura()
	{
		setTitle("Detalles Factura");
		// Componentes Num Factura
		pnlNumFactura.add(lblNºFactura);
		// Añadir componentes detalles
		pnlFieldSetDetalles.add(lblArticulo);
		pnlFieldSetDetalles.add(chcArticulo);
		pnlFieldSetDetalles.add(lblCantidad);
		pnlFieldSetDetalles.add(txtCantidad);
		pnlFieldSetDetalles.add(btnAgregar);
		// Componentes Lista
		pnlFieldSetLista.add(txtLista);
		pnlFieldSetLista.add(lblTotal);
		pnlFieldSetLista.add(txtTotal);
		pnlFieldSetLista.add(btnAceptar);
		pnlFieldSetLista.add(btnCancelar);
		
		add(pnlNumFactura, "North");
		add(pnlFieldSetDetalles, FlowLayout.CENTER);
		add(pnlFieldSetLista, "South");
		
		// Borde para el panel de los detalles
		Border bordepnlDetalles = new TitledBorder(new EtchedBorder(), "Detalles");
		pnlFieldSetDetalles.setBorder(bordepnlDetalles); 
		setSize(300,150);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}