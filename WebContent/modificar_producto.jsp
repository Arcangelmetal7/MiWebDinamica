<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ page import="java.util.*, controlador.* " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar producto</title>
</head>

<body>

<h1>MODIFICAR PRODUCTO</h1>
<h2>Modifique los campos que desee</h2>



<form name="form4" method="get" action="miServlet">
<input type="hidden" name="parametro" value="modificar2">
<input type="hidden" name="code" value="${elproducto.code}">
<table>


<tr><td>SECCION        :</td><td> <input type="text" value="${elproducto.code}" name="seccion" id="seccion"></td></tr>
<tr><td>NOMBRE ARTÍCULO: </td><td><input type="text" value="${elproducto.nombre}" name="nombre" id="nombre"></td></tr>
<tr><td>PRECIO ARTÍCULO:</td><td> <input type="text" value="${elproducto.precio}" name="precio" id="precio"></td></tr>
<tr><td>FECHA ARTÍCULO :</td><td> <input type="text" value="${elproducto.fecha}" name="fecha" id="fecha"></td></tr>
<tr><td>IMPORTADO      :</td><td> <input type="text" value="${elproducto.importado}" name="importado" id="importado"></td></tr>
<tr><td>PAÍS DE ORIGEN :</td><td> <input type="text" value="${elproducto.pais}" name="pais" id="pais"></td></tr>

<tr><td><input type="submit" value="Modificar" name="insertar"/></td><td><input type="reset" value="restablecer" name="restablecer"/></td></tr>
</table>


</form>

</body>
</html>