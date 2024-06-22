package br.com.alura.desafio.principal;

import br.com.alura.desafio.dtos.ArtistaDto;
import br.com.alura.desafio.dtos.DadosBuscadosDto;
import br.com.alura.desafio.service.ConsumoAPI;
import br.com.alura.desafio.service.ConverteDados;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private final String URL_DEEZER_PESQUISA = "https://api.deezer.com/search/artist/?q=";
    private ConsumoAPI api = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    public Principal() {
    }

    public void exibeMenu(){
        var opcao = -1;
        while (opcao != 9){
            var menu = """
                    *** Screen Sound Música ***
                    
                    1 - Cadastrar Artista
                    2 - Cadastrar música
                    3 - Listar mpusica
                    4 - buscar música por artista
                    5 - Pesquisar dados sobre um artista
                    
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


        System.out.println("Digite o codigo do artista que deseja cadastrar");
        var idArtista = leitura.nextInt();
        leitura.nextLine();



    }

    private void buscarArtista(String nomeArtista) {
        var json = api.obterDados(URL_DEEZER_PESQUISA+nomeArtista.replace(" ", "+").toLowerCase().trim());
        System.out.println(json);
        DadosBuscadosDto dados = conversor.obterDados(json, DadosBuscadosDto.class);
        List<ArtistaDto> lista = dados.data();
        System.out.println("*** Arstistas encontrados ***");
        lista.forEach(a->System.out.printf(
                "Codigo: %s - Nome: %s \n",
                a.id(), a.nome()
        ));
    }


}
