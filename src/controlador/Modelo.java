package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * @author Adrian Calderon La aplicacion funciona enlazando con MySQL en una
 *         base de datos "cursopruebas" especificamente en la tabla "productos"
 *         mediante el jdbc y un pool de conexiones configurado en el
 *         context.xml.
 * 
 *         (fecha 20/4/2021) En el repositorio guardé la base de datos en la
 *         carpeta "BBDDmySQL"
 *
 */
public class Modelo {

	DataSource miPool;

	public Modelo(DataSource pool) {

		this.miPool = pool;
	}

	public List<Productos> getProductos() throws Exception {

		List<Productos> miLista = new ArrayList();

		Connection miConexion;
		Statement miStatement;
		ResultSet rs;

		miConexion = miPool.getConnection();
		miStatement = miConexion.createStatement();
		String query = "SELECT * FROM PRODUCTOS";
		rs = miStatement.executeQuery(query);
		while (rs.next()) {
			String code = rs.getString(1);
			String seccion = rs.getString(2);
			String nombre = rs.getString(3);
			String precio = rs.getString(4);
			String fecha = rs.getString(5);
			String importado = rs.getString(6);
			String pais = rs.getString(7);

			Productos temp = new Productos(code, seccion, nombre, precio, fecha, importado, pais);

			miLista.add(temp);
		}
		return miLista;

	}

	public void setProducto(Productos elProducto) {
		// TODO Auto-generated method stub

		try {

			Connection miConexion = miPool.getConnection();
			String query = "INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO,SECCIÓN,NOMBREARTÍCULO,PRECIO,FECHA,IMPORTADO,PAÍSDEORIGEN)"
					+ "VALUES(?,?,?,?,?,?,?)";
			PreparedStatement miStatement = miConexion.prepareStatement(query);

			miStatement.setString(1, elProducto.getCode());
			miStatement.setString(2, elProducto.getSeccion());
			miStatement.setString(3, elProducto.getNombre());
			miStatement.setString(4, elProducto.getPrecio());
			miStatement.setString(5, elProducto.getFecha());
			miStatement.setString(6, elProducto.getImportado());
			miStatement.setString(7, elProducto.getPais());

			miStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("no se agergo el producto");
		}

	}

	public void borrarProducto(String code) {
		// TODO Auto-generated method stub

		try {

			Connection miConexion = miPool.getConnection();
			String query = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO=?";
			PreparedStatement miStatement = miConexion.prepareStatement(query);

			miStatement.setString(1, code);

			miStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("no se borro el producto");
		}

	}

	public Productos getProducto1(String code) throws Exception {
		// TODO Auto-generated method stub

		Productos producto;
		String codigo = code;

		Connection miConexion;
		PreparedStatement miStatement;
		ResultSet rs;

		miConexion = miPool.getConnection();

		String query = "SELECT * FROM PRODUCTOS WHERE CÓDIGOARTÍCULO=?";
		miStatement = miConexion.prepareStatement(query);
		miStatement.setString(1, code);

		rs = miStatement.executeQuery();
		if (rs.next()) {
			String code1 = rs.getString(1);
			String seccion = rs.getString(2);
			String nombre = rs.getString(3);
			String precio = rs.getString(4);
			String fecha = rs.getString(5);
			String importado = rs.getString(6);
			String pais = rs.getString(7);

			producto = new Productos(code1, seccion, nombre, precio, fecha, importado, pais);

		} else {
			throw new Exception("No existe ese producto");
		}
		return producto;
	}

	public void actuaizaProducto(Productos elProducto) {
		// TODO Auto-generated method stub
		Productos producto = elProducto;
		Connection miConexion;
		PreparedStatement miStatement;

		try {
			miConexion = miPool.getConnection();

			String query = "UPDATE PRODUCTOS SET SECCIÓN=?,NOMBREARTÍCULO=?,PRECIO=?,FECHA=?,IMPORTADO=?,PAÍSDEORIGEN=? WHERE CÓDIGOARTÍCULO=?";
			miStatement = miConexion.prepareStatement(query);
			miStatement.setString(1, producto.getSeccion());
			miStatement.setString(2, producto.getNombre());
			miStatement.setString(3, producto.getPrecio());
			miStatement.setString(4, producto.getFecha());
			miStatement.setString(5, producto.getImportado());
			miStatement.setString(6, producto.getPais());
			miStatement.setString(7, producto.getCode());

			miStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}