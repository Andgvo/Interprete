package utilidades;

public abstract class Tabla {
    abstract public void imprimirFila(Object[] elementoFila);
    abstract public void imprimirEncabezado( Object[] elementoEncabezado);
    abstract public void imprimirTabla(String[] encabezado, String[][]elementos);
}
