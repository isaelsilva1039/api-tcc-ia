package java_core_api.api_java_core.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Tcc {
    private Long id;
    private Integer usuarioId;
    private String titulo;
    private String conteudo;
    private String status;
    private LocalDateTime criadoEm;
}
