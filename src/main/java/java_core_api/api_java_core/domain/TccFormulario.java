package java_core_api.api_java_core.domain;

import lombok.Data;

@Data
public class TccFormulario {
    private Long id;
    private Long tccId;

    // Etapa 1
    private String nomeCompleto;
    private String curso;
    private String instituicao;
    private String semestre;

    // Etapa 2
    private String tituloProvisorio;
    private String areaConhecimento;
    private String descricaoTema;

    // Etapa 3
    private String problema;
    private String objetivoGeral;
    private String objetivosEspecificos;
    private String importancia;

    // Etapa 4
    private String tipoPesquisa;
    private String comoConduzir;
    private String populacao;
    private String amostra;
    private String instrumentosColeta;

    // Etapa 5
    private String autores;
    private String conceitosChave;
    private String teoriasModelos;
}
