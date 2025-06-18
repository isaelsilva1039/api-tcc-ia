package java_core_api.api_java_core.services;

import java_core_api.api_java_core.domain.TccFormulario;
import java_core_api.api_java_core.mapper.TccFormularioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TccFormularioService {

    @Autowired
    private TccFormularioMapper mapper;

    public List<TccFormulario> listarTodos() {
        return mapper.listarTodos();
    }

    public void salvar(TccFormulario formulario) {
        mapper.salvar(formulario);
    }

    public void atualizar(TccFormulario formulario) {
        mapper.atualizar(formulario);
    }

    public void deletar(Long id) {
        mapper.deletar(id);
    }

    public TccFormulario buscarPorId(Long id) {
        return mapper.buscarPorId(id);
    }

    public TccFormulario buscarPorTccId(Long tccId) {
        return mapper.buscarPorTccId(tccId);
    }

    public String gerarPrompt(Long tccId) {
        TccFormulario f = buscarPorTccId(tccId);
        if (f == null) return "Formulário não encontrado.";
        return gerarPrompt(f);
    }

    public String gerarPrompt(TccFormulario f) {
        return """
                Estou criando um TCC e coletei as seguintes informações para gerar o conteúdo:

                👤 Dados Pessoais
                - Nome: %s
                - Curso: %s
                - Instituição: %s
                - Semestre/Período: %s

                📚 Tema do TCC
                - Título Provisório: %s
                - Área de Conhecimento: %s
                - Descrição: %s

                🎯 Problema e Objetivos
                - Problema: %s
                - Objetivo Geral: %s
                - Objetivos Específicos: %s
                - Importância do Tema: %s

                🔍 Metodologia
                - Tipo de Pesquisa: %s
                - Como será conduzida: %s
                - População: %s
                - Amostra: %s
                - Instrumentos de Coleta: %s

                📖 Referencial Teórico
                - Autores: %s
                - Conceitos-Chave: %s
                - Teorias/Modelos: %s

                Gere um conteúdo acadêmico coerente e bem estruturado para meu TCC baseado nessas informações. 
                Use linguagem formal, clara e seguindo estrutura de introdução, desenvolvimento e conclusão.
                """.formatted(
                f.getNomeCompleto(), f.getCurso(), f.getInstituicao(), f.getSemestre(),
                f.getTituloProvisorio(), f.getAreaConhecimento(), f.getDescricaoTema(),
                f.getProblema(), f.getObjetivoGeral(), f.getObjetivosEspecificos(), f.getImportancia(),
                f.getTipoPesquisa(), f.getComoConduzir(), f.getPopulacao(), f.getAmostra(), f.getInstrumentosColeta(),
                f.getAutores(), f.getConceitosChave(), f.getTeoriasModelos()
        );
    }
}
