<%-- 
    Document   : index
    Created on : 1/06/2018, 09:49:29 AM
    Author     : Andres
--%>

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
            <li class="nav-item"><a class="nav-link elemento-scroll" href="#seccion1"> Análizador Léxico </a></li>
            <li class="nav-item"><a class="nav-link elemento-scroll" href="#seccion2"> Analizadores Sintácticos </a></li>
            <li class="nav-item"><a class="nav-link elemento-scroll" href="#seccion3"> Calculadora </a></li>
          </ul>

          <ul class="nav navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link elemento-scroll" href="#seccion9" > Ref. </a>
            </li>
          </ul>

        </div>
      </div>
    </div>

	<div class="splash" >
      <div class="container splash-body">
	    <div class="col-lg-12" style="color: #FFF !important">
	        <!-- <div><img class="logo" src="assets/img/logo.png"></div> -->
			<h1 class="etiqueta-contenido"> Instituto Politécnico Nacional </h1>
			<h2 class="etiqueta-contenido"> Escuela Superior de Cómputo </h2>
			<br><br>
	        <span class="etiqueta-contenido">COMPILADORES</span>
	        <br><br>
	        <span class="etiqueta-contenido"><b> 4CM2 </b></span>
	        <div id="social">
	        </div>
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
			<h1 class="display-5">Análizador Léxico</h1>
			<p class="lead">
                            En esta sección podrás ingresar tu gramática y está sera procesada por un Alizador Léxico
			</p>
			<div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-12">
                                <label for="exampleTextarea">Ingresa tu gramática</label>
                                <textarea class="form-control" id="exampleTextarea" rows="10"></textarea>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-12">
                                <h5> Reglas </h5>
                            </div>
                        </div>
                </div>
        </div>
	
	<div id="seccion2" class="bgIntro">
		<div class="etiqueta">
			<span class="etiqueta-contenido"><b> Introducción </b></span>
		</div>
	</div>

	<div class="seccion seccion-royal seccion-sombra fuente-blanco">
		<div class="container">
			<p class="lead">
				Como persona y futuro ingeniero en Sistemas Computacionales saber que espero de mí es fundamenta, es aquí 
				donde entra la pregunta de ¿Por qué hacer un Proyecto de Vida? En lo personal pienso que un proyecto de vida
				no sólo sirve para plantear las metas y objetivos que tienes a futuro o cosas que desearías alcanzar o tener
				en un determinado momento, sino que también es un recordatorio constante de que debes dar lo mejor de ti y
				esforzarte lo más que puedas para poder alanzar eso que deseas. También te ayuda a plantear las cosas que
				necesitas o te hacen falta para alcanzarlos es el caso de buscar áreas de oportunidad.
			</p>
		</div>
	</div>

	<div class="seccion seccion-azul seccion-sombra fuente-blanco">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<p class="lead">
						Me llamo Gustavo Andrés López Sánchez tengo 21 años, soy orgulloso estudiante de la Escuela Superior
						de Cómputo (ESCOM) y miembro de la comunidad del Instituto Politécnico Nacional.
					</p>
					<p class="lead">
						Físicamente soy un chico de tes blanca, mido 1.70, peso 62 kg, tengo el cabello castaño obscuro, 
						ojos cafés, nariz mediana, labios gruesos y delgado.
					</p>
					<p class="lead">
						En cuanto a mi personalidad me considero una persona divertida, con buen sentido del humor, paciente, 
						empático, con una motivación para superarse día a día y la mentalidad de que siempre se puede aprender
						algo nuevo sin importar la edad. Dentro de las habilidades que estoy tratando de desarrollar está el 
						convencimiento, mejor organización, puntualidad y ser más participativo.
						Actualmente no practico ningún deporte, pero en los fines de semana procuro ir a correr 30 minutos diarios.
					</p>
				</div>
				<div class="col-md-4 text-center">
					
				</div>
			</div>
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
		$(function() {

			Page.init();
			$("body").css("overflow", "visible");
		});
	</script>
</body>
</html>
