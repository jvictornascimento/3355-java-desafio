package br.com.alura.desafio.principal;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);

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


}
