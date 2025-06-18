package java_core_api.api_java_core.controller;

import java_core_api.api_java_core.domain.Tcc;
import java_core_api.api_java_core.domain.TccFormulario;
import java_core_api.api_java_core.services.GptService;
import java_core_api.api_java_core.services.TccFormularioService;
import java_core_api.api_java_core.services.TccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/criar-tcc")
public class CriarTccAiController {

    @Autowired
    private GptService gptService;

    @Autowired
    private TccFormularioService tccFormularioService;

    @Autowired
    private TccService tccsService;

    @PostMapping
    public ResponseEntity<?> criarETentarGerar(@RequestBody TccFormulario formulario) {
        try {
            // 1. Cria o TCC (sem conteúdo ainda)
            Tcc tcc = new Tcc();
            tcc.setUsuarioId(7); // esse ID do usuário pode vir via auth futuramente
            tcc.setTitulo(formulario.getTituloProvisorio());
            tcc.setStatus("CRIADO");
            tcc.setCriadoEm(LocalDateTime.now());
            tccsService.salvar(tcc);

            // 2. Salva o formulário com o ID gerado
            formulario.setTccId(tcc.getId());
            tccFormularioService.salvar(formulario);

            // 3. Gera o prompt com base no formulário salvo
            String prompt = tccFormularioService.gerarPrompt(formulario);

            // 4. Envia para a OpenAI
            String resposta = gptService.gerarResposta(prompt);

            // 5. Atualiza o TCC com o conteúdo final
            tcc.setConteudo(resposta);
            tcc.setStatus("GERADO");
            tccsService.atualizar(tcc);

            return ResponseEntity.ok(tcc);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao gerar TCC: " + e.getMessage());
        }
    }
}
