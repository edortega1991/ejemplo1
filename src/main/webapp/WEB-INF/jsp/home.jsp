<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
    <html>
        <head>
            
            <meta charset="UTF-8">
            <!-- para utliazar materialize -->
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">
            <!-- css, para cargar css al proyecto -->
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <link href="<c:url value='/css/materialize.css'/>" type="text/css" rel="stylesheet" media="screen,projection"/>
            <link href="<c:url value='/css/style.css'/>" type="text/css" rel="stylesheet" media="screen,projection"/>
            
            <title>Seratic1</title>
        </head>
        <body>
            <nav class="blue-grey">
                <div class="nav-wrapper">
                    <a href="" class="brand-logo"><span class="lime-text text-accent-1">Prueba Seratic</span></a>
                     <ul id="nav-mobile" class="right hide-on-med-and-down">
                         <li><a href="user.htm"><span class="lime-text text-accent-2">Usuario1</span></a></li>
                        <li><a href="player.htm"><span class="lime-text text-accent-2">Jugador1</span></a></li>
                        <li><a href=""><span class="lime-text text-accent-2">Repote1</span></a></li>
                        
                        <!--<li><a href="login.htm"><span class="lime-text text-accent-2">Salir</span></a></li>-->
                        <li> <a href="javascript:cerrar()">cerrar</a> </li>
                    </ul>
                </div>
            </nav>
            
            </br>   
            </br>   
            <!-- para las cartas de las 3-->
            <div class="container">
                    <div class="row" >
                    <div class="col s12 m3">
                        <div class="card">
                          <div class="card-image">
                              <img src=<c:url value='/images/usuario.png'/>>
                            <!--<span class="card-title">Card Title</span>-->
                          </div>
                          <div class="card-content">
                            <p>En esta seccion se encuetra la información de los usuarios.</p>
                          </div>
                          <div class="card-action">
                            <a href="user.htm">Usuario</a>
                          </div>
                        </div>
                    </div>



                    <div class="col s12 m3">
                        <div class="card">
                          <div class="card-image">
                              <img src=<c:url value='/images/jugador.jpg'/>>
                            <!--<span class="card-title">Card Title</span>-->
                          </div>
                          <div class="card-content">
                            <p>Toda la información hacerca de los jugadores, tambien agregar editar o eliminar.</p>
                          </div>
                          <div class="card-action">
                            <a href="player.htm">Jugador</a>
                          </div>
                        </div>
                      </div>
                     
                     <div class="col s12 m3">
                        <div class="card">
                          <div class="card-image">
                              <img src=<c:url value='/images/jugador.jpg'/>>
                            <!--<span class="card-title">Card Title</span>-->
                          </div>
                          <div class="card-content">
                            <p>Toda la información hacerca de lAs citas, tambien agregar editar o eliminar.</p>
                          </div>
                          <div class="card-action">
                            <a href="citas.htm">Citas</a>
                          </div>
                        </div>
                      </div>       

                     <div class="col s12 m3">
                        <div class="card">
                          <div class="card-image">
                            <img src=<c:url value='/images/Reporte1.png'/>>
                            <!--<span class="card-title">Card Title</span>-->
                          </div>
                          <div class="card-content">
                            <p>Los reportes de cada uno de los jugadores</p>
                          </div>
                          <div class="card-action">
                            <a href="#">Reportes</a>
                          </div>
                        </div>
                      </div>   
                  </div>      
            
           </div> 
            <h1><span class="red-text">Hola Parce, cómo vas?</span></h1>
        
           Fecha:
            <div id="datepicker"></div> 
        
        </body>
        
       <script language='javascript'>
        window.close();
    </script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
                });
            </script>
    </html>

