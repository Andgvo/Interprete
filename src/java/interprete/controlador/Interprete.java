package interprete.controlador;

import interprete.gramaticaDeGramaticas.Gramatica;
import interprete.gramaticaDeGramaticas.GramaticaDeGramaticas;
import interprete.gramaticaDeGramaticas.Regla;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Interprete extends HttpServlet {
    HttpSession misession ;
    
    private void generarSeccionReglas(Gramatica gramatica, PrintWriter out){
        out.println(
        "<div id='seccion1' class='seccion-negro' style='padding-bottom:1rem'>\n" +
"           <div class='container'>"
                + "<h2 class='fuente-blanco'> Reglas </h2>"
                +" <div class='row'>"
                +"<div class='bs-component col-sm-12 col-md-6 col-bg-4'>"
                    + "<ul class='list-group'> ");
                        int mitadIzquierda = gramatica.getListaReglas().size()/2 + gramatica.getListaReglas().size()%2;
                        for(int i = 0; i < mitadIzquierda ; i++){
                        //for(Regla regla : gramatica.getListaReglas()){
                        out.println("  <li class='list-group-item d-flex justify-content-between align-items-center'>"
                        +  gramatica.getListaReglas().get(i) +"<span class='badge badge-primary badge-pill'>"+i+"</span>"
                        + "</li>");
                        }
                    out.println("</ul>  "
                +"</div>  "
                 
                +"<div class='bs-component col-sm-12 col-md-6 col-bg-4'>"
                    + "<ul class='list-group'> ");
                        int mitadDerecha = gramatica.getListaReglas().size();
                        for(int i = mitadIzquierda ; i < mitadDerecha ; i++){
                        out.println("  <li class='list-group-item d-flex justify-content-between align-items-center'>"
                        +  gramatica.getListaReglas().get(i) +"<span class='badge badge-primary badge-pill'>"+i+"</span>"
                        + "</li>");
                        }
                    out.println("</ul>"
                +"</div>  "
                            
                +"</div>"     
            +"</div>"
        +"</div>"); 
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Gramatica gramatica = new Gramatica();
        misession= request.getSession(true);
        misession.setAttribute("gramatica",gramatica);
        
        //Limpiado de cadena de entrada
        GramaticaDeGramaticas gramaticaDG = new GramaticaDeGramaticas(gramatica);
        String cadena = request.getParameter("gramatica");
        cadena = cadena.replace("\n","").replace("\t","");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Analisis Léxico y Sintáctico
            boolean pasoLexico = gramaticaDG.analisisLexico(cadena);
            if(pasoLexico){
                boolean pasoSintactico = gramaticaDG.analisisSintactico(cadena, gramatica);
                if(pasoSintactico){
                    generarSeccionReglas(gramatica, out);
                }else{
                    out.println("<div class='card text-white bg-danger mb-3' style='max-width: 20rem;'>  ");
                    out.println(" <div class='card-header'></div> ");
                    out.println(" <div class='card-body'> ");
                    out.println("   <h4 class='card-title'>ERROR SINTÁCTICO</h4>");
                    out.println("  <p class='card-text'>Some quick example text to build on the card title and make</p>");
                    out.println("  </div>");
                    out.println("</div>");
                }
            }else{
                    out.println("<div class='card text-white bg-danger mb-3' style='max-width: 20rem;'>  ");
                    out.println(" <div class='card-header'></div> ");
                    out.println(" <div class='card-body'> ");
                    out.println("   <h4 class='card-title'>ERROR LÉXICO</h4>");
                    out.println("  <p class='card-text'>"+ gramaticaDG.getErrorLexico()+"</p>");
                    out.println("  </div>");
                    out.println("</div>");
            }
        }  
    }

    String seccion = ""+
"   <div id='seccion2' class='seccion seccion-royal seccion-sombra fuente-blanco'>\n" +
"	<div class='container'>\n" +
"           <h1 class='display-5'>Algoritmos Análisis Sintáctico</h1>\n" +
"		<p class='lead'>\n" +
"		asd\n" +
"		</p>\n" +
"       </div>\n" +
"   </div>";
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
