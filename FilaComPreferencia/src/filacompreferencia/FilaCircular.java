/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filacompreferencia;

/**
 *
 * @author aluno
 */
public class FilaCircular {
    static final int tamanhoFila = 5;
    static String filaPref[] = new String[tamanhoFila];
    static String filaNorm[] = new String[tamanhoFila];
    static int inicioPref = -1;
    static int inicioNorm = -1;
    static int fimPref = -1;
    static int fimNorm = -1;
    static int elementosPref = 0;
    static int elementosNorm = 0;
    
    static boolean PrefestaCheia(){
         return elementosPref == tamanhoFila;
    }
    static boolean NormestaCheia(){  
         return elementosNorm == tamanhoFila;
    }
    static boolean PrefestaVazia(){
        return elementosPref == 0;
    }
    static boolean NormestaVazia(){
       return elementosNorm == 0;
    }
    
    static void pushPref(String nome){

        if (!PrefestaCheia()) {
            fimPref = (fimPref + 1) == filaPref.length ? 0 : fimPref+1;
            filaPref[fimPref] = nome;
            elementosPref++;
            inicioPref = (inicioPref == -1 ? 0 : inicioPref);          
        }else{
            throw new RuntimeException("FILA PREFERENCIAL CHEIA!");
        }
    }
    static void pushNorm(String nome){
        if (!NormestaCheia()) {
            fimNorm = (fimNorm + 1) == filaNorm.length ? 0:fimNorm+1;
            filaNorm[fimNorm] = nome;
            elementosNorm++;
            inicioNorm = (inicioNorm == -1 ? 0:inicioNorm);
        }
        else{
            throw new RuntimeException("FINAL NORMAL CHEIA!");
        }
    }
    static String pop(){
        String retorno;
        if (!PrefestaVazia()) {
            retorno = filaPref[inicioPref];
            filaPref[inicioPref] = null;
            inicioPref++;
            inicioPref = (inicioPref == filaPref.length? 0:inicioPref);
            elementosPref--;
        }else if (!NormestaVazia()) {
            retorno = filaNorm[inicioNorm];
            filaNorm[inicioNorm] = null;
            inicioNorm++;
            inicioNorm = (inicioNorm == filaNorm.length? 0:inicioNorm);
            elementosNorm--;
        }else{
            throw new RuntimeException("Duas filas Vazias");
        }
        return retorno;
        
    }
    public static String exibeFila(int n){
        String retorno = (" Fila Preferencial: "+filaPref[n]+" | "+" Fila normal: "+filaNorm[n]);
        return retorno;
    }

}
