package br.com.alura.desafio.principal;

import br.com.alura.desafio.dtos.ArtistaDto;
import br.com.alura.desafio.dtos.DadosBuscadosDto;
import br.com.alura.desafio.dtos.DadosMuscicasBuscadosDto;
import br.com.alura.desafio.dtos.MusicaDto;
import br.com.alura.desafio.model.Artista;
import br.com.alura.desafio.model.Musica;
import br.com.alura.desafio.repository.ArtistaRepository;
import br.com.alura.desafio.service.ConsultaChatGTP;
import br.com.alura.desafio.service.ConsumoAPI;
import br.com.alura.desafio.service.ConverteDados;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import static br.com.alura.desafio.service.ConsultaChatGTP.pesquisa;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private final String URL_DEEZER_PESQUISA = "https://api.deezer.com/search/artist/?q=";
    private final String URL_DEEZER_MUSICAS = "https://api.deezer.com/artist/";
    private final String LIMITE_DE_MUSICAS = "/top?limit=10";
    private ConsumoAPI api = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private ArtistaRepository repository;
    private List<ArtistaDto> listaBuscada;

    public Principal(ArtistaRepository repository) {
        this.repository = repository;
    }

    public void exibeMenu(){
        var opcao = -1;
        while (opcao != 9){
            var menu = """
                    \n*** Screen Sound Música ***
                    
                    1 - Cadastrar artista ou banda
                    2 - Cadastrar músicas por artista
                    3 - Listar artistas
                    4 - Listar musicas
                    5 - Saiba mais sobre artista
                    
                    9 - Sair
                    """;
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusicarPorArtista();
                    break;
                case 3:
                    listarArtistas();
                    break;
                case 4:
                    listarMusicas();
                    break;
                case 5:
                    consultaGPT();
                    break;
                case 9:
                    System.out.println("saindo ....");
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;

            }

        }
    }




    private void cadastrarArtista() {
        System.out.println("Informe o nome desse artista:");
        var nomeArtista = leitura.nextLine();
        buscarArtista(nomeArtista);


        System.out.println("\nDigite o codigo do artista que deseja cadastrar");
        var idArtista = leitura.nextLong();
        leitura.nextLine();


        for(ArtistaDto a :listaBuscada){
            if (a.id() == idArtista){
                repository.save(new Artista(a));
                System.out.println("*** Salvo com sucesso ***\nAcesse a opção 3 para o ver!");
            }
        }
    }

    private void buscarArtista(String nomeArtista) {
        var json = api.obterDados(URL_DEEZER_PESQUISA+nomeArtista.replace(" ", "+").toLowerCase().trim());
        DadosBuscadosDto dados = conversor.obterDados(json, DadosBuscadosDto.class);
        listaBuscada = dados.data();
        System.out.println("*** Arstistas encontrados ***");
        listaBuscada.forEach(a->System.out.printf(
                "Codigo: %s - Nome: %s \n",
                a.id(), a.nome()
        ));
    }

    private void listarArtistas() {
        List<Artista> artistas = repository.findAll();
        System.out.println("*** Artistas ***");
       if (artistas.size()>0){
           for (Artista a : artistas){
               System.out.println(a);
           }
       }else {
           System.out.println("Ainda não tem artistas salvos\n");
       }

    }
    private void cadastrarMusicarPorArtista() {
        listarArtistas();
        System.out.println("\nDigite o codigo do artista que voce deseja cadastrar as musicas!");
        var codigo = leitura.nextLong();
        Optional<Artista> artista = repository.findByCodigoDeezer(codigo);
        if (artista.isPresent()){

        var json = api.obterDados(URL_DEEZER_MUSICAS+codigo+LIMITE_DE_MUSICAS);
        DadosMuscicasBuscadosDto dados = conversor.obterDados(json, DadosMuscicasBuscadosDto.class);
        List<MusicaDto> musicasBuscadas = dados.data();
        musicasBuscadas.forEach(m-> System.out.printf(
                "Nome da musica: %s - Ouça agora mesmo no deezer: %s\n",m.titulo(),m.OucaNoDezeer()
        ));

            var musicas = musicasBuscadas.stream()
                    .map(Musica::new)
                    .collect(Collectors.toList());
            for (Musica m : musicas){
                m.setArtista(artista.get());
            }
            artista.get().setListaMusicas(musicas);
            repository.save(artista.get());
            System.out.println("Salvo com sucesso!");
        }else {
            System.out.println("Id não encontrado!");
        }

    }
    private void listarMusicas() {
        listarArtistas();
        System.out.println("\nDigite o nome do artista que voce deseja buscar as musicas!");
        var nomeArtista = leitura.nextLine();


        var artista = repository.buscaPorNome(nomeArtista);
        if(artista.isPresent()){
            System.out.println(artista.get());
            artista.get().getListaMusicas().forEach(m-> System.out.printf(
                    "Nome da musica: %s - Ouça agora mesmo no deezer: %s\n",m.getTitulo(),m.getOucaNoDezeer()
            ));
        }else {
            System.out.println("Artista não encontrado com esse nome: " + nomeArtista);
        }
    }
    private void consultaGPT() {
        listarArtistas();
        System.out.println("\nDigite o nome do artista que voce deseja buscar a historia!");
        var nomeArtista = leitura.nextLine();

        var artista = repository.buscaPorNome(nomeArtista);

        var texto = pesquisa(artista.get().getNome());
        System.out.println(texto);

    }

}
