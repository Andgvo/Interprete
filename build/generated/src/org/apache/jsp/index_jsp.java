package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import interprete.controlador.Interprete;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"es\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t<title> Compiladores </title>\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"assets/css/bootstrap.css\" media=\"screen\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"navbar navbar-expand-lg fixed-top navbar-dark navbar-transparent bg-primary\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <a href=\"#\" class=\"navbar-brand\">ESCOM</a>\r\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("                </button>\r\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\r\n");
      out.write("                    <ul class=\"navbar-nav\">\r\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link elemento-scroll\" href=\"#seccion1\"> Análisis Léxico y Sintáctico </a></li>\r\n");
      out.write("                        <div id=\"munu-extendido\">\r\n");
      out.write("                            <li class=\"nav-item\"><a class=\"nav-link elemento-scroll\" href=\"#seccion2\"> Algoritmos Análisis Sintáctico </a></li>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                    <ul class=\"nav navbar-nav ml-auto\">\r\n");
      out.write("                        <li class=\"nav-item\">\r\n");
      out.write("                            <a class=\"nav-link elemento-scroll\" href=\"#seccion9\" > Ref. </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"splash\">\r\n");
      out.write("            <div class=\"container splash-body\">\r\n");
      out.write("                <div class=\"col-lg-12\" style=\"color: #FFF !important\">\r\n");
      out.write("                    <!-- <div><img class=\"logo\" src=\"assets/img/logo.png\"></div> -->\r\n");
      out.write("                    <h1 class=\"etiqueta-contenido\"> Instituto Politécnico Nacional </h1>\r\n");
      out.write("                    <h2 class=\"etiqueta-contenido\"> Escuela Superior de Cómputo </h2>\r\n");
      out.write("                    <br><br>\r\n");
      out.write("                    <span class=\"etiqueta-contenido\">COMPILADORES</span>\r\n");
      out.write("                    <br><br>\r\n");
      out.write("                    <span class=\"etiqueta-contenido\"><b> 4CM2 </b></span>\r\n");
      out.write("                    <div id=\"social\"></div>\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-md-6 col-md-offset-3\">\r\n");
      out.write("                            <div class=\"sponsor\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"seccion1\" class=\"seccion seccion-negro fuente-blanco\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <h1 class=\"display-5\">Análisis Léxico y Sintáctico</h1>\r\n");
      out.write("                <p class=\"lead\">\r\n");
      out.write("                    En esta sección podrás ingresar tu gramática y está sera procesada por un Alizador Léxico\r\n");
      out.write("                </p>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-lg-6 col-md-6 col-sm-12\">\r\n");
      out.write("                            <textarea class=\"form-control\" id=\"gramaticaVar\" placeholder=\"Ingresa tu gramática aquí\" rows=\"6\"></textarea>\r\n");
      out.write("                                <br>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-6 col-md-6 col-sm-12\">\r\n");
      out.write("                            <input type=\"button\" id=\"enviarGramatica\" class=\"btn btn-info btn-bg\" value=\"Analizar Gramática\" /> \r\n");
      out.write("                            <br>\r\n");
      out.write("                            <div class=\"span2 fuente-negro\" id=\"error\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\t\r\n");
      out.write("        <div class=\"fuente-negro\" id=\"reglas\">\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("\t<div id=\"seccion2\" class=\"seccion seccion-royal seccion-sombra fuente-blanco\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("                        <h1 class=\"display-5\">Algoritmos de Análisis Sintáctico</h1>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <p class=\"lead\"></p>\r\n");
      out.write("                            <div class=\"col-sm-12 col-md-6 col-lg-6\">\r\n");
      out.write("                                <div class=\"input-group mb-3\">\r\n");
      out.write("                                    <div class=\"input-group-prepend\">\r\n");
      out.write("                                      <label class=\"input-group-text\" for=\"inputGroupSelect01\">Elige algún algoritmo</label>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <select class=\"custom-select\" id=\"algoritmoVar\">\r\n");
      out.write("                                        <option selected value=\"1\">LL1</option>\r\n");
      out.write("                                        <option value=\"2\">LR0</option>\r\n");
      out.write("                                        <option value=\"3\">LR1</option>\r\n");
      out.write("                                    </select>\r\n");
      out.write("                                    <div class=\"input-group-append\">\r\n");
      out.write("                                        <button class=\"btn btn-success\" id=\"btn_realizarAlgoritmo\" type=\"button\">Calcular</button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div id=\"divAlgoritmo\">\r\n");
      out.write("                            \r\n");
      out.write("                        </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("    \r\n");
      out.write("\t<footer class=\"footer seccion-negro fuente-blanco\">\r\n");
      out.write("\t    <div class=\"footer-copyright py-1 text-center\">\r\n");
      out.write("\t    \t<p>Pagina creada el 06-05-18 por Gusatvo Andrés López Sánchez</p>\r\n");
      out.write("\t        <!--© 2018 Copyright:\r\n");
      out.write("\t        <a href=\"#\"> www.ipn.mx </a>\r\n");
      out.write("\t    \t-->\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t</footer>\r\n");
      out.write("\t<script src=\"assets/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/index.js\"></script>\r\n");
      out.write("            \r\n");
      out.write("\t<script>\r\n");
      out.write("            $(document).ready(function() {\r\n");
      out.write("                    $('#enviarGramatica').click(function(event) {\r\n");
      out.write("                            var gramaticaVar = $('#gramaticaVar').val();\r\n");
      out.write("                            \r\n");
      out.write("                            // Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get\r\n");
      out.write("                            $.post('Interprete', {\r\n");
      out.write("                                    gramatica : gramaticaVar\r\n");
      out.write("                            }, function(responseText) {\r\n");
      out.write("                                    var error = responseText.includes(\"ERROR\");\r\n");
      out.write("                                    if(!error){\r\n");
      out.write("                                        $('#reglas').html(responseText);\r\n");
      out.write("                                    }else{\r\n");
      out.write("                                        $('#error').html(responseText);\r\n");
      out.write("                                    }\r\n");
      out.write("                            });\r\n");
      out.write("                    });\r\n");
      out.write("                    \r\n");
      out.write("                    $('#btn_realizarAlgoritmo').click(function(event) {\r\n");
      out.write("                            var opcionAlgoritmo = $('#algoritmoVar').val();\r\n");
      out.write("                            \r\n");
      out.write("                            // Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get\r\n");
      out.write("                            $.post('AnalizadoresSintacticos', {\r\n");
      out.write("                                    opcion : opcionAlgoritmo\r\n");
      out.write("                            }, function(responseText) {\r\n");
      out.write("                                    var error = responseText.includes(\"ERROR\");\r\n");
      out.write("                                    if(!error){\r\n");
      out.write("                                        $('#reglas').html(responseText);\r\n");
      out.write("                                    }else{\r\n");
      out.write("                                        $('#error').html(responseText);\r\n");
      out.write("                                    }\r\n");
      out.write("                            });\r\n");
      out.write("                    });\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
