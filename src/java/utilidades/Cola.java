package utilidades;

import java.util.LinkedList;

/**
 * Esta clase es un extends de LinkedList, por cuestiones de estética el metodo
 * toString fue sobreescrito para mostrar de mejor forma los elementos.
 * @author Andres
 * @param <T> Object
 */
public class Cola<T> extends LinkedList{
    @Override
    public String toString(){
        String resultado = super.toString();
        return resultado.replace(",","").replace("[","").replace("]", "");
    }
}
