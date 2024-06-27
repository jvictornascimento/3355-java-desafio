package br.com.alura.desafio.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGTP {
    public static String pesquisa(String texto){
        String secret = System.getenv("TOKEN_OPENAI");
        OpenAiService service = new OpenAiService(secret);
        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("historia e carreira de: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();
        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
