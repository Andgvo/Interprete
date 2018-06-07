package interprete.ll1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import utilidades.TablaColumnaUnitaria;
import utilidades.Cola;
import utilidades.Pila;
import interprete.gramaticaDeGramaticas.Gramatica;
import interprete.gramaticaDeGramaticas.Regla;
import interprete.gramaticaDeGramaticas.SimboloNoTerminal;
import interprete.gramaticaDeGramaticas.Simbolo;
import java.io.PrintWriter;

public class AlgoritmoLL1 {
    private ArrayList<SimboloNoTerminal> simbolosTerminales;
    private ArrayList<SimboloNoTerminal> simbolosNoTerminales;
    private HashMap<SimboloNoTerminal, Follow> simboloFollowPrevio;
    private Gramatica gramatica;
    
    public AlgoritmoLL1(Gramatica gramatica){
        this.gramatica = gramatica;
        //gramatica.agregarSimbolo(Gramatica.RAIZ);
        simboloFollowPrevio = new HashMap<>();
        simbolosTerminales = new ArrayList<>();
        simbolosNoTerminales = new ArrayList<>();
    }
        
    public void calcularFirstReglas( PrintWriter out ){
        out.print("<p class='text-right'><button class='btn btn-info btn-sm' type='button' data-toggle='collapse' data-target='#pasos' aria-expanded='false' aria-controls='collapseExample'>\n" +
                "    Explicación extendida\n" +
                "</button></p>" +
                "<div class='collapse' id='pasos'>\n" +
                "  <div class='card card-body'>");
        out.print("<p class='lead'>");
        for (int i = 0; i < Gramatica.contadorReglas ; i++) {
            Regla regla = gramatica.getListaReglas().get(i);
            SimboloNoTerminal simboloInicial = regla.getListaLadosDerechos().get(0);
            First first = new  First( regla );
            out.print("Regla "+i+" : "+regla+"<br>");
            out.print("first( "+ simboloInicial +" ) = "+first.getSimbolos());
            if(AlgoritmoLL1.containsEpsilon(first.getSimbolos())){
                //System.out.print(" = "+ first.getSimbolos());
                Follow followAux = simboloFollowPrevio.get( simboloInicial );
                if( followAux != null){
                    ArrayList<SimboloNoTerminal> simbolosFollow = new ArrayList<>(followAux.getSimbolos());
                    first.getSimbolos().addAll(simbolosFollow);
                    out.print(" U {follow( "+ simboloInicial +" ) = "+ simbolosFollow +" } = "+first.getSimbolos());
                }else{
                    followAux = simboloFollowPrevio.get( regla.getLadoIzquierdo() );
                    ArrayList<SimboloNoTerminal> simbolosFollow = new ArrayList<>(followAux.getSimbolos());
                    first.getSimbolos().addAll(simbolosFollow);
                    out.print(" -> follow( "+ regla.getLadoIzquierdo() +" ) = "+first.getSimbolos());
                }
            }
            if( ! simbolosNoTerminales.contains( regla.getLadoIzquierdo() ))
                simbolosNoTerminales.add( regla.getLadoIzquierdo() );
            crearRelacionesSimbolosNT(first.getSimbolos(), regla);
            out.print("<br><br>");
        }
        out.print("</p>");
        out.print("</div></div><br>");
        actualizarSimbolosTerminales();
        AlgoritmoLL1.containsEpsilon(simbolosTerminales);
        simbolosTerminales.add(Gramatica.RAIZ);
    }
    
    private void crearRelacionesSimbolosNT(ArrayList<SimboloNoTerminal> simbolos ,Regla regla){
        for(SimboloNoTerminal nuevaRelacion : simbolos ){
            regla.getLadoIzquierdo().agregarRelacion(nuevaRelacion, regla );
        }
    }
    
    private void crearRelacionesSimbolosT(SimboloNoTerminal simbolo){
        simbolo.agregarRelacion(simbolo, Gramatica.POP);
    }
    
    public void actualizarSimbolosTerminales(){
        for (SimboloNoTerminal simbolo : gramatica.getSimbolos()) {
            if( ! simbolosTerminales.contains( simbolo )){
                if( simbolo.isTerminal() ){
                    simbolosTerminales.add( simbolo );
                    crearRelacionesSimbolosT( simbolo );
                }
            }
        }
    }
    
    public ArrayList<SimboloNoTerminal> calcularFirstSNT(){
        ArrayList<SimboloNoTerminal> simbolosR = null;
        for (int i = 0; i < gramatica.getNumeroSimbolos() ; i++) {
            if(!gramatica.getSimbolo(i).isTerminal()){
                simbolosR = First.first( gramatica.getSimbolo(i) );
                System.out.print("first( "+ gramatica.getSimbolo(i) +" ) = ");
                System.out.println( simbolosR);
            }
        }
        return simbolosR;
    }
    
    public void calcularFollow( PrintWriter out ){
        for (int i = 0; i < gramatica.getNumeroSimbolos() ; i++) {
            if(!gramatica.getSimbolo(i).isTerminal()){
                Follow follow = new  Follow( gramatica.getSimbolo(i), gramatica.getListaReglas() );
                simboloFollowPrevio.put(gramatica.getSimbolo(i), follow);
                //out.println("follow ("+gramatica.getSimbolo(i)+") = "+follow.getSimbolos() + "<br>");
            }
        }
    }
    
    public boolean validarCadena(String cadena, PrintWriter out){
        Pila pila = new Pila();
        pila.add(Gramatica.RAIZ);
        pila.add(simbolosNoTerminales.get(0));
        Cola simbolosCadena = convertirElementos(cadena);
        
        //Encabezado
        StringBuilder columnasElementos = new StringBuilder();
        columnasElementos.append("<tablaCadena>");
        columnasElementos.append("<div class='table-responsive'>");
        columnasElementos.append("<table class='table table-sm table-dark table-hover'>");
        columnasElementos.append("<thead><tr>");
        columnasElementos.append("<th scope='col'>Cola</th>");
        columnasElementos.append("<th scope='col'>Cadena</th>");
        columnasElementos.append("<th scope='col'>Acción</th>");
        columnasElementos.append("</th>");
        columnasElementos.append("</tr>");
        columnasElementos.append("</thead>");
        
        out.print(columnasElementos);
        //tabla.imprimirEncabezado(elementoEncabezado);
        columnasElementos.append("<tbody>");
        for(;;){
            out.print("<tr>");
            ArrayList<String> filaElementos = new ArrayList<>();
            out.print("<th>"+ pila.toString()+"</th>");
            out.print("<th>"+ simbolosCadena.toString() +"</th>");
            SimboloNoTerminal simboloFinalPila = (SimboloNoTerminal) pila.pop();
            Regla relacion = simboloFinalPila.getRelacion().get( simbolosCadena.getFirst() );
            if(relacion != null){
                if( relacion.equals( Gramatica.POP ) ){
                    out.print("<th>POP</th></tr>");
                    simbolosCadena.remove();
                }else if( relacion.equals( Gramatica.ACEPT ) ){
                    out.print("<th>Aceptada</th></tr>");
                    //tabla.imprimirFila(filaElementos.toArray());
                    return true;
                }
                else{
                    out.print("<th>"+relacion.getListaLadosDerechos()+","+relacion.getNumeroRegla()+"</th></tr>");
                    if( ! relacion.getListaLadosDerechos().get(0).equals(Gramatica.EPSILON ) )
                        pila.addAll(Pila.invertirPila(relacion.getListaLadosDerechos()) );                           
                }
                
            }else{
                out.print("<th>ERROR</th></tr>");
                //tabla.imprimirFila(filaElementos.toArray());
                return false;
            }
        }
    }
    
    public Cola convertirElementos(String cadena){
        String[] arrayElementos = cadena.split(" ");
        Cola elementoCola = new Cola();
        for(String arrayElemento: arrayElementos){
            SimboloNoTerminal simbolo = contieneSimboloGramatica(new SimboloNoTerminal(arrayElemento));
            elementoCola.add(simbolo);
        }       
        return elementoCola;
    }
    
    public SimboloNoTerminal contieneSimboloGramatica(SimboloNoTerminal simbolo){
        for (SimboloNoTerminal simboloGramatica : gramatica.getSimbolos()) {
            if(simboloGramatica.equals(simbolo)){
                return simboloGramatica;
            }
            else if(Gramatica.RAIZ.equals(simbolo))
                return Gramatica.RAIZ;
        }
        return simbolo;
    }
    
    public static boolean containsEpsilon(HashSet<SimboloNoTerminal> conjuntoSimbolos){
        for(Simbolo simbolo : conjuntoSimbolos){
            if(Gramatica.EPSILON.equals(simbolo)){
                conjuntoSimbolos.remove(simbolo);
                return true;
            }
        }
        return false;
    }
    
    public static boolean containsEpsilon(ArrayList<SimboloNoTerminal> conjuntoSimbolos){
        for(Simbolo simbolo : conjuntoSimbolos){
            if(Gramatica.EPSILON.equals(simbolo)){
                conjuntoSimbolos.remove(simbolo);
                return true;
            }
        }
        return false;
    }
    
    public void generarTablaLL1( PrintWriter out ){
        //Encabezado 
        StringBuilder columnasElementos = new StringBuilder();
        columnasElementos.append("<div class='table-responsive'>");
        columnasElementos.append("<table class='table table-sm table-dark table-hover'>");
        columnasElementos.append("<thead><tr>");
        columnasElementos.append("<th scope='col'>");
        columnasElementos.append("Simb");
        columnasElementos.append("</th>");
            
        for(SimboloNoTerminal simboloColumna : simbolosTerminales ){
            columnasElementos.append("<th scope='col'>");
            columnasElementos.append(simboloColumna.toString());
            columnasElementos.append("</th>");
        }
        columnasElementos.append("</tr>");
        columnasElementos.append("</thead>");
        
        
        //Elementos por filas
        columnasElementos.append("<tbody>");
        for(SimboloNoTerminal simboloFila : simbolosNoTerminales ){
            columnasElementos.append("<tr>");
            columnasElementos.append("<th scope='row'>");
            columnasElementos.append(simboloFila.toString());
            columnasElementos.append("</th>");
            for(SimboloNoTerminal simboloColumna : simbolosTerminales ){
                columnasElementos.append("<th>");
                Regla relacion = simboloFila.getRelacion().get(simboloColumna);
                if(relacion==null)
                    columnasElementos.append("---");
                else
                    columnasElementos.append(relacion.getListaLadosDerechos()+","+relacion.getNumeroRegla());
                columnasElementos.append("</th>");
            }
            columnasElementos.append("</tr>");
        }
        columnasElementos.append("</tbody>");
        columnasElementos.append("</table>");
        columnasElementos.append("</div>");
        out.print(columnasElementos);
    }
}