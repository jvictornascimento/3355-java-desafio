package br.com.alura.desafio.principal;

import br.com.alura.desafio.dtos.ArtistaDto;
import br.com.alura.desafio.dtos.DadosBuscadosDto;
import br.com.alura.desafio.model.Artista;
import br.com.alura.desafio.repository.ArtistaRepository;
import br.com.alura.desafio.service.ConsumoAPI;
import br.com.alura.desafio.service.ConverteDados;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private final String URL_DEEZER_PESQUISA = "https://api.deezer.com/search/artist/?q=";
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
                    *** Screen Sound Música ***
                    
                    1 - Cadastrar Artista
                    2 - Cadastrar músicas
                    3 - Listar artistas
                    4 - Listar musicas
                    5 - buscar música por artista
                    6 - Pesquisar dados sobre um artista
                    
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
                    break;
                case 3:
                    listarArtistas();
                    break;
                case 4:
                    break;
                case 5:
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
        var idArtista = leitura.nextInt();
        leitura.nextLine();

        //modificar!

//        if(listaBuscada.get(idArtista)!=null){
//            Artista novoArtista = new Artista(listaBuscada.get(idArtista));
//            repository.save(novoArtista);
//            System.out.println("Salvo com sucesso\n Acesse a opção 3 para o ver!");
//        }else {
//            System.out.println("Codigo invalido");
//        }




    }

    private void buscarArtista(String nomeArtista) {
        var json = api.obterDados(URL_DEEZER_PESQUISA+nomeArtista.replace(" ", "+").toLowerCase().trim());
        System.out.println(json);
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
       if (artistas.size()>0){
           artistas.forEach(a-> System.out.printf("Codigo: %s - Nome: %s \n" +
                   a.getId(), a.getNome()));
       }else {
           System.out.println("Ainda não tem artistas salvos\n");
       }

    }

}
