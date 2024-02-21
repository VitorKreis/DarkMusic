package com.DarkMusic.DarkMusic.principal;

import com.DarkMusic.DarkMusic.models.Artista;
import com.DarkMusic.DarkMusic.models.Musicas;
import com.DarkMusic.DarkMusic.models.Tipo;
import com.DarkMusic.DarkMusic.respoitory.artistaRepository;
import com.DarkMusic.DarkMusic.respoitory.musicaRepository;

import java.security.PrivateKey;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {


    static Scanner sc = new Scanner(System.in);
    artistaRepository repositoryArtista;
    musicaRepository repositoryMusica;

    public Principal(artistaRepository artistaRepository, musicaRepository musicaRepository ) {

        this.repositoryArtista = artistaRepository;
        this.repositoryMusica = musicaRepository;
    }


    public  void Exibirmenu(){

       Integer opcao = 1;

       while (opcao != 0){
           System.out.println("""
                          ***DarkMusic***
                          1 - Adicionar um artista
                          2 - Adicionar uma musica
                          3 - Listar artistas
                          4 - Listar musicas
                          5 - Listar muiscas por Artista
                          
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
                   listarArtistas();
                   break;
               case 4:
                   listarMusicas();
                   break;
               case 5:
                   listarMusicasPorArtista();
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

        //Seta os dados de artista
        Artista artista = new Artista(nome, tipos);


        //Salva o artista no banco
        repositoryArtista.save(artista);
    }


    private void adicionarMusica() {

        sc.nextLine();


        System.out.println("Nome da Musica: ");
        var nomeMusica = sc.nextLine();

        System.out.println("Nome do artista: ");
        var nomeArtista = sc.nextLine();


        Optional<Artista> artistaEscolhido = repositoryArtista.findByNomeContainingIgnoreCase(nomeArtista);


            Artista artista = artistaEscolhido.get();

            Musicas musica = new Musicas();

            musica.setNome(nomeMusica);
            musica.setArtista(artista);

            repositoryMusica.save(musica);



    }


    private void listarArtistas() {
        List<Artista> artistas = repositoryArtista.findAll();

        artistas.forEach(System.out::println);
    }

    private void listarMusicas(){
        List<Musicas> musicas = repositoryMusica.findAll();

        musicas.forEach(System.out::println);
     }

      private void listarMusicasPorArtista(){
            sc.nextLine();

          System.out.println("Nome do artista: ");
          var nomeArtista = sc.nextLine();

          Optional<Artista> artistaEscolhido = repositoryArtista.findByNomeContainingIgnoreCase(nomeArtista);


          if(artistaEscolhido.isPresent()){
              Artista artista = artistaEscolhido.get();

              List<Musicas> musicas = repositoryMusica.findByArtista_id(artista.getId());

              musicas.forEach(System.out::println);
          }

     }


}
