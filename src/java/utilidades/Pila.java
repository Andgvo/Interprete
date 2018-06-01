package utilidades;

import java.util.List;
import java.util.Stack;

/**
 * Esta clase es un extends de Stack, por cuestiones de estética el metodo
 * toString fue sobreescrito para mostrar de mejor forma los elementos.
 * @author Andres
 * @param <T> Object
 */
public class Pila<T> extends Stack{
    
    public static Pila invertirPila(List simbolos){
        Pila pilaInvertida = new Pila();
        for (int i = simbolos.size()-1; i != -1 ; i--) {
            pilaInvertida.add(simbolos.get(i));
        }
        return pilaInvertida;
    }
    
    @Override
    public String toString(){
        String resultado = super.toString();
        return resultado.replace(",","").replace("[","").replace("]", "");
    }
}
