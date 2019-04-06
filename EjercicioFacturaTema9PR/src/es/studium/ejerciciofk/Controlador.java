package es.studium.ejerciciofk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, ActionListener{
	VistaMenuPrincipal vmp = null;
	VistaAltaFactura vafactura = null;
	VistaDetallesFactura vdfactura = null;
	Modelo m = null;

	public Controlador(VistaMenuPrincipal vmp, Modelo m) {
		this.vmp = vmp;
		this.m = m;
		vmp.addWindowListener(this);
		vmp.btnAlta.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (vmp.btnAlta.equals(arg0.getSource())) {
			vmp.setVisible(false);
			vafactura = new VistaAltaFactura();
			
			Modelo.cargarClienteBD(vafactura);
			
			vafactura.addWindowListener(this);
			vafactura.btnSiguiente.addActionListener(this);
			vafactura.btnCancelar.addActionListener(this);
		}
		else if(vafactura.btnSiguiente.equals(arg0.getSource())){
			Modelo.insertardatosfactura(vafactura);
			Modelo.insertardetallesfactura(null);
			
			vafactura.setVisible(false);
			vdfactura = new VistaDetallesFactura();
			vdfactura.addWindowListener(this);
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {
		if (vmp.isActive()) {
			System.exit(0);
		}else if(vafactura.isActive()) {
			vafactura.setVisible(false);
			vmp.setVisible(true);
		}else if(vdfactura.isActive()) {
			vdfactura.setVisible(false);
			vafactura.setVisible(true);
		}
	}

	@Override
	public void windowDeactivated(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowOpened(WindowEvent e) {}
}
