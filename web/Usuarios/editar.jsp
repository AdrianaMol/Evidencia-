<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body style="box-sizing: border-box; margin: 0; padding: 0; font-family: Helvetica">
        <header>
            <nav style="background-color: #176B87; height: 30px; color: #F5E8C7; display: flex; justify-content: space-between; align-items: center;  padding: 20px 100px">
                <h3 style="font-size: 27px; ">Sistema de Usuarios - Adriana Molina</h3>
                <div style="color: #F5E8C7">
                    <ul style="list-style: none; display: flex; flex-direction: row; font-size: 20px;  color: #F5E8C7" >
                        <li style="color: #F5E8C7; padding-right: 10px; color: #F5E8C7">
                            <a style="color: #F5E8C7; text-decoration: none" href="CRUDUsers">Usuarios</a>
                        </li>
                        <li >
                            <a style="color: #F5E8C7; text-decoration: none" class="nav-link fs-3" href="ServletUser?accion=nuevo">Añadir</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <br>
        <div style="display: flex; align-content: center; justify-content: center">
            <div style="width: 700px">
                <div>
                    <h1 >Actualizar Usuario</h1>
                <hr/>
                <form action="ServletUser?accion=actualizar" method="POST" style="max-width: 270px">
                        
                        <input id="id" type="hidden" name="txtid" value="<c:out value="${proModificar.id}"/>">
                        <p style="display: flex; justify-content: space-between">Nombre: <input id="nombre" type="text" name="txtnombre" value="<c:out value="${proModificar.nombre}"/>"></p>
                        <p style="display: flex; justify-content: space-between">Email: <input id="email" type="text" name="txtemail" value="<c:out value="${proModificar.email}"/>"></p>
                        <p style="display: flex; justify-content: space-between">Contrasena: <input id="contrasena" type="text" name="txtcontrasena" value="<c:out value="${proModificar.contrasena}"/>"></p>
                        <button id="modificar" name="modificar" type="submit">Modificar</button>
                    </form>
                </div>
            </div>
        </div>


    </body>
</html>
