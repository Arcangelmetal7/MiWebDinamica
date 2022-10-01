<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, controlador.* " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestor de productos</title>

<style type="text/css">

header{
	background: rgba(16,56,248,.5);
	height: 100px;
	width: 960px;
	color: rgb(195,195,195);
	margin: 10px;
	padding: 20px;
	text-align: center;
}
nav{
	background: rgba(3,7,188,.6);
	height: 40px;
	width: 1000px;
	margin: 10px
}
nav ul{
	list-style: none;
}
nav ul li{
	float: left;
	text-align: center;
	margin: 10px;
}
#volver{
	float: right;
	background: gray;
	color: white;
	box-shadow: 0px 4px gray;
}
a:hover{
	background: black;
	color: white;
	padding: 5px;
	box-shadow: 0px 2px gray;
}

table{

float:left;

}

.cabecera{ 
font-weigth: bold;
background: #F00;
text-align: center;
}
.fila{

background: gray;
text-align: center;
}

#contBotones{

margin-left:4000 px;

}



</style>
</head>
<%
List<Productos> misProductos=(List<Productos>)request.getAttribute("losproductos");
%>
<body>
<header>
		<h1>GESTOR DE PRODUCTOS</h1>
		<p>Gestione sus productos con un click!</p>
	</header>
	<nav>
		<ul>
			<li><a href="developer.html"> Autor/Developer</a></li>
			<li><a href="aplicacion.html">Acerca de la aplicación</a></li>
			<li><a href="contacto.html">Contacto</a></li>
			<li><a href="ayuda.html">Ayuda</a></li>
			<li id="volver"><form  method="get" action="miServlet">
			<input type="hidden" name="parametro" value="mostrar">
			<input type="submit" value="Volver" name="volver"/>
			
			</form></li>
		</ul>
	</nav>

<table>
<tr >
<td class="cabecera">Código articulo</td>
<td class="cabecera">Seccion</td>
<td class="cabecera">Nombre articulo</td>
<td class="cabecera">precio</td>
<td class="cabecera">Fecha</td>
<td class="cabecera">importado</td>
<td class="cabecera">Pais de orígen</td>
<td class="cabecera">Acción</td>
</tr>

<%for(Productos temp: misProductos){%>
<tr>
<td class="fila"><%=temp.getCode() %></td>
<td class="fila"><%=temp.getSeccion() %></td>
<td class="fila"><%=temp.getNombre() %></td>
<td class="fila"><%=temp.getPrecio() %></td>
<td class="fila"><%=temp.getFecha() %></td>
<td class="fila"><%=temp.getImportado() %></td>
<td class="fila"><%=temp.getPais() %></td>
<td class="fila"><form name="form2" method="get" action="miServlet">
<input type="hidden" name="parametro" value="eliminar">
<input type="hidden" name="codArt" value=<%=temp.getCode() %>>
<input type="submit" value="Eliminar" name="Eliminar"/>

</form>

<form name="form3" method="get" action="miServlet">
<input type="hidden" name="parametro" value="modificar1">
<input type="hidden" name="codArt" value=<%=temp.getCode() %>>
<input type="submit" value="Modificar" name="Modificar" onclick="window.location.href='modificar_producto.jsp'"/>

</form>

</td>

	
</tr>

<%} %>


</table>

<div id="contBotones">

	<input type="button" value="Insertar producto" onclick="window.location.href='insertar_producto.jsp'"/>

</div>


</body>
</html>