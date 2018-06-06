package interprete.lr1;

import interprete.gramaticaDeGramaticas.Gramatica;
import interprete.gramaticaDeGramaticas.GramaticaDeGramaticas;

public class GramaticaLR1 extends GramaticaDeGramaticas{
    private LR1 lr;
    
    public GramaticaLR1(Gramatica gramatica) {
        super(gramatica);
    }
    
    public void algoritmoLR1(Gramatica gramatica){
        System.out.println("************* REGLAS ***************");
        gramatica.imprimirReglas();
        System.out.println("************* SIMBOLOS *************");
        gramatica.imprimirSimbolos();
        lr = new LR1(gramatica);
        System.out.println(lr);
    }
    
    public boolean analizarCadenaLR1(String expresion){
        if(lr != null)
            return lr.evaluarExpresion(expresion);
        else 
            return false;
    }
}