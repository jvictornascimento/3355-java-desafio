package br.com.alura.desafio.enums;

public enum Tipo {
    ARTISTA("artist"),
    DUPLA("pair"),
    BANDA("band");
    private String categoriaDeezer;

    Tipo(String categoriaDeezer){
        this.categoriaDeezer = categoriaDeezer;
    }

    public static Tipo fromString(String text){
        for(Tipo tipo : Tipo.values()){
            if (tipo.categoriaDeezer.equalsIgnoreCase(text)){
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nenhum tipo encontrado com a string fornecida: " + text);
    }
}
