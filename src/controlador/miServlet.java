package controlador;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class miServlet
 * 
 * 
 */
@WebServlet("/miServlet")
public class miServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Modelo miModelo;

	@Resource(name = "jdbc/Productos")
	private DataSource miPool;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			miModelo = new Modelo(miPool);
		} catch (Exception e) {
			throw new ServletException(e);

		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public miServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametro = request.getParameter("parametro");

		if (parametro == null)
			parametro = "mostrar";

		switch (parametro) {

		case "mostrar":
			muestraProductos(request, response);
			break;

		case "mostrar1":
			muestraProductos1(request, response);
			break;

		case "insertar":
			insertarProducto(request, response);
			break;

		case "modificar1":
			modificarProducto1(request, response);
			break;

		case "modificar2":
			modificarProducto2(request, response);
			break;

		case "eliminar":
			eliminarProducto(request, response);
			break;

		default:
			muestraProductos(request, response);
		}

	}

	private void muestraProductos1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String user = "admin";
		String pass = "1234";
		String user1 = request.getParameter("usuario");
		String pass1 = request.getParameter("contra");
		if (user1.equals(user) & pass1.equals(pass)) {

			muestraProductos(request, response);

		} else {
			System.out.println("Usuario incorrecto");

		}

	}

	private void modificarProducto2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String code = request.getParameter("code");
		String seccion = request.getParameter("seccion");
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String fecha = request.getParameter("fecha");
		String importado = request.getParameter("importado");
		String pais = request.getParameter("pais");

		// crea objeto con el formulario

		Productos elProducto = new Productos(code, seccion, nombre, precio, fecha, importado, pais);

		miModelo.actuaizaProducto(elProducto);

		muestraProductos(request, response);
	}

	private void modificarProducto1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String code = request.getParameter("codArt");
		Productos elProducto;
		// List<Productos> productos;

		try {
			elProducto = miModelo.getProducto1(code);

			request.setAttribute("elproducto", elProducto);
			// añade al request la info

			RequestDispatcher miD = request.getRequestDispatcher("/modificar_producto.jsp");
			// envia la info al jsp

			miD.forward(request, response);
			// System.out.println(elProducto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String code = request.getParameter("codArt");

		System.out.println(code);

		miModelo.borrarProducto(code);

		muestraProductos(request, response);

	}

	private void insertarProducto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		String seccion = request.getParameter("seccion");
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String fecha = request.getParameter("fecha");
		String importado = request.getParameter("importado");
		String pais = request.getParameter("pais");

		// crea objeto con el formulario

		Productos elProducto = new Productos(code, seccion, nombre, precio, fecha, importado, pais);

		miModelo.setProducto(elProducto);

		muestraProductos(request, response);
	}

	private void muestraProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		List<Productos> productos;

		try {
			productos = miModelo.getProductos();

			request.setAttribute("losproductos", productos);
			// añade al request la info

			RequestDispatcher miD = request.getRequestDispatcher("/vista.jsp");
			// envia la info al jsp

			miD.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
