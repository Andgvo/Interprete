package interprete.gramaticaDeGramaticas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Gramatica contiene un conjunto de reglas con Simbolos Terminales y Simbolos No Terminales
 * @author Andres
 */
public class Gramatica {
    public static final Regla POP = new Regla();
    public static final Regla ACEPT = new Regla();
    public static final Simbolo EPSILON = new Simbolo("\\e");
    public static final SimboloEspecial RAIZ = new SimboloEspecial("$",ACEPT);
    
    public static int contadorReglas;
    private ArrayList<Regla> listaReglas;
    private ArrayList<SimboloNoTerminal> simbolos;
    
    public Gramatica(){
        listaReglas = new ArrayList<>();
        simbolos = new ArrayList<>();
    }
    
    public void agregarRegla(Regla regla){
        regla.setNumeroRegla(contadorReglas++);
        listaReglas.add(regla);
    }
    
    public void agregarSimbolo(SimboloNoTerminal simbolo){
        simbolos.add(simbolo);
    }
    
    public int comprobarSimbolo(Simbolo simboloComporbar){
        for(int i = 0; i < simbolos.size();i++){
            if(simbolos.get(i).equals(simboloComporbar))
                return i;
        }
        return -1;
    }
    
    public List<SimboloNoTerminal> buscarSimbTerminales(){
        Predicate<SimboloNoTerminal> snt = simb -> simb.isTerminal();
        return simbolos.stream().filter(snt).collect(Collectors.toList());
    }
    
    public List<SimboloNoTerminal> buscarSimbNoTerminales(){
        Predicate<SimboloNoTerminal> snt = simb -> !simb.isTerminal();
        return simbolos.stream().filter(snt).collect(Collectors.toList());
    }
    
    public void imprimirSimbolos(){
        for(SimboloNoTerminal simbolo: simbolos){
            System.out.println(simbolo.getExpresion()+"\tTerminal="+simbolo.isTerminal());

        }
    }
    
    public void imprimirReglas(){
        for(Regla regla: listaReglas){
            System.out.println(regla+ "\t\t"+ regla.getNumeroRegla());
        }
    }
    
    // ********************* GET ****************************************
    public SimboloNoTerminal getSimbolo(int index){
        return simbolos.get(index);
    }
    
    public int getNumeroSimbolos(){
        return simbolos.size();
    }
    
    public ArrayList<SimboloNoTerminal> getSimbolos(){
        return simbolos;
    }
    
    public ArrayList<Regla> getListaReglas(){
        return listaReglas;
    }
}