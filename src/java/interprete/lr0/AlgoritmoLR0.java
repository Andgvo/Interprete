package interprete.lr0;

import interprete.gramaticaDeGramaticas.Gramatica;
import interprete.gramaticaDeGramaticas.Regla;
import interprete.gramaticaDeGramaticas.SimboloNoTerminal;
import interprete.ll1.Follow;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AlgoritmoLR0 {
    static int contadorEstado = 0;
    
    private final Gramatica gramatica;
    private final List<Estado> estados;
    private Estado s0;
    private List<SimboloNoTerminal> simbolosTerminales;
    private List<SimboloNoTerminal> simbolosNoTerminales;
    private HashMap<SimboloNoTerminal, Follow> simboloFollowPrevio;
    
    public AlgoritmoLR0(Gramatica gramatica){
        contadorEstado = 0;
        estados = new ArrayList<>();
        this.gramatica = gramatica;
        simboloFollowPrevio = new HashMap<>();
    }
    
    public void obtenerS1(){
        Nodo nodo0 = new Nodo(gramatica.getListaReglas().get(0), 0);
        Estado s0 = new Estado(contadorEstado++);
        Estado.cerradura(nodo0, s0);
        this.s0 = s0;
    }
    
    public void actualizarSimbolos(){
        
    }
    
    public void calcularEstados(PrintWriter out){
        Estado estadoActual;
        LinkedList<Estado> cola = new LinkedList<>();
        cola.add( s0 );
        estados.add(s0);
        while( ! cola.isEmpty() ){
            estadoActual = cola.remove();
            //out.println("<br>");
            //out.println("s"+ estadoActual.getIdEstado() +"<br>");
            for(SimboloNoTerminal simbolo : estadoActual.getSimbolosBeta()){
                if(!simbolo.equals(Estado.FINAL)){
                    //out.print(" irA(s"+estadoActual.getIdEstado()+","+simbolo+") = ");
                    Estado nuevoEstado = new Estado( contadorEstado,
                            Estado.cerradura( Estado.irA(estadoActual, simbolo) ));
                    //Estado.buscarEstado(nuevoEstado, estados);
                    Estado edoAux = Estado.buscarEstado(nuevoEstado, estados);
                    if( edoAux == null ){
                        estados.add(nuevoEstado);
                        cola.add(nuevoEstado);
                        //out.println("***nuevoEstado S"+ nuevoEstado.getIdEstado() +" == "+nuevoEstado);
                        estadoActual.crearRelacion(simbolo, nuevoEstado);
                        contadorEstado++;
                    }else{
                        //out.println(" S"+edoAux.getIdEstado());
                        estadoActual.crearRelacion(simbolo, edoAux);
                    }
                    //out.print("<br>");
                }
            }
            //out.print("<br>");
        }
        simbolosTerminales = gramatica.buscarSimbTerminales();
        simbolosTerminales.add(Gramatica.RAIZ);
        simbolosNoTerminales = gramatica.buscarSimbNoTerminales();
    }
    
    public void calcularReducciones(){
        //Predicate<Nodo> filtroNodoTerminal = nodo -> (nodo instanceof NodoTerminal) ;
        for(Estado estado: estados){
            //estado.stream().filter(filtroNodoTerminal).forEach(n-> System.out.println("S"+estado.getIdEstado()+" = "+n));
            for(Nodo nodo : estado){
                if(nodo instanceof NodoTerminal){
                    Follow followAux = simboloFollowPrevio.get(nodo.getRegla().getLadoIzquierdo());
                    for(SimboloNoTerminal simbolo : followAux.getSimbolos()){
                        estado.crearRelacion(simbolo, nodo.getRegla());
                    }
                }
            }
        }
    }
    
    public void calcularFollow(){
        for (int i = 0; i < gramatica.getNumeroSimbolos() ; i++) {
            if(!gramatica.getSimbolo(i).isTerminal()){
                Follow follow = new  Follow( gramatica.getSimbolo(i), gramatica.getListaReglas() );
                simboloFollowPrevio.put(gramatica.getSimbolo(i), follow);
            }
        }
    }
    
    public void generarTabla( PrintWriter out ){
        //estados.stream().forEach( edo -> out.println("s"+edo.getIdEstado() + " = " +edo));
        for( Estado edo : estados )
            out.println("s"+edo.getIdEstado() + " = " +edo+"<br>");
        
        StringBuilder columnasElementos = new StringBuilder();        
        columnasElementos.append("<div class='table-responsive'>");
        columnasElementos.append("<table class='table table-sm table-dark table-hover'>");
        columnasElementos.append("<thead><tr>");
        columnasElementos.append("<th scope='col'>");
        columnasElementos.append("Estado");
        columnasElementos.append("</th>");
            
        for(SimboloNoTerminal simboloColumna : simbolosTerminales ){
            columnasElementos.append("<th scope='col'>");
            columnasElementos.append(simboloColumna.toString());
            columnasElementos.append("</th>");
        }
        for(SimboloNoTerminal simboloColumna : simbolosNoTerminales ){
            columnasElementos.append("<th scope='col'>");
            columnasElementos.append(simboloColumna.toString());
            columnasElementos.append("</th>");
        }
        columnasElementos.append("</tr>");
        columnasElementos.append("</thead>");
        
        columnasElementos.append("<tbody>");
        for(Estado estado: estados){
            columnasElementos.append("<tr>");
            columnasElementos.append("<th scope='row'>");
            columnasElementos.append("S"+estado.getIdEstado());
            columnasElementos.append("</th>");
            
            
            for(SimboloNoTerminal simbolo: simbolosTerminales){
                columnasElementos.append("<th>");
                Estado edoAux = estado.getDesplazamiento(simbolo);
                if(edoAux != null){
                    columnasElementos.append("d"+edoAux.getIdEstado());
                }else{
                    Regla regla = estado.getReduccion(simbolo);
                    if(regla != null)
                        columnasElementos.append("r"+regla.getNumeroRegla());
                    else
                        columnasElementos.append("-");
                }
                columnasElementos.append("</th>");
            }
            
            for(SimboloNoTerminal simbolo: simbolosNoTerminales){
                Estado edoAux = estado.getDesplazamiento(simbolo);
                columnasElementos.append("<th>");
                if(edoAux != null)
                    columnasElementos.append(edoAux.getIdEstado());
                else
                    columnasElementos.append("-");
                columnasElementos.append("</th>");
            }
            
            columnasElementos.append("</tr>");
        }
        out.print( columnasElementos );
    }
    
}
