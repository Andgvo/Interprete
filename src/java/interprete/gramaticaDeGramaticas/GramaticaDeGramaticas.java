package interprete.gramaticaDeGramaticas;

import interprete.analizadores.AnalizadorLexico;
import interprete.automatas.AFD;
import interprete.automatas.AFNs;
import interprete.automatas.Estado;

public class GramaticaDeGramaticas {
    private AFD afd;
    private final AnalizadorSintactico as;
    private String errorLexico = "";
    private String errorSintactico = "";
    
    public GramaticaDeGramaticas(Gramatica gramatica) {
        Estado.reiniciarContadorEstado();
        AFNs afns = new AFNs();
        afns.crearAFN(';'); //0
        afns.crearAFN('|'); //1
        afnFlecha(afns);    //2
        afnSIMB(afns);      //3       
        afnEPSILON(afns);   //4
        afd = new AFD(afns);
        //Asignación de los Tokens
        TokensGramatica.PC     = afns.getTokenAFN(0);
        TokensGramatica.OR     = afns.getTokenAFN(1);
        TokensGramatica.FLECHA = afns.getTokenAFN(2);
        TokensGramatica.SIMB   = afns.getTokenAFN(3);
        TokensGramatica.EPSILON   = afns.getTokenAFN(4);
        //TokensGramatica.TokenInfo();
        //afd.imprimirTablaTransiciones();
        as = new AnalizadorSintactico(afd);
    }
    
    public boolean analisisLexico(String expresion){
        AnalizadorLexico analizadorLexico = new AnalizadorLexico(expresion, afd);
        int token;
        while((token = analizadorLexico.obtenerToken()) != 0){
            if(token == -1){
                errorLexico = analizadorLexico.getError();
                return false;
            }
            //System.out.println("Token = " + token + ", Lexema : " + analizadorLexico.getLexema());
        }
        return true;
    }
    
    public boolean analisisSintactico(String expresion, Gramatica gramatica){
        return as.AnalizarCadena(expresion, gramatica);
    }
    
    
    public String getErrorLexico(){
        return errorLexico;
    }
    
     public String getErrorSintactico(){
        return errorSintactico;
    }
    /***************************************************************************
    /***************    SIMBOLOS ESPECIALES   ****************************/
    
    private static void afnSIMB(AFNs afns){
        afns.crearAFN((char)33,(char)58);  //3
        afns.crearAFN((char)63,(char)123); //4
        afns.crearAFN((char)125); //5
        afns.union(4, 5);
        afns.union(3, 4);      // 3,  ->
        afns.cerraduraSuma(3); // 3, (a-zA-z1-9)+
        afns.crearAFN('\'');   // 4, '
        afns.cerraduraAsterisco(4);//4, (')*
        afns.concatenar(3, 4); // 3, (a-zA-z1-9)+&(')*
    }

    private static void afnFlecha(AFNs afns){
        afns.crearAFN('-'); //2
        afns.crearAFN('>'); //3
        afns.concatenar(2, 3); //2
    }

    private static void afnEPSILON(AFNs afns){
        afns.crearAFN('\\'); //4
        afns.crearAFN('e');  //5
        afns.crearAFN('E');  //6
        afns.union(5, 6);
        afns.concatenar(4, 5); //2
    }
}

