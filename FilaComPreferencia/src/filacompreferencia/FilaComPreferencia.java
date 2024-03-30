/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filacompreferencia;

import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class FilaComPreferencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean funcionamento = true;
        while(funcionamento){
            System.out.println("FILAS COM PREFERENCIAS:");
            System.out.println("1-Cadastrar pessoa na fila:");
            System.out.println("2-Chamar pessoa da fila:");
            System.out.println("3-Exibir as filas");
            System.out.println("4-Sair do programa");
            int acao = teclado.nextInt();
            switch (acao) {
                case 1 -> {
                    System.out.println("Pessoa a ser cadastrada pertence a fila preferencial?[S/N]");
                    char fila = teclado.next().toUpperCase().charAt(0);
                    if (fila == 'S') {
                        System.out.println("informe o nome da mesma:");
                        String nome=teclado.next();
                        try{
                            FilaCircular.pushPref(nome);
                            System.out.println("------------------\n");
                            System.out.println(nome.toUpperCase() +" Adicionado a fila Preferencial, com sucesso!");
                            System.out.println("\n------------------");
                        }catch(RuntimeException e){
                            System.out.println("------------------\n");
                            System.out.println(e.getMessage());
                            System.out.println("\n------------------");
                        }
                        
                    }else if (fila == 'N') {
                        System.out.println("informe o nome do paciente:");
                        String nome=teclado.next();
                        try{
                            FilaCircular.pushNorm(nome);
                            System.out.println("------------------\n");
                            System.out.println(nome.toUpperCase() +" Adicionado a fila Normal, com sucesso!");
                            System.out.println("\n------------------");
                        }catch(RuntimeException e){
                            System.out.println("------------------\n");
                            System.out.println(e.getMessage());
                            System.out.println("\n------------------");
                        }   
                    }
                }
                case 2 -> {
                    try{
                        System.out.println("------------------\n");
                        System.out.println("CHAMANDO: "+ FilaCircular.pop());
                        System.out.println("\n------------------");
                    }catch(RuntimeException e){
                        System.out.println(e.getMessage());
                        System.out.println("\n------------------");
                    }
                }
                case 3 -> {
                    for (int i = 0; i < FilaCircular.tamanhoFila; i++) {
                        System.out.println(FilaCircular.exibeFila(i));
                    }
                }
                case 4 -> {
                    System.out.println("Tem certeza que deseja sair?[S/N]");
                    char sair = teclado.next().toUpperCase().charAt(0);
                    funcionamento = sair == 'S'?false:true;
                }
            }          
        }
    }
}
    

