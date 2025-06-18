package java_core_api.api_java_core.mapper;

import java_core_api.api_java_core.domain.TccFormulario;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TccFormularioMapper {
    List<TccFormulario> listarTodos();
    void salvar(TccFormulario formulario);
    void atualizar(TccFormulario formulario);
    void deletar(Long id);
    TccFormulario buscarPorId(Long id);
    TccFormulario buscarPorTccId(Long tccId);
}
