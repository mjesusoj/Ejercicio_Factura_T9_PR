package es.studium.ejerciciofk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Modelo {
	public static void cargarClienteBD(VistaAltaFactura vaf){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ejemplofk?autoReconnect=true&useSSL=false";
		String login = "root";
		String password = "Studium2018;";
		String sentencia = "SELECT * FROM clientes;";
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			//Crear una sentencia
			statement = connection.createStatement();
			//Crear un objeto ResultSet para guardar lo obtenido y ejecutar la sentencia SQL
			rs = statement.executeQuery(sentencia);
			vaf.chcCliente.add("Elegir uno...");
			vaf.txtFFactura.setText(fechasistema());
			while (rs.next())
			{
				int idCliente = rs.getInt("idCliente");
				String nombreCliente = rs.getString("nombreCliente");
				String apellidosCliente = rs.getString("apellidosCliente");
				String dniCliente = rs.getString("dniCliente");
				vaf.chcCliente.add(idCliente+"-"+" "+nombreCliente+" "+apellidosCliente+" "+"("+dniCliente+")");
			}
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		}
		finally
		{
			try
			{
				if(connection!=null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
				System.out.println("Error 3: "+e.getMessage());
			}
		}
	}
	
	public static void insertardatosfactura(VistaAltaFactura vafactura){
		String resultescogido = vafactura.chcCliente.getSelectedItem().substring(0,2).replace("-","");
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ejemplofk?autoReconnect=true&useSSL=false";
		String login = "root";
		String password = "Studium2018;";
		String sentencia = "INSERT INTO facturas VALUES(NULL, '"+fechasistemamysql()+"', '"+resultescogido+"');";
		Connection connection = null;
		Statement statement = null;

		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			//Crear una sentencia
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			System.out.println(sentencia);
			statement.executeUpdate(sentencia);
			vafactura.txtFFactura.setText(fechasistema());
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		}
		finally
		{
			try
			{
				if(connection!=null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
				System.out.println("Error 3: "+e.getMessage());
			}
		}
	}
	
	public static void insertardetallesfactura(VistaDetallesFactura vdfactura){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ejemplofk?autoReconnect=true&useSSL=false";
		String login = "root";
		String password = "Studium2018;";
		String sentencia = "SELECT idFactura FROM facturas;";
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			//Crear una sentencia
			statement = connection.createStatement();
			rs = statement.executeQuery(sentencia);
			while (rs.next()){
				int idFacturaFK = rs.getInt("idFactura");
				vdfactura.lblNºFactura.setText("Factura Nº" + idFacturaFK+ "");
			}
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		}
		finally
		{
			try
			{
				if(connection!=null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
				System.out.println("Error 3: "+e.getMessage());
			}
		}
	}
	
	public static void insertararticulos(VistaDetallesFactura vdfactura){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ejemplofk?autoReconnect=true&useSSL=false";
		String login = "root";
		String password = "Studium2018;";
		String sentencia = "SELECT idArticulo, descripcionArticulo FROM articulos;";
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			//Crear una sentencia
			statement = connection.createStatement();
			rs = statement.executeQuery(sentencia);
			// Añadir al choice
			vdfactura.chcArticulo.add("Elegir uno...");
			while (rs.next()){
				int idArticulo = rs.getInt("idArticulo");
				String descripcionArticulo = rs.getString("descripcionArticulo");
				
				vdfactura.chcArticulo.add(idArticulo + " " + "-" + " " + descripcionArticulo);
			}
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		}
		finally
		{
			try
			{
				if(connection!=null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
				System.out.println("Error 3: "+e.getMessage());
			}
		}
	}
	
	public static void insertarenlineafacturas(VistaDetallesFactura vdfactura){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ejemplofk?autoReconnect=true&useSSL=false";
		String login = "root";
		String password = "Studium2018;";
		String sentencia = null;
		Connection connection = null;
		Statement statement = null;

		try
		{
			String numerofactura = vdfactura.lblNºFactura.getText().replace("Factura Nº", "");
			int idFacturaFK = Integer.parseInt(numerofactura);
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			//Crear una sentencia
			statement = connection.createStatement();
			sentencia = "INSERT INTO lineasfactura VALUES(NULL, '"+idFacturaFK+"', '"+vdfactura.chcArticulo.getSelectedItem().substring(0,3).replace("-", "").replace(" ", "")+"','"+vdfactura.txtCantidad.getText()+"');";
			System.out.println(sentencia);
			statement.executeUpdate(sentencia);
		}
		
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		}
		finally
		{
			try
			{
				if(connection!=null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
				System.out.println("Error 3: "+e.getMessage());
			}
		}
	}
	
	public static void insertarlistadetalles(VistaDetallesFactura vdfactura){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ejemplofk?autoReconnect=true&useSSL=false";
		String login = "root";
		String password = "Studium2018;";
		String sentencia = "SELECT idArticulo, descripcionArticulo, precioArticulo FROM articulos;";
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			//Crear una sentencia
			statement = connection.createStatement();
			rs = statement.executeQuery(sentencia);
			System.out.println(sentencia);
			while (rs.next()){
				int idArticulo = rs.getInt("idArticulo");
				String descripcionArticulo = rs.getString("descripcionArticulo");
				String cantidadArticulo = vdfactura.txtCantidad.getText();
				Float precioArticulo = rs.getFloat("precioArticulo");
				
				// Insertar datos
				vdfactura.txtLista.setText("idArtículo"+" "+"Descripción"+" "+" "+" "+" "+"Cantidad"+" "+"Precio"+" "+" "+"Subtotal" 
				+"\n" + "\n" + idArticulo +" "+" "+" "+ descripcionArticulo +" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+cantidadArticulo +" "+ precioArticulo +" "+" "+ calcularSubTotal(cantidadArticulo, precioArticulo));
			}
		}
		
		
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2: "+sqle.getMessage());
		}
		finally
		{
			try
			{
				if(connection!=null)
				{
					connection.close();
				}
			}
			catch (SQLException e)
			{
				System.out.println("Error 3: "+e.getMessage());
			}
		}
	}
	
	public static float calcularSubTotal(String cantidadPrecio, float precioArticulo) {
		int cantidadArticulo = Integer.parseInt(cantidadPrecio);
		
		float subTotal = cantidadArticulo * precioArticulo;
		return subTotal;
	}
	
	public static String fechasistema(){
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
		
		String fecha = ft.format(dNow); 
		return fecha;
	}
	
	public static String fechasistemamysql(){
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		
		String fecha = ft.format(dNow); 
		return fecha;
	}
}