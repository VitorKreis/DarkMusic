package com.DarkMusic.DarkMusic.principal;

import java.util.Scanner;

public class Principal {


    static Scanner sc = new Scanner(System.in);



   static public  void Exibirmenu(){

       Integer opcao = 1;

       while (opcao != 0){
           System.out.println("""
                          ***DarkMusic***
                          1 - Adicionar um artista
                          2 - Adicionar uma musica
                          3 - Listar musicas
                          
                          0 - Sair
                          """);

           opcao = sc.nextInt();

           switch (opcao){
               case 1:
                   System.out.println("Add artista");
                   break;
               case 2:
                   System.out.println("Add musica");
                   break;
               case 3:
                   System.out.println("Listar as musicas!!");
                   break;
               case 0:
                   System.out.println("Saindo...");
                   break;
           }
       }

   }

}
