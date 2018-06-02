<%-- 
    Document   : index
    Created on : 1/06/2018, 09:49:29 AM
    Author     : Andres
--%>

<%@page import="interprete.controlador.Interprete"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> Compiladores </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="stylesheet" href="assets/css/bootstrap.css" media="screen">
        <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
	<div class="navbar navbar-expand-lg fixed-top navbar-dark navbar-transparent bg-primary">
            <div class="container">
                <a href="#" class="navbar-brand">ESCOM</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav">
                        <li class="nav-item"><a class="nav-link elemento-scroll" href="#seccion1"> Análisis Léxico y Sintáctico </a></li>
                        <div id="munu-extendido">
                            <li class="nav-item"><a class="nav-link elemento-scroll" href="#seccion2"> Algoritmos Análisis Sintáctico </a></li>
                        </div>
                    </ul>
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link elemento-scroll" href="#seccion9" > Ref. </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

	<div class="splash">
            <div class="container splash-body">
                <div class="col-lg-12" style="color: #FFF !important">
                    <!-- <div><img class="logo" src="assets/img/logo.png"></div> -->
                    <h1 class="etiqueta-contenido"> Instituto Politécnico Nacional </h1>
                    <h2 class="etiqueta-contenido"> Escuela Superior de Cómputo </h2>
                    <br><br>
                    <span class="etiqueta-contenido">COMPILADORES</span>
                    <br><br>
                    <span class="etiqueta-contenido"><b> 4CM2 </b></span>
                    <div id="social"></div>
                    <div class="row">
                        <div class="col-md-6 col-md-offset-3">
                            <div class="sponsor">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="seccion1" class="introduccion seccion seccion-negro fuente-blanco">
            <div class="container">
                <h1 class="display-5">Análisis Léxico y Sintáctico</h1>
                <p class="lead">
                    En esta sección podrás ingresar tu gramática y está sera procesada por un Alizador Léxico
                </p>
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-12">
                        <form>
                            <label for="exampleTextarea">Ingresa tu gramática</label>
                            <textarea class="form-control" id="gramaticaVar" rows="10"></textarea>
                            <br>
                            <input type="button" id="enviarGramatica" class="btn btn-info" value="Analizar Gramática" /> 
                        </form>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12">
                        <h5> Reglas </h5>
                        <div class="fuente-negro" id="reglas">
                            <div class="bs-component">
                                <ul class="list-group">
                                  <li class="list-group-item d-flex justify-content-between align-items-center">
                                    Aquí se muestran las reglas de las grámaticas 
                                    <span class="badge badge-primary badge-pill">0</span>
                                  </li>
                                </ul>
                                <div id="source-button" class="btn btn-primary btn-xs" style="display: none;">&lt; &gt;</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	


	<div id="seccion2" class="seccion seccion-royal seccion-sombra fuente-blanco">
		<div class="container">
                        <h1 class="display-5">Algoritmos Análisis Sintáctico</h1>
			<p class="lead">
			asd
			</p>
		</div>
	</div>
    
	<footer class="footer seccion-negro fuente-blanco">
	    <div class="footer-copyright py-1 text-center">
	    	<p>Pagina creada el 06-05-18 por Gusatvo Andrés López Sánchez</p>
	        <!--© 2018 Copyright:
	        <a href="#"> www.ipn.mx </a>
	    	-->
	    </div>
	</footer>
	<script src="assets/js/jquery-3.3.1.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/index.js"></script>
            
	<script>
            $(document).ready(function() {
                    $('#enviarGramatica').click(function(event) {
                            var gramaticaVar = $('#gramaticaVar').val();
                            
                            // Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
                            $.post('Interprete', {
                                    gramatica : gramaticaVar
                            }, function(responseText) {
                                    $('#reglas').html(responseText);
                            });
                    });
            });
        </script>
</body>
</html>
