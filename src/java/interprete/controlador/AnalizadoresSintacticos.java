package interprete.controlador;

import interprete.gramaticaDeGramaticas.Gramatica;
import interprete.ll1.AlgoritmoLL1;
import interprete.lr0.AlgoritmoLR0;
import interprete.lr1.LR1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andres
 */
public class AnalizadoresSintacticos extends HttpServlet {
    
    String opcionPrevia = "0";
    AlgoritmoLL1 ll1;
    AlgoritmoLR0 lr0;
    LR1 lr1;
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
        response.setContentType("text/html;charset=UTF-8");
        
        String opcion = request.getParameter("opcion");
        String cadena = request.getParameter("cadena");
        
        HttpSession miSession= (HttpSession) request.getSession();
        Gramatica gramatica= (Gramatica) miSession.getAttribute("gramatica");
        
        try (PrintWriter out = response.getWriter()){
            if( !opcionPrevia.equals(opcion) ){
                out.println("<opcion1>");
                switch(opcion){
                    case "1":
                        out.println("<h4> Algoritmo LL1 </h4>");
                        ll1 = new AlgoritmoLL1(gramatica);
                        ll1.calcularFollow(out);
                        ll1.calcularFirstReglas(out);
                        ll1.generarTablaLL1(out);
                        break;
                    case "2":
                        out.println("<h4> Algoritmo LR0 </h4>");
                        lr0 = new AlgoritmoLR0(gramatica);
                        lr0.obtenerS1();
                        lr0.calcularEstados(out);
                        lr0.calcularFollow();
                        lr0.calcularReducciones();
                        lr0.generarTabla(out);
                        break;
                    case "3":
                        out.println("<h4> Algoritmo LR1 </h4>");
                        lr1 = new LR1(gramatica);
                        lr1.inicializarLR1();
                        lr1.imprimirEstados(out);
                        lr1.imprimirTablaLR1(out);
                        break;
                }
                opcionPrevia = opcion;
            }else{
                out.println("<opcion2>");
                switch(opcion){
                    case "1":
                        if (ll1.validarCadena(cadena, out) )
                            out.print("Cadena Aceptada");
                        else
                            out.print("ERROR");
                        break;
                    case "2":
                        lr0.generarTabla(out);
                        break;
                    case "3":
                        lr1.imprimirTablaLR1(out);
                        break;
                }
            }
        }
    }

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
