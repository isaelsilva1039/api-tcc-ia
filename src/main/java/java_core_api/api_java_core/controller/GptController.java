package java_core_api.api_java_core.controller;

import java_core_api.api_java_core.cliente.GptClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gpt")
public class GptController {

    @Autowired
    private GptClient gptClient;

    @GetMapping("/responder")
    public ResponseEntity<String> responder(@RequestParam String pergunta) {
        String resposta = gptClient.gerarResposta(pergunta);
        return ResponseEntity.ok(resposta);
    }
}
