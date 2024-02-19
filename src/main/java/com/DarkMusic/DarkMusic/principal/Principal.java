package com.DarkMusic.DarkMusic.principal;

import com.DarkMusic.DarkMusic.models.Artista;
import com.DarkMusic.DarkMusic.models.Tipo;
import com.DarkMusic.DarkMusic.respoitory.artistaRepository;

import java.security.PrivateKey;
import java.util.List;
import java.util.Scanner;

public class Principal {


    static Scanner sc = new Scanner(System.in);
    artistaRepository repository;

    public Principal(artistaRepository repository) {
        this.repository = repository;
    }


    public  void Exibirmenu(){

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
                   adicionarArtista();
                   break;
               case 2:
                   adicionarMusica();
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



    private void adicionarArtista() {
        sc.nextLine();


        System.out.println("Nome do artista: ");
        var nome = sc.nextLine();

        System.out.println("O artista faz parte de qual desses tipo:(Solo, Banda, Dupla)");
        var tipo = sc.nextLine();

        //Tranforma o tipo digitado em classe tipo
        Tipo tipos = Tipo.ToPortugues(tipo);

        Artista artista = new Artista();

        //Seta os dados do artista
        artista.setNome(nome);
        artista.setTipo(tipos);

        //Salva o artista no banco
        repository.save(artista);
    }


    private void adicionarMusica() {

        sc.nextLine();


        System.out.println("Nome da Musica: ");
        var nomeMusica = sc.nextLine();

        List<Artista> artistas = repository.findAll();

        artistas.forEach(System.out::println);
        System.out.println("Nome do artista: ");
        var nomeArtista = sc.nextLine();

    }


}
