package java_core_api.api_java_core.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import java.util.Map;

@FeignClient(name = "openaiClient", url = "${openai.api.url}")
public interface OpenAiClient {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String, Object> gerarResposta(
            @RequestHeader("Authorization") String authorization,
            @RequestBody Map<String, Object> body
    );
}
