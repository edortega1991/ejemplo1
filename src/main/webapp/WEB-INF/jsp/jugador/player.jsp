<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
    <html>
        <head>
            <meta charset="UTF-8">
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
            <!-- css -->
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <link href="<c:url value='/css/materialize.css'/>" type="text/css" rel="stylesheet" media="screen,projection"/>
            <link href="<c:url value='/css/style.css'/>" type="text/css" rel="stylesheet" media="screen,projection"/>
            <title>Jugador</title>
            </head>
        <body>
             <nav class="blue-grey">
                <div class="nav-wrapper">
                    <a href="home.htm" class="brand-logo"><span class="lime-text text-accent-1">Prueba Seratic</span></a>
                     <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <!-- <li><a href="user.htm"><span class="lime-text text-accent-2">Usuario1</span></a></li>-->
                        <li><a href=""><span class="lime-text text-accent-2">Jugador1</span></a></li>
                        <li><a href=""><span class="lime-text text-accent-2">Repote1</span></a></li>
                        <li><a href="<c:url value="buscarPlayer.htm?id=2"/>" name="id"><span class="lime-text text-accent-2">Salir</span></a></li>
                    </ul>
                </div>
                 
            </nav>
            </br>
            </br>
            
            <h2 class="center"><span class="yellow-text text-darken-4">Gestión de Jugadores</span></h2>
            <div class="container"> 
                     <table id="tabla" class="highlight centered responsive-table">
                         <thead>
                            <tr>
                              <th>Nombre</th>
                              <th>Apellido</th>
                              <th>Club</th>
                              <!--<th>Clave</th>
                              <th>Tipo</th>
                              <th>Fecha de Registro</th>-->
                              <th>Acciones</th>
                              <th></th>
                            </tr>

                         </thead>
                         
                         <tbody>
                            <c:forEach items="${jugadores}" var="jugador" >
                                <tr>
                            <td><c:out value="${jugador.nombre}"/></td>
                            <td><c:out value="${jugador.apellido}"/></td>
                            <td><c:out value="${jugador.club}"/></td>
                            <td> 
                                <a  href="<c:url value="editplayer.htm?id=${jugador.id}"/> "> <i class="material-icons right">edit</i></a>
                                <a href="<c:url value="deleteplayer.htm?id=${jugador.id}"/>" ><i class="material-icons right">delete</i></a>
                            </td>
                            </tr>    
                            </c:forEach>    
                         </tbody>
                         
                         </table>
                 </div>
            <div class="row">
                <!--<div class="col s12"-->
                    <a href="addplayer.htm" class="btn large waves-effect waves-light btn"><i class="material-icons right">add_circle</i>Agregar</a> 
                <!--</div>    -->
            </div>        
        </body>
    </html>

