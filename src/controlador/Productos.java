package controlador;

public class Productos {

	private String code;
	private String seccion;
	private String nombre;
	private String precio;
	private String fecha;
	private String importado;
	private String pais;

	public Productos(String code, String seccion, String nombre, String precio, String fecha, String importado,
			String pais) {

		this.code = code;
		this.seccion = seccion;
		this.nombre = nombre;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.pais = pais;
	}

	public Productos(String seccion, String nombre, String precio, String fecha, String importado, String pais) {

		this.seccion = seccion;
		this.nombre = nombre;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.pais = pais;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getImportado() {
		return importado;
	}

	public void setImportado(String importado) {
		this.importado = importado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Productos [code=" + code + ", seccion=" + seccion + ", nombre=" + nombre + ", precio=" + precio
				+ ", fecha=" + fecha + ", importado=" + importado + ", pais=" + pais + "]";
	}

}
