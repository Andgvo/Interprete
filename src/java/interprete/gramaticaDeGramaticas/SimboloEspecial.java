package interprete.gramaticaDeGramaticas;

public class SimboloEspecial extends SimboloNoTerminal{
    public SimboloEspecial(String expresion, Regla regla) {
        super(expresion);
        this.agregarRelacion(this, regla);
    }
}