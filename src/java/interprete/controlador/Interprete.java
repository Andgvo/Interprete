package interprete.controlador;

import interprete.gramaticaDeGramaticas.Gramatica;
import interprete.gramaticaDeGramaticas.GramaticaDeGramaticas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interprete extends HttpServlet {
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
        GramaticaDeGramaticas gramaticaDG = new GramaticaDeGramaticas(gramatica);
        String cadena = request.getParameter("gramatica");
        cadena= cadena.replace("\n","").replace("\t","");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Analisis Léxico y Sintáctico
            boolean pasoLexico = gramaticaDG.analisisLexico(cadena);
            if(pasoLexico){
                boolean pasoSintactico = gramaticaDG.analisisSintactico(cadena, gramatica);
                if(pasoSintactico){
                    out.println("<div class='bs-component'>");
                    out.println("  <ul class='list-group'> ");
                    for(int i=0; i<gramatica.getListaReglas().size(); i++){
                        out.println("    <li class='list-group-item d-flex justify-content-between align-items-center'>");
                        out.println(gramatica.getListaReglas().get(i));
                        out.println("  <span class='badge badge-primary badge-pill'>"+i+"</span>");
                        out.println("  </li>");
                    }
                    out.println("  </ul>  ");
                    out.println("  <div id='source-button' class='btn btn-primary btn-xs' style='display: none;'>&lt; &gt;</div>");
                    out.println("</div>  ");                   
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
