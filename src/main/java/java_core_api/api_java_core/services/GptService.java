package java_core_api.api_java_core.services;


import java_core_api.api_java_core.cliente.OpenAiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GptService {

    @Autowired
    private OpenAiClient openAiClient;

    @Value("${openai.api.key}")
    private String apiKey;


    public String gerarResposta(String pergunta) {

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", List.of(
                        Map.of("role", "user", "content", pergunta)
                )
        );

        try {
            Map<String, Object> response = openAiClient.gerarResposta(
                    "Bearer " + apiKey,
                    requestBody
            );

            List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
            Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");

            return message.get("content").toString().trim();

        } catch (Exception e) {
            return "Erro ao se comunicar com a OpenAI: " + e.getMessage();
        }
    }
}
