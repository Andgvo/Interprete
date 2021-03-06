package interprete.gramaticaDeGramaticas;

import java.util.ArrayList;

public class Regla {
    private int numeroRegla;
    private SimboloNoTerminal ladoIzquierdo;
    private ArrayList<SimboloNoTerminal> listaLadosDerechos;
    
    public Regla(int numeroRegla, SimboloNoTerminal ladoIzquierdo, ArrayList<SimboloNoTerminal> listaLadosDerechos){
        this.listaLadosDerechos = listaLadosDerechos;
        this.ladoIzquierdo = ladoIzquierdo;
        this.numeroRegla = numeroRegla;
    }
    
    public Regla(SimboloNoTerminal ladoIzquierdo, int numeroRegla){
        listaLadosDerechos = new ArrayList<>();
        this.ladoIzquierdo = ladoIzquierdo;
        this.numeroRegla = numeroRegla;
    }
    
    public Regla(){
        listaLadosDerechos = new ArrayList<>();
    }
    
    public void agregarSimbolo(SimboloNoTerminal simbolo){
        listaLadosDerechos.add(simbolo);
    }
    
    public int comprobarSimbolo(Simbolo simboloComporbar){
        for(int i = 0; i < listaLadosDerechos.size();i++){
            if(listaLadosDerechos.get(i).equals(simboloComporbar))
                return i;
        }
        return -1;
    }
    
    public String imprimirSimbolos(){
        String cadenaAux="";
        cadenaAux = listaLadosDerechos.stream().map((simbolo) -> simbolo.getExpresion()+" ").reduce(cadenaAux, String::concat);
        return cadenaAux;
    }
    
    // *************** GET *****************************
    public SimboloNoTerminal getSimbolo(int indice){
        return listaLadosDerechos.get(indice);
    }
    
    public int getNumeroRegla(){
        return numeroRegla;
    }
    
    public SimboloNoTerminal getLadoIzquierdo(){
        return ladoIzquierdo;
    }
    
    public ArrayList<SimboloNoTerminal> getListaLadosDerechos(){
        return listaLadosDerechos;
    }

    //**************** SET ******************************
    public void setNumeroRegla(int numeroRegla) {
        this.numeroRegla = numeroRegla;
    }

    public void setLadoIzquierdo(SimboloNoTerminal ladoIzquierdo) {
        this.ladoIzquierdo = ladoIzquierdo;
    }

    public void setListaLadosDerechos(ArrayList<SimboloNoTerminal> listaLadosDerechos) {
        this.listaLadosDerechos = listaLadosDerechos;
    }
    
    @Override
    public String toString(){
        String cadenaAux="";
        cadenaAux=ladoIzquierdo.getExpresion()+" -> ";
        for(Simbolo simbolo: listaLadosDerechos){
            cadenaAux += simbolo.getExpresion()+" ";
        }
        return cadenaAux;
    }
    
}