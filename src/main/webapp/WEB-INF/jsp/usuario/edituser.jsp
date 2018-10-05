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
            <title>Editar Usuario</title>
        </head>
        <body>
            
             <!--Navigation Bar-->
        <nav class="blue-grey">
                <div class="nav-wrapper">
                    <a href="home.htm" class="brand-logo"><span class="lime-text text-accent-1">Prueba Seratic</span></a>
                     <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <!-- <li><a href="user.htm"><span class="lime-text text-accent-2">Usuario1</span></a></li>-->
                        <li><a href=""><span class="lime-text text-accent-2">Jugador1</span></a></li>
                        <li><a href=""><span class="lime-text text-accent-2">Repote1</span></a></li>
                        <li><a href=""><span class="lime-text text-accent-2">Salir</span></a></li>
                    </ul>
                </div>
                 
            </nav>
            
            <div class="container">
            <br/>
            <center><h4 style="color:teal">Registrar Usuario</h4></center>
            <br/>
            
            <form:form method="post" modelAttribute="usuario">                           
                <div class="row">                    
                    <div class="input-field col s6">
                        <i class="material-icons prefix">person</i>
                        <form:input id="icon_prefix" path="nombre" type="text" class="validate" required="true" aria-required="true"/>
                        <form:label for="icon_prefix" path="nombre">Nombre</form:label>                        
                    </div>
                    <div class="input-field col s6">
                        <i class="material-icons prefix">person</i>
                        <form:input id="icon_prefix" path="apellido" type="text" class="validate" required="true" aria-required="true"/>
                        <form:label for="icon_prefix" path="apellido">Apellido</form:label>                        
                    </div>
                    <div class="input-field col s6">    
                        <i class="material-icons prefix">dehaze</i>
                            <form:select path="tipo">                                
                                <form:option value="none" disabled="true" selected="true">Selecciona</form:option>                                                                 
                                <form:option  value="administrador">Administrador</form:option>  
                                <form:option  value="basico">Basico</form:option>  
                            </form:select>
                            <label>Seleccione el Tipo de Usuario</label>
                    </div> 
                    <div class="input-field col s6">
                        <i class="material-icons prefix" >date_range</i>
                        <form:input id="icon_prefix" path="fecha" type="text" class="validate" required="true" aria-required="true"/>
                        <form:label for="icon_prefix" path="fecha">Fecha de Registro (AAAA-MM-DD HH:MM:SS)</form:label>                         
                    </div> 
                </div>                
                
                <div class="row">
                                        
                    <div class="input-field col s6">
                        <i class="material-icons prefix" >account_circle</i>
                        <form:input id="icon_prefix" path="usuario" type="text" class="validate" required="true" aria-required="true"/>
                        <form:label for="icon_prefix" path="usuario">Usuario</form:label> 
                    </div>
                    <div class="input-field col s6">
                        <i class="material-icons prefix" >lock_outline</i>
                        <form:input id="icon_prefix" path="clave" type="password" class="validate" required="true" aria-required="true"/>
                        <form:label for="icon_prefix" path="clave">Contraseña</form:label>                         
                    </div>
                                                
                </div>
                <div class="row">
                <br></br>
                    <center><button class="waves-effect waves-yellow btn black" type="submit" name="submit">Actualizar</button></center>
                </div>       
                    
            </form:form>                                                                    
        </div>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
        <!--  Scripts-->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="<c:url value='/js/materialize.js'/>"></script>
        <script src="<c:url value='/js/init.js'/>"></script>  
        <script>        
            $('select').material_select();
            $('.datepicker').pickadate({
            selectMonths: true, // Creates a dropdown to control month
            selectYears: 15 // Creates a dropdown of 15 years to control year
            });
        </script>
    </body>
    </html>

