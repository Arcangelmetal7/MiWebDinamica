<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar producto</title>
<style type="text/css">
body{
background: gray;
}
h1{
text-align:center;
background: blue;
font-weight: bold;
}


</style>
</head>
<body>

<h1>INSERTAR PRODUCTO</h1>

<ul>
	<li><form  method="get" action="miServlet">
			<input type="hidden" name="parametro" value="mostrar">
			<input type="submit" value="Volver" name="volver"/>
			
		</form>
	</li>
</ul>

<form name="form1" method="get" action="miServlet">
<input type="hidden" name="parametro" value="insertar">
<table>
<tr><td>CODIGO ARTÍCULO:</td><td> <input type="text" name="code" id="code"></td></tr>
<tr><td>SECCION        :</td><td> <input type="text" name="seccion" id="seccion"></td></tr>
<tr><td>NOMBRE ARTÍCULO: </td><td><input type="text" name="nombre" id="nombre"></td></tr>
<tr><td>PRECIO ARTÍCULO:</td><td> <input type="text" name="precio" id="precio"></td></tr>
<tr><td>FECHA ARTÍCULO :</td><td> <input type="text" name="fecha" id="fecha"></td></tr>
<tr><td>IMPORTADO      :</td><td> <input type="text" name="importado" id="importado"></td></tr>
<tr><td>PAÍS DE ORIGEN :</td><td> <input type="text" name="pais" id="pais"></td></tr>
<tr><td><input type="submit" value="insertar" name="insertar"/></td><td><input type="reset" value="restablecer" name="restablecer"/></td></tr>
</table>

</form>

</body>
</html>